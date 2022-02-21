package com.laboon.whitepaw.pawcrawlinginterface.product.service;

import com.laboon.whitepaw.pawcrawlinginterface.PawCrawlingTestHelper;
import com.laboon.whitepaw.pawcrawlinginterface.product.entity.Product;
import com.laboon.whitepaw.pawcrawlinginterface.product.repository.ProductRepository;
import com.laboon.whitepaw.pawcommon.exception.ApiException;
import com.laboon.whitepaw.pawcommon.model.ResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @BeforeTestClass
    public void setUp() {
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void getAllProductInPagination_shouldReturnUser_whenExecuteNormally() throws ApiException {
        when(productRepository.findAll()).thenReturn(PawCrawlingTestHelper.prepareMockedProducts());
    
        ResultPage<List<Product>> result = productService.getAllProductInPagination(0, 2);
    
        Assertions.assertNotNull(result);
        Assertions.assertEquals(BigDecimal.valueOf(1000), result.getResult().get(0).getPrice());
    }
}
