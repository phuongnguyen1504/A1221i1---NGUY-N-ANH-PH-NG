package com.example.service;

import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IGeneralService<Product> {
    @Autowired
    private ProductService productService;

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }
    public void delete(int id){
        productService.delete(id);
    }
    public Optional<Product> findById(int id){
        return productService.findById(id);
    }
}
