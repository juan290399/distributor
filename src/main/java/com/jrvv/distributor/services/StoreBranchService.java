package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.StoreBranch;
import java.util.List;
import java.util.Optional;

public interface StoreBranchService {
    List<StoreBranch> getAllStoreBranches();
    Optional<StoreBranch> getStoreBranchById(Long id);
    StoreBranch createStoreBranch(StoreBranch storeBranch);
    StoreBranch updateStoreBranch(Long id, StoreBranch storeBranch);
    void deleteStoreBranch(Long id);
}
