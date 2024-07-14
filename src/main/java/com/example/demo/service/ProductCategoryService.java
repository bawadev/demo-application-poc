package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDetails;
import com.example.demo.entity.ProductCategory;
import com.example.demo.exeption.ResourceNotFoundException;
import com.example.demo.repository.ProductCategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing ProductCategory entities.
 * This class handles business logic related to product categories and their associated products.
 */
@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /**
     * Saves a new product category to the database.
     *
     * @param productCategory The product category to be saved
     * @return The saved product category
     */
    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    /**
     * Updates an existing product category in the database.
     *
     * @param id The ID of the product category to update
     * @param updatedProductCategory The updated product category information
     * @return The updated product category
     * @throws ResourceNotFoundException if the product category with the given ID is not found
     */
    public ProductCategory updateProductCategory(Long id, ProductCategory updatedProductCategory) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Category not found"));
        productCategory.setName(updatedProductCategory.getName());
        return productCategoryRepository.save(productCategory);
    }

    /**
     * Deletes a product category from the database.
     * 
     * @param id The ID of the product category to delete
     * @throws ResourceNotFoundException if the product category with the given ID is not found
     */
    public void deleteProductCategory(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Category not found"));
        // Note: This method currently only retrieves the category but doesn't delete it.
        // You might want to add the actual deletion logic here:
        // productCategoryRepository.delete(productCategory);
    }

    /**
     * Retrieves all product categories from the database.
     *
     * @return A list of all product categories
     */
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    /**
     * Retrieves all products in a specific category.
     *
     * @param categoryName The name of the category
     * @return A list of product details in the specified category, or null if the category doesn't exist
     */
    public List<ProductDetails> getProductsByCategory(String categoryName) {
        ProductCategory category = getProductCategoryByName(categoryName);

        if (category == null) {
            return null;
        }

        return category.getProducts().stream()
                .map(product -> new ProductDetails(product.getName(), product.getDescription(), 
                     product.getPrice(), product.getStatus(), product.getLaunchDate(), product.getComments()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all premium products (price >= $500) across all categories.
     *
     * @return A list of premium product details
     */
    public List<ProductDetails> getPremiumProducts() {
        List<ProductCategory> allCategories = getAllProductCategories();
        List<ProductDetails> premiumProducts = allCategories.stream()
                .flatMap(category -> category.getProducts().stream()) 
                .filter(product -> product.getPrice().floatValue() >= 500.0) // Filter for products with price >= $500
                .map(product -> new ProductDetails(product.getName(), product.getDescription(), 
                     product.getPrice(), product.getStatus(), product.getLaunchDate(), product.getComments()))
                .collect(Collectors.toList());
        return premiumProducts;
    }

    /**
     * Retrieves a product category by its name.
     *
     * @param categoryName The name of the category to retrieve
     * @return The product category, or null if not found
     */
    private ProductCategory getProductCategoryByName(String categoryName) {
        return productCategoryRepository.findByName(categoryName);
    }
}