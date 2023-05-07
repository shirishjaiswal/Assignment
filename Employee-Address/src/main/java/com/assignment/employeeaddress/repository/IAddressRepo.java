package com.assignment.employeeaddress.repository;

import com.assignment.employeeaddress.model.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressRepo extends JpaRepository<Address, Long> {
//    @Modifying
//    @Transactional
//    @Query(value = "Select * from address", nativeQuery = true)
//    List<Address> getAll();
}
