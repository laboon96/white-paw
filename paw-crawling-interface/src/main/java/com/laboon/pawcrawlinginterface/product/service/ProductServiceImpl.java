package com.laboon.pawcrawlinginterface.product.service;

import com.laboon.pawcrawlinginterface.product.entity.Product;
import com.laboon.pawcrawlinginterface.product.entity.ProductRequest;
import com.laboon.pawcrawlinginterface.product.repository.ProductRepository;
import com.laboon.whitepaw.pawcommon.constants.ErrorConstant;
import com.laboon.whitepaw.pawcommon.exception.ApiException;
import com.laboon.whitepaw.pawcommon.model.ResultPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResultPage<List<Product>> getAllProductInPagination(int offset, int limit) throws ApiException {
        try {
            log.info("Collect all products data with pagination.");
            log.info("Offset:  {}", offset);
            log.info("Limit:   {}", limit);

            List<Product> result;
            List<Product> products = new ArrayList<>();
            Iterable<Product> iterableProducts = productRepository.findAll();
            iterableProducts.forEach(products::add);

            if (CollectionUtils.isNotEmpty(products) && offset < products.size()) {
                int lastProductIndex = offset + limit;
                result = products.subList(offset, Math.min(lastProductIndex, products.size()));
            } else {
                result = products;
            }
            return ResultPage.of(offset, limit, result.size(), result);

        } catch (Exception e) {
            throw new ApiException(ErrorConstant.ERROR_LOOK_UP_PRODUCT, "Can not retrieve data of Products.");
        }
    }

    @Override
    public Product createNewProduct(ProductRequest productRequest) throws ApiException {
        try {
            log.info("Creating new product: {}", productRequest);
            Product newProduct = Product.builder()
                            .name(productRequest.getName())
                            .price(productRequest.getPrice())
                            .description(productRequest.getDescription())
                            .rating(productRequest.getRating())
                            .build();
            return productRepository.save(newProduct);

        } catch (Exception e) {
            throw new ApiException(ErrorConstant.ERROR_CREATING_PRODUCT, "Can't perform creating new product properly.");
        }
    }
}
