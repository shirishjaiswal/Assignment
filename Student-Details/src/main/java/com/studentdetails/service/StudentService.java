package com.studentdetails.service;

import com.studentdetails.model.Student;
import com.studentdetails.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> all = studentRepo.findAll();
        if(all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addStudent(Student student) {
        Student save = studentRepo.save(student);
        if(save != null) {
            return  new ResponseEntity<>("Student Saved", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteStudentById(String id) {
        if(studentRepo.existsById(Integer.parseInt(id))) {
            studentRepo.deleteById(Integer.parseInt(id));
            if(studentRepo.existsById(Integer.parseInt(id))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Student Deleted", HttpStatus.OK);
        }
        else return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }
}
