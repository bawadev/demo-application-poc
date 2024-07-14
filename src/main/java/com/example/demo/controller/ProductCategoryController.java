package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ProductDetails;
import com.example.demo.entity.ProductCategory;
import com.example.demo.service.ProductCategoryService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@RestController
@RequestMapping("/v1/product-categories")
@Validated
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductCategory>>> getAllProductCategories() {
        List<ProductCategory> categories = productCategoryService.getAllProductCategories();
        return ResponseEntity.ok(new ApiResponse<>(true, categories, "Product categories fetched successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductCategory>> createProductCategory(
            @Valid @RequestBody ProductCategory productCategory) {
        ProductCategory createdCategory = productCategoryService.saveProductCategory(productCategory);
        return ResponseEntity.ok(new ApiResponse<>(true, createdCategory, "Product category created successfully"));
    }

    @GetMapping("/{categoryName}/products")
    public ResponseEntity<ApiResponse<List<ProductDetails>>> getProductsByCategory(
            @PathVariable @NotBlank(message = "Category name cannot be blank") String categoryName) {
        List<ProductDetails> productDetails = productCategoryService.getProductsByCategory(categoryName);
        return ResponseEntity.ok(new ApiResponse<>(true, productDetails, "Products retrieved successfully"));
    }

    @GetMapping("/premium-products")
    public ResponseEntity<ApiResponse<List<ProductDetails>>> getPremiumProducts() {
        List<ProductDetails> premiumProducts = productCategoryService.getPremiumProducts();
        return ResponseEntity.ok(new ApiResponse<>(true, premiumProducts, "Premium products retrieved successfully"));
    }

}
