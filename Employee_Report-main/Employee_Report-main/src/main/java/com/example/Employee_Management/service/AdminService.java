package com.example.Employee_Management.service;

import com.example.Employee_Management.model.Employee;
import com.example.Employee_Management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<String> createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee Details Successfully");
    }
}
