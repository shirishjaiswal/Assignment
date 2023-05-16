package com.studentdetails.service;

import com.studentdetails.model.Course;
import com.studentdetails.model.Student;
import com.studentdetails.repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;

    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> all = courseRepo.findAll();
        if(all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addCourse(Course course) {
        Course save = courseRepo.save(course);
        if(save != null) {
            return  new ResponseEntity<>("Course Saved", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteCourseById(String id) {
        if(courseRepo.existsById(Integer.parseInt(id))) {
            courseRepo.deleteById(Integer.parseInt(id));
            if(courseRepo.existsById(Integer.parseInt(id))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
    }
}
