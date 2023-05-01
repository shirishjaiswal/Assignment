package com.assignment.UniversityEventManagement.controller;

import com.assignment.UniversityEventManagement.model.Student;
import com.assignment.UniversityEventManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/all")
    public Iterable<Student> getAllStudents (){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/byId/{id}")
    public Optional<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping(value = "/insert")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping(value = "/byId/{id}")
    public String deleteStudentById(@PathVariable String id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping(value = "/byDtp/{dtp}/for/{id}")
    public String updateStudentDtp(@PathVariable String dtp, @PathVariable String id){
        return studentService.updateStudentDtp(dtp, id);
    }
}
