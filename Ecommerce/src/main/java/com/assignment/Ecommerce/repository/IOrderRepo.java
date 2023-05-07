package com.assignment.Ecommerce.repository;

import com.assignment.Ecommerce.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<OrderDetails, Integer> {
}
