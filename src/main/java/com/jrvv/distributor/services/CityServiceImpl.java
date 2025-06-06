package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.City;
import com.jrvv.distributor.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Long id, City cityDetails) {
        return cityRepository.findById(id)
            .map(city -> {
                city.setCitName(cityDetails.getCitName());
                city.setCitRegion(cityDetails.getCitRegion());
                city.setCitPostalCode(cityDetails.getCitPostalCode());
                return cityRepository.save(city);
            }).orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
