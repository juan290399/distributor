package com.jrvv.distributor.repositories;

import com.jrvv.distributor.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByCitNameContainingIgnoreCase(String name);
    List<City> findByCitRegionContainingIgnoreCase(String region);
    List<City> findByCitPostalCodeContainingIgnoreCase(String postalCode);
}
