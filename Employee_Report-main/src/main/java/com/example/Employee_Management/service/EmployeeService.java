package com.example.Employee_Management.service;

import com.example.Employee_Management.model.Employee;
import com.example.Employee_Management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).isPresent() ? employeeRepository.findById(id).get(): null;
    }


    public ResponseEntity<String> updateEmployeeById(Long id, Employee employee) {
        Employee employee1 = this.getEmployeeById(id);
        if(employee1 == null)   return ResponseEntity.noContent().build();
        if(employee.getFirstName() != null){
            employee1.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName() != null){
            employee1.setLastName(employee.getLastName());
        }
        if(employee.getEmail() != null){
            employee1.setEmail(employee.getEmail());
        }
        if(employee.getPhoneNumber()!= null){
            employee1.setPhoneNumber(employee.getPhoneNumber());
        }
        employeeRepository.save(employee1);
       return ResponseEntity.accepted().body("Updated successfully");
    }
}
