package com.thi_md5_be.service;

import com.thi_md5_be.model.Product;
import com.thi_md5_be.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IGeneralService<Product> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Page<Product> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
    public void delete(int id){
        productRepository.deleteById(id);
    }
    public Optional<Product> findById(int id){
        return productRepository.findById(id);
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<Product> find(String q, Pageable pageable) {

        return productRepository.findAllByValue("%".concat(q).concat("%"),pageable);
    }

    public void update(int id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }
}
