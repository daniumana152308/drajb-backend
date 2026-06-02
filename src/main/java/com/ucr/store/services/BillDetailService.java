package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.BillDetailDto;
import com.ucr.store.entities.Bill;
import com.ucr.store.entities.BillDetail;
import com.ucr.store.entities.ServiceEntity;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.BillDetailRepository;
import com.ucr.store.repositories.BillRepository;
import com.ucr.store.repositories.ServiceEntityRepository;

@Service
public class BillDetailService {

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ServiceEntityRepository serviceEntityRepository;

    public List<BillDetail> getAllBillDetails() {

        return billDetailRepository.findAll();
    }

    public BillDetail getBillDetailById(Long id) {

        return billDetailRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bill detail not found with id: " + id));
    }

    public BillDetail createBillDetail(BillDetailDto dto) {

        Bill bill = billRepository.findById(dto.billId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bill not found"));

        ServiceEntity service = serviceEntityRepository
                .findById(dto.serviceId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service not found"));

        BillDetail billDetail = new BillDetail();

        billDetail.setBill(bill);
        billDetail.setService(service);
        billDetail.setPrice(dto.price());

        return billDetailRepository.save(billDetail);
    }

    public BillDetail updateBillDetail(
            Long id,
            BillDetailDto dto) {

        BillDetail billDetail = getBillDetailById(id);

        Bill bill = billRepository.findById(dto.billId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Bill not found"));

        ServiceEntity service = serviceEntityRepository
                .findById(dto.serviceId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service not found"));

        billDetail.setBill(bill);
        billDetail.setService(service);
        billDetail.setPrice(dto.price());

        return billDetailRepository.save(billDetail);
    }

    public void deleteBillDetail(Long id) {

        BillDetail billDetail = getBillDetailById(id);

        billDetailRepository.delete(billDetail);
    }
}