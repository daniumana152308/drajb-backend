package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.BillDto;

public interface IBillService {

    List<BillDto> getAllBills();

    BillDto getBillById(Long id);

    BillDto createBill(BillDto dto);

    BillDto updateBill(Long id, BillDto dto);

    void deleteBill(Long id);
}