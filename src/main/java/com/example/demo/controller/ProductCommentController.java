package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.ProductComment;
import com.example.demo.service.ProductCommentService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/v1/product-comments")
@Validated
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductComment>>> getAllProductComments() {
        List<ProductComment> comments = productCommentService.getAllProductComments();
        return ResponseEntity.ok(new ApiResponse<>(true, comments, "Product comments fetched successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductComment>> createProductComment(@Valid @RequestBody ProductComment productComment) {
        ProductComment createdComment = productCommentService.saveProductComment(productComment);
        return ResponseEntity.ok(new ApiResponse<>(true, createdComment, "Product comment created successfully"));
    }
}

