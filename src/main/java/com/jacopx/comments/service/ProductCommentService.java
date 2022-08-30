package com.jacopx.comments.service;

import com.jacopx.comments.entity.Product;
import com.jacopx.comments.entity.ProductComment;
import com.jacopx.comments.exception.UserNotFoundException;
import com.jacopx.comments.repository.ProductCommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCommentService {

    private final ProductCommentRepository productCommentRepository;

    public ProductCommentService(ProductCommentRepository productCommentRepository) {
        this.productCommentRepository = productCommentRepository;
    }


    public List<ProductComment> findByUserId(Long userId) {
        List<ProductComment> commentList = productCommentRepository.findByUserId(userId);
        if (commentList.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return commentList;
    }

    public List<ProductComment> findByProductId(Long productId) {
        Product product = Product.builder().id(productId).build();
        return productCommentRepository.findByProductId(product);
    }


    public ProductComment createComment(ProductComment productComment) {

        return productCommentRepository.save(productComment);
    }

    public List<ProductComment> getCommentsByDate(Long productId, String startDate, String endDate) {

        return productCommentRepository.findByProductIdAndCreatedAtBetween(productId, startDate, endDate);

    }

    public List<ProductComment> getUserCommentsByDate(Long userId, String startDate, String endDate) {

        return productCommentRepository.findByUserIdAndCreatedAtBetween(userId, startDate, endDate);
    }

}
