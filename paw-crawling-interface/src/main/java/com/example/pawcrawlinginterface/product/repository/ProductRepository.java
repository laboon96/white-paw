package com.example.pawcrawlinginterface.product.repository;

import com.example.pawcrawlinginterface.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
