package com.assignment.Ecommerce.controller;

import com.assignment.Ecommerce.model.Product;
import com.assignment.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/all/{category}")
    public Iterable<Product> getAll(@PathVariable String category){
        return productService.getAll(category);
    }
    @PostMapping(value = "/insert")
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable String id){
        return productService.deleteById(id);
    }
}
