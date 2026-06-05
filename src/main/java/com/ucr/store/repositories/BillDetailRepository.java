package com.ucr.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.store.entities.BillDetail;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {
}
