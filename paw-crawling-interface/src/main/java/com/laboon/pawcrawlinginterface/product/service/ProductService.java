package com.laboon.pawcrawlinginterface.product.service;

import com.laboon.pawcrawlinginterface.product.entity.Product;
import com.laboon.pawcrawlinginterface.product.entity.ProductRequest;
import com.laboon.whitepaw.pawcommon.exception.ApiException;
import com.laboon.whitepaw.pawcommon.model.ResultPage;

import java.util.List;

public interface ProductService {
    /**
     * Get List of all product with pagination handling.
     * @return The {@link ResultPage} of a List of {@link Product}
     * @throws ApiException
     */
    ResultPage<List<Product>> getAllProductInPagination(int offset, int limit) throws ApiException;

    Product createNewProduct(ProductRequest productRequest) throws ApiException;
}
