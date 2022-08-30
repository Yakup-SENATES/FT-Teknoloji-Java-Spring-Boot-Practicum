package com.jacopx.comments.service;

import com.jacopx.comments.entity.Product;
import com.jacopx.comments.entity.ProductComment;
import com.jacopx.comments.exception.UserNotFoundException;
import com.jacopx.comments.repository.ProductCommentRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class ProductCommentServiceTest {


    private ProductCommentService productCommentService;

    private ProductCommentRepository productCommentRepository;

    @BeforeEach
    public void setUp() {
        productCommentRepository = Mockito.mock(ProductCommentRepository.class);
        productCommentService = new ProductCommentService(productCommentRepository);
    }


    @Test
    void testFindByUserId_ifUserIdDoesExist_thanReturnComment() {
        Long userId = 1L;
        when(productCommentRepository.findByUserId(userId))
                .thenReturn(List.of(ProductComment.builder().build()));

        productCommentService.findByUserId(1L);
        verify(productCommentRepository).findByUserId(userId);
    }



    @Test
    void testCreateComment_ifCommentProvided_thanReturnComment() {

        ProductComment productComment = ProductComment.builder().build();
        when(productCommentRepository.save(productComment))
                .thenReturn(productComment);

        ProductComment returnedComment
                = productCommentService.createComment(productComment);
        verify(productCommentRepository).save(productComment);
        assertSame(productComment, returnedComment);

    }







}