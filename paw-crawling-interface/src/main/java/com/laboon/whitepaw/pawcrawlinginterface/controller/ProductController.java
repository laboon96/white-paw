package com.laboon.whitepaw.pawcrawlinginterface.controller;

import com.laboon.whitepaw.pawcrawlinginterface.product.entity.ProductRequest;
import com.laboon.whitepaw.pawcrawlinginterface.product.service.ProductService;
import com.laboon.whitepaw.pawcommon.exception.ApiException;
import com.laboon.whitepaw.pawcommon.response.ApiResponse;
import com.laboon.whitepaw.pawcommon.response.ApiSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<ApiResponse> getAllProduct(@RequestParam(name = "offset") int offset,
                                                     @RequestParam(name = "limit") int limit) throws ApiException {
        var response = ApiSuccessResponse.of(productService.getAllProductInPagination(offset, limit));
        return ResponseEntity.ok(response.add(linkTo(methodOn(this.getClass()).getAllProduct(offset, limit)).withSelfRel()));
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<ApiResponse> createProduct(@RequestBody @Validated ProductRequest productRequest) throws ApiException {
        var response = ApiSuccessResponse.of(productService.createNewProduct(productRequest));
        return ResponseEntity.ok(response.add(linkTo(methodOn(this.getClass()).createProduct(productRequest)).withSelfRel()));
    }
}
