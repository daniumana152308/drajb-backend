package com.ucr.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucr.store.entities.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
}
