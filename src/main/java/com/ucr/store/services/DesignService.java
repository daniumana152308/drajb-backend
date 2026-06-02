package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.DesignDto;
import com.ucr.store.entities.Design;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.DesignRepository;

@Service
public class DesignService {

    @Autowired
    private DesignRepository designRepository;

    public List<Design> getAllDesigns() {

        return designRepository.findAll();
    }

    public Design getDesignById(Long id) {

        return designRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Design not found with id: " + id));
    }

    public Design createDesign(DesignDto dto) {

        Design design = new Design();

        design.setName(dto.name());
        design.setDescription(dto.description());
        design.setImageUrl(dto.imageUrl());

        return designRepository.save(design);
    }

    public Design updateDesign(Long id, DesignDto dto) {

        Design design = getDesignById(id);

        design.setName(dto.name());
        design.setDescription(dto.description());
        design.setImageUrl(dto.imageUrl());

        return designRepository.save(design);
    }

    public void deleteDesign(Long id) {

        Design design = getDesignById(id);

        designRepository.delete(design);
    }
}