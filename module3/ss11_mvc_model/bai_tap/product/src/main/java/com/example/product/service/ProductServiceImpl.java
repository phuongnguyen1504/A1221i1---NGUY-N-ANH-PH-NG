package com.example.product.service;

import com.example.product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1, "Nokia 590",123.00, "d1", "Nokia"));
        products.put(2,new Product(2, "SamSung A80", 123.11, "d2", "Samsung"));
        products.put(3,new Product(3, "Iphone 13", 123.22, "d3", "Apple"));
        products.put(4,new Product(4, "Test 13", 123.33, "d3", "Test"));
        products.put(5,new Product(5, "LG 139", 123.44, "d3", "LG"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
