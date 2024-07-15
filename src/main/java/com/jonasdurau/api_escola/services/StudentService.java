package com.jonasdurau.api_escola.services;

import com.jonasdurau.api_escola.models.Course;
import com.jonasdurau.api_escola.models.Student;
import com.jonasdurau.api_escola.repositories.CourseRepository;
import com.jonasdurau.api_escola.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(Student student) {
        if(studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        return null;
    }

    public Student changeCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course newCourse = courseRepository.findById(courseId).orElse(null);
        if (student != null && newCourse != null) {
            if (student.getCourse() != null) {
                student.getCourse().removeStudent(student);
            }
            newCourse.addStudent(student);
            return studentRepository.save(student);
        }
        return null;
    }    
}
