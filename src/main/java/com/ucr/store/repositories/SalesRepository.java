package com.ucr.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.store.entities.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findByClient_Id(Long clientId);
}
