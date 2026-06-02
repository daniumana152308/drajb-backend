package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.SizeDto;
import com.ucr.store.entities.Size;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.SizeRepository;

@Service
public class SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    public Size getSizeById(Long id) {

        return sizeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Size not found with id: " + id));
    }

    public Size createSize(SizeDto dto) {

        Size size = new Size();

        size.setLabel(dto.label());
        size.setDescription(dto.description());

        return sizeRepository.save(size);
    }

    public Size updateSize(Long id, SizeDto dto) {

        Size size = getSizeById(id);

        size.setLabel(dto.label());
        size.setDescription(dto.description());

        return sizeRepository.save(size);
    }

    public void deleteSize(Long id) {

        Size size = getSizeById(id);

        sizeRepository.delete(size);
    }
}