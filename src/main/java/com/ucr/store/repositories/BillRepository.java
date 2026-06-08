package com.ucr.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.store.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
