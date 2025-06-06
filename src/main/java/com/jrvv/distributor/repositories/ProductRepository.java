package com.jrvv.distributor.repositories;

import com.jrvv.distributor.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPrdNameContainingIgnoreCase(String name);
    List<Product> findByPrdCategoryContainingIgnoreCase(String category);
    List<Product> findByPrdActive(boolean active);
}
 