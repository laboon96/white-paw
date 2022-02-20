package com.laboon.pawcrawlinginterface.controller;

import com.laboon.pawcrawlinginterface.product.entity.Product;
import com.laboon.pawcrawlinginterface.product.service.ProductServiceImpl;
import com.laboon.whitepaw.pawcommon.model.ResultPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static com.laboon.pawcrawlinginterface.PawCrawlingTestHelper.prepareProductResultPage;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @MockBean
    ProductServiceImpl productServiceImpl;
    
    @Autowired
    MockMvc mockMvc;
    
    @Test
    public void shouldReturnData_whenGetAllProduct() throws Exception {
        ResultPage<List<Product>> mockResultProducts = prepareProductResultPage(0, 5);
        
        when(productServiceImpl.getAllProductInPagination(0, 5))
                .thenReturn(mockResultProducts);
    
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products")
                                            .contentType("application/json")
                                            .param("offset", "0")
                                            .param("limit", "5"))
                                   .andExpect(MockMvcResultMatchers.status().isOk())
                                   .andReturn();
        
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
}
