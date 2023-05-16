package com.studentdetails.controller;

import com.studentdetails.model.Course;
import com.studentdetails.model.Student;
import com.studentdetails.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping(value = "all")
    public ResponseEntity<List<Course>> getAllStudent() {
        return courseService.getAllCourse();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addStudent(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable String id) {
        return courseService.deleteCourseById(id);
    }
}
