package com.assignment.employeeaddress.service;

import com.assignment.employeeaddress.model.Address;
import com.assignment.employeeaddress.model.Employee;
import com.assignment.employeeaddress.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo employeeRepo;

    //GET /employees - get all employees
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    //GET /employees/{id} - get an employee by id
    public Optional<Employee> getById(Long id) {
        return employeeRepo.findById(id);
    }

    //POST/employees - create a new employee
    public String save(Employee employee) {
        Employee saved = employeeRepo.save(employee);
        if(saved != null) return "Employee Saved";
        return "Employee Not Saved";
    }

    //PUT/employees/{id} - update an employee by id
    public String updateEmployee(Employee employee, Long id) {
        employee.setId(id);
        Employee updated = employeeRepo.save(employee);
        if(updated != null) return "Employee with id " + id + " updated";
        return "Employee with id " + id + " not updated";
    }

    //DELETE/employees/{id} - delete an employee by id
    public String deleteById(Long id) {
        employeeRepo.deleteById(id);
        if(!employeeRepo.existsById(id)) return "Employee with id : " + id + " has been deleted";
        return "Employee with id : " + id + " has not been deleted";
    }
}
