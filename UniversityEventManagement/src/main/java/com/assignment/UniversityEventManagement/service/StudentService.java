package com.assignment.UniversityEventManagement.service;

import com.assignment.UniversityEventManagement.model.Department;
import com.assignment.UniversityEventManagement.model.Student;
import com.assignment.UniversityEventManagement.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;
    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepo.findById(Integer.parseInt(id));
    }

    public String addStudent(Student student) {
        Student student1 = studentRepo.save(student);
        return "Student is saved";
    }

    public String deleteStudentById(String id) {
        studentRepo.deleteById(Integer.parseInt(id));
        if(!studentRepo.existsById(Integer.parseInt(id))) {
            return "Student with id " + id + " has been deleted";
        }
        return "Student with id " + id + " has been not deleted";
    }

    public String updateStudentDtp(String dtp, String id) {
        String department = dtp.toUpperCase();
        Department dp = null;
        try {
            dp = Department.valueOf(department);
            int noOfRowsAffected = studentRepo.updateStudentSetDepartmentForId(department, Integer.parseInt(id));
            if(noOfRowsAffected > 0) {
                return "Student with id : " + id + " has been updated with department + " + dtp;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "Updating Filed of Student with id : " + id + " with department : " + dtp;
    }
}
