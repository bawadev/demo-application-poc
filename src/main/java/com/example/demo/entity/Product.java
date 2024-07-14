package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "product", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "product_category_id"})
})
@Data
@SQLRestriction("status = 'A'")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Column(name = "name")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 8, fraction = 2, message = "Price must be a valid number")
    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "product_category_id", nullable = false)
    @JsonBackReference
    private ProductCategory category;

    @NotBlank(message = "Status is mandatory")
    @Pattern(regexp = "[AD]", message = "Status must be 'A' (Active) or 'D' (Deleted)")
    @Column(name = "status")
    private String status;

    @Column(name = "launch_date")
    private Date launchDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductComment> comments;
}