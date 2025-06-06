package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.City;
import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> getAllCities();
    Optional<City> getCityById(Long id);
    City createCity(City city);
    City updateCity(Long id, City city);
    void deleteCity(Long id);
}
