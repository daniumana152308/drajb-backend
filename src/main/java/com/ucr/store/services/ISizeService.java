package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.SizeDto;

public interface ISizeService {

    List<SizeDto> getAllSizes();

    SizeDto getSizeById(Long id);

    SizeDto createSize(SizeDto dto);

    SizeDto updateSize(Long id, SizeDto dto);

    void deleteSize(Long id);
}