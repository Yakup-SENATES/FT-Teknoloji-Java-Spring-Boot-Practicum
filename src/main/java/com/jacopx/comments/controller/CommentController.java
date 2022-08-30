package com.jacopx.comments.controller;

import com.jacopx.comments.entity.Product;
import com.jacopx.comments.entity.ProductComment;
import com.jacopx.comments.service.ProductCommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CommentController {

    private final ProductCommentService productCommentService;

    public CommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    //bir ürüne ait yorumları getirir
    @GetMapping("/product/{productId}/comments")
    public List<ProductComment> getProductComment(@PathVariable Long productId) {
        return productCommentService.findByProductId(productId);
    }


    //id'si verilen userin yourmlarını getirir
    @GetMapping("/user/{userId}/comments")
    public List<ProductComment> getUserComment(@PathVariable Long userId) {
        return productCommentService.findByUserId(userId);
    }


    //ürün yorumu oluştur
    @PostMapping("/create-comment")
    public ProductComment createComment(@RequestBody ProductComment productComment) {
        return productCommentService.createComment(productComment);
    }

    //belirtilen aralıktaki tarihlerde belirli bir ürüne yapılan yorumları getirir
    @GetMapping("/comments/{productId}/{startDate}/{endDate}")
    public List<ProductComment> getCommentsByDate(@PathVariable Long productId,
                                                  @PathVariable String startDate,
                                                  @PathVariable String endDate) {
        return productCommentService.getCommentsByDate(productId, startDate, endDate);
    }

    //Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren metot.
    @GetMapping("/{userId}/comments/{startDate}/{endDate}")
    public List<ProductComment> getUserCommentsByDate(@PathVariable Long userId,
                                                      @PathVariable String startDate,
                                                      @PathVariable String endDate) {
        return productCommentService.getUserCommentsByDate(userId, startDate, endDate);
    }


}
