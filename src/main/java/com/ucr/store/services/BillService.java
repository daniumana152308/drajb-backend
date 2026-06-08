package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.BillDto;
import com.ucr.store.entities.Bill;
import com.ucr.store.entities.Sales;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.BillRepository;
import com.ucr.store.repositories.SalesRepository;

@Service
public class BillService implements IBillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Bill not found with id: " + id));
    }

    @Override
    public Bill createBill(BillDto dto) {
        Sales sale = salesRepository.findById(dto.saleId())
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        Bill bill = new Bill();
        bill.setSale(sale);
        bill.setIssueDate(dto.issueDate());
        bill.setShippingDate(dto.shippingDate());
        bill.setTotalAmount(dto.totalAmount());
        bill.setNotes(dto.notes());

        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(Long id, BillDto dto) {
        Bill bill = getBillById(id);

        Sales sale = salesRepository.findById(dto.saleId())
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));

        bill.setSale(sale);
        bill.setIssueDate(dto.issueDate());
        bill.setShippingDate(dto.shippingDate());
        bill.setTotalAmount(dto.totalAmount());
        bill.setNotes(dto.notes());

        return billRepository.save(bill);
    }

    @Override
    public void deleteBill(Long id) {
        Bill bill = getBillById(id);
        billRepository.delete(bill);
    }
}
