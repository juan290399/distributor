package com.jrvv.distributor.controllers;

import com.jrvv.distributor.entities.Retailer;
import com.jrvv.distributor.services.RetailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/retailers")
@RequiredArgsConstructor
public class RetailerRestController {

    private final RetailerService retailerService;

    @GetMapping
    public List<Retailer> getAllRetailers() {
        return retailerService.getAllRetailers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Retailer> getRetailerById(@PathVariable Long id) {
        Optional<Retailer> retailer = retailerService.getRetailerById(id);
        return retailer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Retailer createRetailer(@RequestBody Retailer retailer) {
        return retailerService.createRetailer(retailer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Retailer> updateRetailer(@PathVariable Long id, @RequestBody Retailer retailerDetails) {
        try {
            Retailer updated = retailerService.updateRetailer(id, retailerDetails);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetailer(@PathVariable Long id) {
        try {
            retailerService.deleteRetailer(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
