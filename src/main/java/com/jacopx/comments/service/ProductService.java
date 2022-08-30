package com.jacopx.comments.service;

import com.jacopx.comments.entity.Product;
import com.jacopx.comments.entity.ProductComment;
import com.jacopx.comments.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getOldProducts() {
        return productRepository.findByExpiryDateBefore(LocalDateTime.now());
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getNewProducts() {
        return productRepository.getNewProducts();
    }

}
