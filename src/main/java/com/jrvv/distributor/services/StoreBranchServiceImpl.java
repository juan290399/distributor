package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.StoreBranch;
import com.jrvv.distributor.repositories.StoreBranchRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreBranchServiceImpl implements StoreBranchService {

    private final StoreBranchRepository storeBranchRepository;

    @Override
    public List<StoreBranch> getAllStoreBranches() {
        return storeBranchRepository.findAll();
    }

    @Override
    public Optional<StoreBranch> getStoreBranchById(Long id) {
        return storeBranchRepository.findById(id);
    }

    @Override
    public StoreBranch createStoreBranch(StoreBranch storeBranch) {
        return storeBranchRepository.save(storeBranch);
    }

    @Override
    public StoreBranch updateStoreBranch(Long id, StoreBranch storeBranch) {
        return storeBranchRepository.findById(id)
            .map(existing -> {
                existing.setRetailer(storeBranch.getRetailer());
                existing.setCity(storeBranch.getCity());
                existing.setStbAddress(storeBranch.getStbAddress());
                existing.setStbZone(storeBranch.getStbZone());
                existing.setStbPostalCode(storeBranch.getStbPostalCode());
                existing.setStbLocationUrl(storeBranch.getStbLocationUrl());
                existing.setStbActive(storeBranch.getStbActive());
                return storeBranchRepository.save(existing);
            }).orElseThrow(() -> new RuntimeException("StoreBranch not found"));
    }

    @Override
    public void deleteStoreBranch(Long id) {
        storeBranchRepository.deleteById(id);
    }
}
