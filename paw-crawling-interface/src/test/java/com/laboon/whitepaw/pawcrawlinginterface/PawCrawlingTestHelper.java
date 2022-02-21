package com.laboon.whitepaw.pawcrawlinginterface;

import com.laboon.whitepaw.pawcrawlinginterface.product.entity.Product;
import com.laboon.whitepaw.pawcommon.model.ResultPage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PawCrawlingTestHelper {

    private PawCrawlingTestHelper() {}

    public static Iterable<Product> prepareMockedProducts() {
        Product product1 = Product.builder()
                .name("Iphone 14")
                .price(BigDecimal.valueOf(1000))
                .description("Newest Iphone product")
                .rating(0)
                .build();
        Product product2 = Product.builder()
                .name("Macbook Pro 20")
                .price(BigDecimal.valueOf(5000))
                .description("Macbook with biggest screen")
                .rating(0)
                .build();
        return new ArrayList<>(Arrays.asList(product1, product2));
    }
    
    public static ResultPage<List<Product>> prepareProductResultPage(int offset, int limit) {
        List<Product> products = new ArrayList<>();
        Iterable<Product> iterableProducts = prepareMockedProducts();
        iterableProducts.forEach(products::add);
        return ResultPage.of(offset,limit, products.size(), products);
    }
}
