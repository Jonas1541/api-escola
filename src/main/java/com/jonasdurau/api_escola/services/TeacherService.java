package com.jonasdurau.api_escola.services;

import com.jonasdurau.api_escola.models.Course;
import com.jonasdurau.api_escola.models.Teacher;
import com.jonasdurau.api_escola.repositories.CourseRepository;
import com.jonasdurau.api_escola.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher save(Teacher teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }

    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher update(Teacher teacher) {
        if (teacherRepository.existsById(teacher.getId())) {
            return teacherRepository.save(teacher);
        }
        return null;
    }

    public Teacher addCourse(Long teacherId, Long courseId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (teacher != null && course != null) {
            teacher.addCourse(course);
            return teacherRepository.save(teacher);
        }
        return null;
    }
    
    public Teacher removeCourse(Long teacherId, Long courseId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (teacher != null && course != null) {
            teacher.removeCourse(course);
            return teacherRepository.save(teacher);
        }
        return null;
    }
    
}
