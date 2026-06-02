package com.ucr.store.services;

import java.util.List;

import com.ucr.store.dto.ProductDto;

public interface IProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto dto);

    ProductDto updateProduct(Long id, ProductDto dto);

    void deleteProduct(Long id);
}