package com.assignment.UniversityEventManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;
    @Length (min = 3, max = 20)
    private String firstName;
    @Length (min = 3, max = 20)
    private String lastName;
    @Min(value = 18, message = "Age should be greatest than or equals 18")
    @Max(value = 25, message = "Age should be less than or equals 25")
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Department department;
}
