package com.ucr.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.store.entities.ServiceEntity;

@Repository
public interface ServiceEntityRepository extends JpaRepository<ServiceEntity, Long> {
}