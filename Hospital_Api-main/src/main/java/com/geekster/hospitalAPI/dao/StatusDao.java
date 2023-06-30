package com.geekster.hospitalAPI.dao;

import com.geekster.hospitalAPI.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status,Integer> {
}
