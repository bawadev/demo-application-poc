package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ProductComment;
import com.example.demo.exeption.ResourceNotFoundException;
import com.example.demo.repository.ProductCommentRepository;
import java.util.List;

/**
 * Service class for managing ProductComment entities.
 * This class handles business logic related to product comments.
 */
@Service
public class ProductCommentService {
    @Autowired
    private ProductCommentRepository productCommentRepository;

    /**
     * Saves a new product comment to the database.
     *
     * @param productComment The product comment to be saved
     * @return The saved product comment
     */
    public ProductComment saveProductComment(ProductComment productComment) {
        return productCommentRepository.save(productComment);
    }

    /**
     * Updates an existing product comment in the database.
     *
     * @param id The ID of the product comment to update
     * @param updatedProductComment The updated product comment information
     * @return The updated product comment
     * @throws ResourceNotFoundException if the product comment with the given ID is not found
     */
    public ProductComment updateProductComment(Long id, ProductComment updatedProductComment) {
        ProductComment productComment = productCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Comment not found"));
        
        // Update the product comment
        productComment.setComment(updatedProductComment.getComment());
        
        return productCommentRepository.save(productComment);
    }

    /**
     * Deletes a product comment from the database.
     * 
     * @param id The ID of the product comment to delete
     * @throws ResourceNotFoundException if the product comment with the given ID is not found
     */
    public void deleteProductComment(Long id) {
        ProductComment productComment = productCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Comment not found"));
        productCommentRepository.delete(productComment);
    }

    /**
     * Retrieves all product comments from the database.
     *
     * @return A list of all product comments
     */
    public List<ProductComment> getAllProductComments() {
        return productCommentRepository.findAll();
    }
}