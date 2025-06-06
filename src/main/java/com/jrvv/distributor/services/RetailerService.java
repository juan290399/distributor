package com.jrvv.distributor.services;
import com.jrvv.distributor.entities.Retailer;
import java.util.List;
import java.util.Optional;

public interface RetailerService {
    List<Retailer> getAllRetailers();
    Optional<Retailer> getRetailerById(Long id);
    Retailer createRetailer(Retailer retailer);
    Retailer updateRetailer(Long id, Retailer retailer);
    void deleteRetailer(Long id);
}