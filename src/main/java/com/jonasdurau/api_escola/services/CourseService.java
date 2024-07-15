package com.jonasdurau.api_escola.services;

import com.jonasdurau.api_escola.models.Course;
import com.jonasdurau.api_escola.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Course course) {
        if(courseRepository.existsById(course.getId())) {
            return courseRepository.save(course);
        }
        return null;
    }
}
