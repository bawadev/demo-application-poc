package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exeption.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;

import jakarta.validation.Valid;

/**
 * Service class for managing Product entities.
 * This class handles business logic related to products.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Saves a new product to the database.
     *
     * @param product The product to be saved
     * @return The saved product
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates an existing product in the database.
     *
     * @param id The ID of the product to update
     * @param updatedProduct The updated product information
     * @return The updated product
     * @throws ResourceNotFoundException if the product with the given ID is not found
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        
        // Update the product fields
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        
        return productRepository.save(product);
    }

    /**
     * Soft deletes a product by setting its status to 'D'.
     *
     * @param id The ID of the product to delete
     * @throws ResourceNotFoundException if the product with the given ID is not found
     */
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setStatus("D"); // Set status to 'D' for soft delete
        productRepository.save(product);
    }

    /**
     * Retrieves all products belonging to a specific category.
     *
     * @param categoryName The name of the category
     * @return A list of products in the specified category
     */
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    /**
     * Retrieves all premium products (price >= 500.0).
     *
     * @return A list of premium products
     */
    public List<Product> getPremiumProducts() {
        return productRepository.findByPriceGreaterThanEqual(500.0);
    }

    /**
     * Retrieves all products from the database.
     *
     * @return A list of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}