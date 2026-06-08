package com.ucr.store.services;

import java.util.List;
import com.ucr.store.dto.ServiceEntityDto;

public interface IServiceEntityService {

    List<ServiceEntityDto> getAllServices();

    ServiceEntityDto getServiceById(Long id);

    ServiceEntityDto createService(ServiceEntityDto dto);

    ServiceEntityDto updateService(Long id, ServiceEntityDto dto);

    void deleteService(Long id);
}