package com.studentdetails.controller;

import com.studentdetails.model.Student;
import com.studentdetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "all")
    public ResponseEntity<List<Student>> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable String id) {
        return studentService.deleteStudentById(id);
    }
}
