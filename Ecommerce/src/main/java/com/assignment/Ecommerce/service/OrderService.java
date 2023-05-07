package com.assignment.Ecommerce.service;

import com.assignment.Ecommerce.model.OrderDetails;
import com.assignment.Ecommerce.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;
    public Optional<OrderDetails> getById(String id) {
        return orderRepo.findById(Integer.parseInt(id));
    }

    public String createOrder(OrderDetails orderDetails) {
        OrderDetails saved = orderRepo.save(orderDetails);
        if(saved != null) {
            return "Order saved with id : " + orderDetails.getId();
        }
        return "Order is not saved";
    }
}
