package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setName("Product1");
        product.setDescription("Description1");
        product.setPrice(new BigDecimal("100.0"));

        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.saveProduct(product);
        assertEquals("Product1", savedProduct.getName());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setProductId(1);
        product.setName("Product1");
        product.setDescription("Description1");
        product.setPrice(new BigDecimal("100.0"));

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product updatedProduct = productService.updateProduct(1L, product);
        assertEquals("Product1", updatedProduct.getName());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setProductId(1);
        product.setStatus("A");

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        productService.deleteProduct(1L);
        assertEquals("D", product.getStatus());
    }
}

