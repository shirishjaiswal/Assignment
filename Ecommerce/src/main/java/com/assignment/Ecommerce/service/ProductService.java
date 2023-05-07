package com.assignment.Ecommerce.service;

import com.assignment.Ecommerce.model.Product;
import com.assignment.Ecommerce.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    IProductRepo productRepo;

    //GET - ALL
    public Iterable<Product> getAll(String Category) {
        return productRepo.findAll();
    }

    //POST
    public String addProduct(Product product) {
        Product saved = productRepo.save(product);
        if(saved != null) {
            return "Product saved with id : " + product.getId();
        }
        return "Product is not saved";
    }

    //DELETE
    public String deleteById(String id) {
        productRepo.deleteById(Integer.parseInt(id));
        if(!productRepo.existsById(Integer.parseInt(id)))
            return  "Product with id : " + id + " has been deleted";
        return "Product Deletion Failed";
    }
}
