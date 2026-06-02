package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.ProductDto;
import com.ucr.store.entities.Design;
import com.ucr.store.entities.Product;
import com.ucr.store.entities.Size;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.DesignRepository;
import com.ucr.store.repositories.ProductRepository;
import com.ucr.store.repositories.SizeRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DesignRepository designRepository;

    @Autowired
    private SizeRepository sizeRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id));
    }

    public Product createProduct(ProductDto dto) {

        Design design = designRepository.findById(dto.designId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Design not found"));

        Size size = sizeRepository.findById(dto.sizeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Size not found"));

        Product product = new Product();

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setDesign(design);
        product.setSize(size);

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDto dto) {

        Product product = getProductById(id);

        Design design = designRepository.findById(dto.designId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Design not found"));

        Size size = sizeRepository.findById(dto.sizeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Size not found"));

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setDesign(design);
        product.setSize(size);

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {

        Product product = getProductById(id);

        productRepository.delete(product);
    }
}