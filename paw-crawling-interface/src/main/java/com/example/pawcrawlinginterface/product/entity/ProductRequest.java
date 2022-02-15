package com.example.pawcrawlinginterface.product.entity;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;
    private String description;
    private Integer rating;

}
