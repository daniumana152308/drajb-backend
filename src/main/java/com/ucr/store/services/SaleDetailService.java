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
public class SaleDetailService {

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<SaleDetail> getAllSaleDetails() {
        return saleDetailRepository.findAll();
    }

    public SaleDetail getSaleDetailById(Long id) {

        return saleDetailRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Sale detail not found with id: " + id));
    }

    public SaleDetail createSaleDetail(SaleDetailDto dto) {

        Sales sale = salesRepository.findById(dto.saleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Sale not found"));

        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"));

        SaleDetail saleDetail = new SaleDetail();

        saleDetail.setSale(sale);
        saleDetail.setProduct(product);
        saleDetail.setQuantity(dto.quantity());
        saleDetail.setUnitPrice(dto.unitPrice());

        return saleDetailRepository.save(saleDetail);
    }

    public SaleDetail updateSaleDetail(Long id, SaleDetailDto dto) {

        SaleDetail saleDetail = getSaleDetailById(id);

        Sales sale = salesRepository.findById(dto.saleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Sale not found"));

        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found"));

        saleDetail.setSale(sale);
        saleDetail.setProduct(product);
        saleDetail.setQuantity(dto.quantity());
        saleDetail.setUnitPrice(dto.unitPrice());

        return saleDetailRepository.save(saleDetail);
    }

    public void deleteSaleDetail(Long id) {

        SaleDetail saleDetail = getSaleDetailById(id);

        saleDetailRepository.delete(saleDetail);
    }
}