package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.SaleDetailDto;
import com.ucr.store.entities.Product;
import com.ucr.store.entities.SaleDetail;
import com.ucr.store.entities.Sales;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.ProductRepository;
import com.ucr.store.repositories.SaleDetailRepository;
import com.ucr.store.repositories.SalesRepository;

@Service
public class SaleDetailService implements ISaleDetailService {

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<SaleDetail> getAllSaleDetails() {
        return saleDetailRepository.findAll();
    }

    @Override
    public SaleDetail getSaleDetailById(Long id) {
        return saleDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Sale detail not found with id: " + id));
    }

    @Override
    public SaleDetail createSaleDetail(SaleDetailDto dto) {
        Sales sale = salesRepository.findById(dto.saleId())
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        SaleDetail detail = new SaleDetail();
        detail.setSale(sale);
        detail.setProduct(product);
        detail.setQuantity(dto.quantity());
        detail.setUnitPrice(dto.unitPrice());

        return saleDetailRepository.save(detail);
    }

    @Override
    public SaleDetail updateSaleDetail(Long id, SaleDetailDto dto) {
        SaleDetail detail = getSaleDetailById(id);

        Sales sale = salesRepository.findById(dto.saleId())
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        detail.setSale(sale);
        detail.setProduct(product);
        detail.setQuantity(dto.quantity());
        detail.setUnitPrice(dto.unitPrice());

        return saleDetailRepository.save(detail);
    }

    @Override
    public void deleteSaleDetail(Long id) {
        SaleDetail detail = getSaleDetailById(id);
        saleDetailRepository.delete(detail);
    }
}
