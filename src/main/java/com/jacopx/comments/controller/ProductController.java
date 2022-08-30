package com.jacopx.comments.controller;

import com.jacopx.comments.entity.Product;
import com.jacopx.comments.entity.ProductComment;
import com.jacopx.comments.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //ürün oluştur
    @PostMapping("/create")
    public Product createComment(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    //id'si verilen ürünü getirir
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }


    //son kullanma tarihi geçmiş ürünleri getirir
    @GetMapping("/old")
    public List<Product> getOldProducts() {
        return productService.getOldProducts();
    }

    //Son kullanma tarihi geçmemiş ve null tarihli ürünleri listeleyen metot.
    @GetMapping("/new")
    public List<Product> getNewProducts() {
        return productService.getNewProducts();
    }



}
