package com.ucr.store.services;

import java.util.List;

import com.ucr.store.dto.BillDetailDto;
import com.ucr.store.entities.BillDetail;

public interface IBillDetailService {

    List<BillDetail> getAllBillDetails();

    BillDetail getBillDetailById(Long id);

    BillDetail createBillDetail(BillDetailDto dto);

    BillDetail updateBillDetail(Long id, BillDetailDto dto);

    void deleteBillDetail(Long id);
}
