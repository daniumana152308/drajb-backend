package com.ucr.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.store.entities.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
}