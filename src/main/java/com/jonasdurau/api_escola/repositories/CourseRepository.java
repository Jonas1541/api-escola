package com.jonasdurau.api_escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jonasdurau.api_escola.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}