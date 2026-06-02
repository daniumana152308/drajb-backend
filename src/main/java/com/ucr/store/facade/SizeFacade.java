package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.SizeDto;
import com.ucr.store.mappers.SizeMapper;
import com.ucr.store.models.SizeResponseModel;
import com.ucr.store.services.SizeService;

@Component
public class SizeFacade implements ISizeFacade {

    @Autowired
    private SizeService sizeService;

    @Autowired
    private SizeMapper sizeMapper;

    @Override
    public List<SizeResponseModel> getAll() {

        return sizeMapper.toResponseModelList(
                sizeService.getAllSizes());
    }

    @Override
    public SizeResponseModel getById(Long id) {

        return sizeMapper.toResponseModel(
                sizeService.getSizeById(id));
    }

    @Override
    public SizeResponseModel create(SizeDto dto) {

        return sizeMapper.toResponseModel(
                sizeService.createSize(dto));
    }

    @Override
    public SizeResponseModel update(
            Long id,
            SizeDto dto) {

        return sizeMapper.toResponseModel(
                sizeService.updateSize(id, dto));
    }

    @Override
    public void delete(Long id) {

        sizeService.deleteSize(id);
    }
}