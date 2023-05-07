package com.assignment.Ecommerce.controller;

import com.assignment.Ecommerce.model.OrderDetails;
import com.assignment.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/{id}")
    public Optional<OrderDetails> getById(@PathVariable String id){
        return orderService.getById(id);
    }

    @PostMapping (value = "/insert")
    public String createOrder(@RequestBody OrderDetails orderDetails){
        return orderService.createOrder(orderDetails);
    }

}
