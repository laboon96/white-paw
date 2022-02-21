package com.laboon.whitepaw.pawcrawlinginterface.product.repository;

import com.laboon.whitepaw.pawcrawlinginterface.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
