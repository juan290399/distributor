package com.jrvv.distributor.repositories;

import com.jrvv.distributor.entities.StoreBranch;
import com.jrvv.distributor.entities.City;
import com.jrvv.distributor.entities.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreBranchRepository extends JpaRepository<StoreBranch, Long> {
    List<StoreBranch> findByRetailer(Retailer retailer);
    List<StoreBranch> findByCity(City city);
    List<StoreBranch> findByStbAddressContainingIgnoreCase(String address);
    List<StoreBranch> findByStbActive(boolean active);
}
