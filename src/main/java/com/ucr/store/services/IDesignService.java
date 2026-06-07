package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.DesignDto;

public interface IDesignService {

    List<DesignDto> getAllDesigns();

    DesignDto getDesignById(Long id);

    DesignDto createDesign(DesignDto dto);

    DesignDto updateDesign(Long id, DesignDto dto);

    void deleteDesign(Long id);
}