package com.studentdetails.service;

import com.studentdetails.model.Laptop;
import com.studentdetails.model.Student;
import com.studentdetails.repository.ILaptopRepo;
import com.studentdetails.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepo laptopRepo;

    @Autowired
    IStudentRepo studentRepo;

    public ResponseEntity<List<Laptop>> getAllLaptop() {
        List<Laptop> all = laptopRepo.findAll();
        if (all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addLaptop(Laptop laptop) {
        Laptop save = null;
        if (studentRepo.existsById(laptop.getStudent().getId()) &&
                laptopRepo.findByStudentId(laptop.getStudent().getId()).isEmpty()) {
            save = laptopRepo.save(laptop);
            if (save != null) {
                return new ResponseEntity<>("Laptop Saved", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Laptop Not Saved", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("Student already Have Laptop", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> deleteLaptopById(String id) {
        if (laptopRepo.existsById(Integer.parseInt(id))) {
            laptopRepo.deleteById(Integer.parseInt(id));
            if (laptopRepo.existsById(Integer.parseInt(id))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Laptop Deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Laptop Not Found", HttpStatus.NOT_FOUND);
    }
}
