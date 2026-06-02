package com.ucr.store.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucr.store.entities.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {  
}