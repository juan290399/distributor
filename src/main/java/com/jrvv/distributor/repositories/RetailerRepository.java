package com.jrvv.distributor.repositories;

import com.jrvv.distributor.entities.Retailer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerRepository extends JpaRepository<Retailer, Long> {
    List<Retailer> findByRetNameContainingIgnoreCase(String name);
    List<Retailer> findByRetRucContainingIgnoreCase(String ruc);
    List<Retailer> findByRetTypeContainingIgnoreCase(String type);
    List<Retailer> findByRetActive(boolean active);
    List<Retailer> findByRetNameContainingIgnoreCaseAndRetRucContainingIgnoreCaseAndRetTypeContainingIgnoreCaseAndRetActive(
            String name, String ruc, String type, boolean active); 
}