package com.ucr.store.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.store.dto.DesignDto;
import com.ucr.store.mappers.DesignMapper;
import com.ucr.store.models.DesignResponseModel;
import com.ucr.store.services.DesignService;

@Component
public class DesignFacade implements IDesignFacade {

    @Autowired
    private DesignService designService;

    @Autowired
    private DesignMapper designMapper;

    @Override
    public List<DesignResponseModel> getAll() {

        return designMapper.toResponseModelList(
                designService.getAllDesigns());
    }

    @Override
    public DesignResponseModel getById(Long id) {

        return designMapper.toResponseModel(
                designService.getDesignById(id));
    }

    @Override
    public DesignResponseModel create(DesignDto dto) {

        return designMapper.toResponseModel(
                designService.createDesign(dto));
    }

    @Override
    public DesignResponseModel update(
            Long id,
            DesignDto dto) {

        return designMapper.toResponseModel(
                designService.updateDesign(id, dto));
    }

    @Override
    public void delete(Long id) {

        designService.deleteDesign(id);
    }
}