package com.jonasdurau.api_escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jonasdurau.api_escola.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}