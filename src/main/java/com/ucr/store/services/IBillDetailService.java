package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.BillDetailDto;

public interface IBillDetailService {

    List<BillDetailDto> getAllBillDetails();

    BillDetailDto getBillDetailById(Long id);

    BillDetailDto createBillDetail(BillDetailDto dto);

    BillDetailDto updateBillDetail(Long id, BillDetailDto dto);

    void deleteBillDetail(Long id);
}
