package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.ProductComment;

import lombok.Data;

@Data
public class ProductDetails {

    private String name;
    private String description;
    private BigDecimal price;
    private String status;
    private Date launchDate;
    private List<ProductComment> comments; 

    public ProductDetails(String name, String description, BigDecimal bigDecimal, String status, Date launchDate, List<ProductComment> list) {
        this.name = name;
        this.description = description;
        this.price = bigDecimal;
        this.status = status;
        this.launchDate = launchDate;
        this.comments = list;
    }
}
