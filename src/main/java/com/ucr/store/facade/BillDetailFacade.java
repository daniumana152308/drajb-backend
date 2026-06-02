package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.BillDetailDto;
import com.ucr.store.mappers.BillDetailMapper;
import com.ucr.store.models.BillDetailResponseModel;
import com.ucr.store.services.BillDetailService;

@Component
public class BillDetailFacade implements IBillDetailFacade {

    @Autowired
    private BillDetailService billDetailService;

    @Autowired
    private BillDetailMapper billDetailMapper;

    @Override
    public List<BillDetailResponseModel> getAll() {

        return billDetailMapper.toResponseModelList(
                billDetailService.getAllBillDetails());
    }

    @Override
    public BillDetailResponseModel getById(Long id) {

        return billDetailMapper.toResponseModel(
                billDetailService.getBillDetailById(id));
    }

    @Override
    public BillDetailResponseModel create(
            BillDetailDto dto) {

        return billDetailMapper.toResponseModel(
                billDetailService.createBillDetail(dto));
    }

    @Override
    public BillDetailResponseModel update(
            Long id,
            BillDetailDto dto) {

        return billDetailMapper.toResponseModel(
                billDetailService.updateBillDetail(id, dto));
    }

    @Override
    public void delete(Long id) {

        billDetailService.deleteBillDetail(id);
    }
}