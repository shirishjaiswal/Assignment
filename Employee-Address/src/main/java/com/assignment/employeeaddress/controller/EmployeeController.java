package com.assignment.employeeaddress.controller;

import com.assignment.employeeaddress.model.Employee;
import com.assignment.employeeaddress.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //GET /employees - get all employees
    @GetMapping (value = "/all")
    public List<Employee> getEmployees(){
        return employeeService.getAll();
    }

    //GET /addresses/{id} - get an address by id
    @GetMapping(value = "/{id}")
    public Optional<Employee> getAddress(@PathVariable Long id){
        return employeeService.getById(id);
    }

    //POST /employees - create a new employee

    @PostMapping (value = "/insert")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    //PUT /employees/{id} - update an employee by id
    @PutMapping(value = "/{id}")
    public String updateEmployee (@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    //DELETE /employees/{id} - delete an employee by id
    @DeleteMapping(value = "/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteById(id);
    }
}
