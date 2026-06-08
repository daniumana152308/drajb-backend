package com.ucr.store.services;

import java.util.List;

import com.ucr.store.dto.BillDto;
import com.ucr.store.entities.Bill;

public interface IBillService {

    List<Bill> getAllBills();

    Bill getBillById(Long id);

    Bill createBill(BillDto dto);

    Bill updateBill(Long id, BillDto dto);

    void deleteBill(Long id);
}
