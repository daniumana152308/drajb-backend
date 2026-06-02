package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.ProductDto;
import com.ucr.store.mappers.ProductMapper;
import com.ucr.store.models.ProductResponseModel;
import com.ucr.store.services.ProductService;

@Component
public class ProductFacade implements IProductFacade {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponseModel> getAll() {

        return productMapper.toResponseModelList(
                productService.getAllProducts());
    }

    @Override
    public ProductResponseModel getById(Long id) {

        return productMapper.toResponseModel(
                productService.getProductById(id));
    }

    @Override
    public ProductResponseModel create(ProductDto dto) {

        return productMapper.toResponseModel(
                productService.createProduct(dto));
    }

    @Override
    public ProductResponseModel update(
            Long id,
            ProductDto dto) {

        return productMapper.toResponseModel(
                productService.updateProduct(id, dto));
    }

    @Override
    public void delete(Long id) {

        productService.deleteProduct(id);
    }
}