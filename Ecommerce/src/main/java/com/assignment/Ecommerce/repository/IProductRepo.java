package com.assignment.Ecommerce.repository;

import com.assignment.Ecommerce.model.OrderDetails;
import com.assignment.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(nativeQuery = true, value = "select * from product where category = : category")
    List<OrderDetails> getByCategory(@Param("category")String category);
}
