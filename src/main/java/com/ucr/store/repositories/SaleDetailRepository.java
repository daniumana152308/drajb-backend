package com.ucr.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.store.entities.SaleDetail;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
}
