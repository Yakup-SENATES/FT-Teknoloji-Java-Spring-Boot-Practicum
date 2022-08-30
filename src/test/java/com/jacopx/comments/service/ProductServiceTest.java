package com.jacopx.comments.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jacopx.comments.entity.Product;
import com.jacopx.comments.entity.User;
import com.jacopx.comments.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test: {@link ProductService#getProduct(Long)}
     */
    @Test
    void testGetProduct() {
        User user = new User();
        user.setCommentId(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhone("4105551212");
        user.setProductId(new ArrayList<>());

        Product product = new Product();
        product.setExpiryDate(LocalDateTime.of(1, 1, 1, 1, 1));
        product.setId(123L);
        product.setName("Name");
        product.setPrice("Price");
        product.setProductCommentId(new ArrayList<>());
        product.setUser(user);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(product, productService.getProduct(123L));
        verify(productRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link ProductService#createProduct(Product)}
     */
    @Test
    void testCreateProduct() {
        User user = new User();
        user.setCommentId(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhone("4105551212");
        user.setProductId(new ArrayList<>());

        Product product = new Product();
        product.setExpiryDate(LocalDateTime.of(1, 1, 1, 1, 1));
        product.setId(123L);
        product.setName("Name");
        product.setPrice("Price");
        product.setProductCommentId(new ArrayList<>());
        product.setUser(user);
        when(productRepository.save((Product) any())).thenReturn(product);

        User user1 = new User();
        user1.setCommentId(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPhone("4105551212");
        user1.setProductId(new ArrayList<>());

        Product product1 = new Product();
        product1.setExpiryDate(LocalDateTime.of(1, 1, 1, 1, 1));
        product1.setId(123L);
        product1.setName("Name");
        product1.setPrice("Price");
        product1.setProductCommentId(new ArrayList<>());
        product1.setUser(user1);
        assertSame(product, productService.createProduct(product1));
        verify(productRepository).save((Product) any());
    }

    /**
     * Method under test: {@link ProductService#getOldProducts()}
     */
    @Test
    void testGetOldProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findByExpiryDateBefore((LocalDateTime) any())).thenReturn(productList);
        List<Product> actualOldProducts = productService.getOldProducts();
        assertSame(productList, actualOldProducts);
        assertTrue(actualOldProducts.isEmpty());
        verify(productRepository).findByExpiryDateBefore((LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#getProducts()}
     */
    @Test
    void testGetProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> actualProducts = productService.getProducts();
        assertSame(productList, actualProducts);
        assertTrue(actualProducts.isEmpty());
        verify(productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductService#getNewProducts()}
     */
  /*  @Test
    void testGetNewProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findByExpiryDateAfter((LocalDateTime) any())).thenReturn(productList);
        List<Product> actualNewProducts = productService.getNewProducts();
        assertSame(productList, actualNewProducts);
        assertTrue(actualNewProducts.isEmpty());
        verify(productRepository).findByExpiryDateAfter((LocalDateTime) any());
    }

   */
}

