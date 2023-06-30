package com.geekster.hospitalAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private String email;
    private String phoneNumber;
    @ManyToOne
    private Speciality speciality;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}
