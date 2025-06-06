package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.Retailer;
import com.jrvv.distributor.repositories.RetailerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetailerServiceImpl implements RetailerService {

    private final RetailerRepository retailerRepository;

    @Override
    public List<Retailer> getAllRetailers() {
        return retailerRepository.findAll();
    }

    @Override
    public Optional<Retailer> getRetailerById(Long id) {
        return retailerRepository.findById(id);
    }

    @Override
    public Retailer createRetailer(Retailer retailer) {
        return retailerRepository.save(retailer);
    }

    @Override
    public Retailer updateRetailer(Long id, Retailer retailerDetails) {
        return retailerRepository.findById(id).map(retailer -> {
            retailer.setRetName(retailerDetails.getRetName());
            retailer.setRetType(retailerDetails.getRetType());
            retailer.setRetRuc(retailerDetails.getRetRuc());
            retailer.setRetActive(retailerDetails.getRetActive());
            return retailerRepository.save(retailer);
        }).orElseThrow(() -> new RuntimeException("Retailer no encontrado con id: " + id));
    }

    @Override
    public void deleteRetailer(Long id) {
        if (retailerRepository.existsById(id)) {
            retailerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Retailer no encontrado con id: " + id);
        }
    }
}
