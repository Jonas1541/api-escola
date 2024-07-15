package com.jonasdurau.api_escola.controllers;

import com.jonasdurau.api_escola.models.Teacher;
import com.jonasdurau.api_escola.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Teacher findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @PostMapping
    public Teacher save(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return teacherService.update(teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }

    @PutMapping("/{id}/add-course/{courseId}")
    public Teacher addCourse(@PathVariable Long id, @PathVariable Long courseId) {
        return teacherService.addCourse(id, courseId);
    }

    @PutMapping("/{id}/remove-course/{courseId}")
    public Teacher removeCourse(@PathVariable Long id, @PathVariable Long courseId) {
        return teacherService.removeCourse(id, courseId);
    }

}
