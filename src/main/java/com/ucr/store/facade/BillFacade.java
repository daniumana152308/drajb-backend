package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.BillDto;
import com.ucr.store.mappers.BillMapper;
import com.ucr.store.models.BillResponseModel;
import com.ucr.store.services.BillService;

@Component
public class BillFacade implements IBillFacade {

    @Autowired
    private BillService billService;

    @Autowired
    private BillMapper billMapper;

    @Override
    public List<BillResponseModel> getAll() {

        return billMapper.toResponseModelList(
                billService.getAllBills());
    }

    @Override
    public BillResponseModel getById(Long id) {

        return billMapper.toResponseModel(
                billService.getBillById(id));
    }

    @Override
    public BillResponseModel create(BillDto dto) {

        return billMapper.toResponseModel(
                billService.createBill(dto));
    }

    @Override
    public BillResponseModel update(
            Long id,
            BillDto dto) {

        return billMapper.toResponseModel(
                billService.updateBill(id, dto));
    }

    @Override
    public void delete(Long id) {

        billService.deleteBill(id);
    }
}