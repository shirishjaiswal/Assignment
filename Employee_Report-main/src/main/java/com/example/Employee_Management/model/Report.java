package com.example.Employee_Management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String employeePerformance;

    private boolean attendance;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Constructors, getters, and setters
}

