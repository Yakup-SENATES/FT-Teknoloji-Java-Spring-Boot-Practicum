package com.jacopx.comments.repository;

import com.jacopx.comments.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByExpiryDateAfter(LocalDateTime now);

    List<Product> findByExpiryDateBefore(LocalDateTime now);

}
