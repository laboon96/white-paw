package com.laboon.pawcrawlinginterface.product.repository;

import com.laboon.pawcrawlinginterface.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
