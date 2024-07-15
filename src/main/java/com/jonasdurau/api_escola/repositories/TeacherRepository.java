package com.jonasdurau.api_escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jonasdurau.api_escola.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}