package com.jacopx.comments.repository;

import com.jacopx.comments.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where expiry_date > NOW() OR expiry_date is null", nativeQuery = true)
    List<Product> getNewProducts();

    List<Product> findByExpiryDateBefore(LocalDateTime now);

}
