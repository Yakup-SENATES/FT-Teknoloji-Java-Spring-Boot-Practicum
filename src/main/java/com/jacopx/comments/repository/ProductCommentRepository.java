package com.jacopx.comments.repository;

import com.jacopx.comments.entity.Product;
import com.jacopx.comments.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment,Long> {


    List<ProductComment> findByUserId( Long user_id );

    List<ProductComment> findByProductId(Product productId);

    @Query(value = "SELECT * FROM product_comment WHERE product_id = :productId and comment_date between :startDate and :endDate", nativeQuery = true)
    List<ProductComment> findByProductIdAndCreatedAtBetween(Long productId, String startDate, String endDate);

    @Query(value = "SELECT * FROM product_comment WHERE user_id = :userId and comment_date between :startDate and :endDate", nativeQuery = true)
    List<ProductComment> findByUserIdAndCreatedAtBetween(Long userId, String startDate, String endDate);

}
