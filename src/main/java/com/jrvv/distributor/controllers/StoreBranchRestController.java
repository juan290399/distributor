package com.jrvv.distributor.controllers;

import com.jrvv.distributor.entities.StoreBranch;
import com.jrvv.distributor.services.StoreBranchService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store-branches")
@RequiredArgsConstructor
public class StoreBranchRestController {

    private final StoreBranchService storeBranchService;

    @GetMapping
    public List<StoreBranch> getAllStoreBranches() {
        return storeBranchService.getAllStoreBranches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreBranch> getStoreBranchById(@PathVariable Long id) {
        return storeBranchService.getStoreBranchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StoreBranch> createStoreBranch(@RequestBody StoreBranch storeBranch) {
        return ResponseEntity.ok(storeBranchService.createStoreBranch(storeBranch));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreBranch> updateStoreBranch(@PathVariable Long id, @RequestBody StoreBranch storeBranch) {
        try {
            return ResponseEntity.ok(storeBranchService.updateStoreBranch(id, storeBranch));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoreBranch(@PathVariable Long id) {
        storeBranchService.deleteStoreBranch(id);
        return ResponseEntity.noContent().build();
    }
}
