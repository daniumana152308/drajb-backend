package com.ucr.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucr.store.dto.ServiceEntityDto;
import com.ucr.store.entities.ServiceEntity;
import com.ucr.store.exceptions.ResourceNotFoundException;
import com.ucr.store.repositories.ServiceEntityRepository;

@Service
public class ServiceEntityService {

    @Autowired
    private ServiceEntityRepository serviceEntityRepository;

    public List<ServiceEntity> getAllServices() {
        return serviceEntityRepository.findAll();
    }

    public ServiceEntity getServiceById(Long id) {

        return serviceEntityRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Service not found with id: " + id));
    }

    public ServiceEntity createService(ServiceEntityDto dto) {

        ServiceEntity service = new ServiceEntity();

        service.setName(dto.name());
        service.setDescription(dto.description());
        service.setBasePrice(dto.basePrice());

        return serviceEntityRepository.save(service);
    }

    public ServiceEntity updateService(Long id, ServiceEntityDto dto) {

        ServiceEntity service = getServiceById(id);

        service.setName(dto.name());
        service.setDescription(dto.description());
        service.setBasePrice(dto.basePrice());

        return serviceEntityRepository.save(service);
    }

    public void deleteService(Long id) {

        ServiceEntity service = getServiceById(id);

        serviceEntityRepository.delete(service);
    }
}