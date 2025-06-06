package com.jrvv.distributor.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seller")
public class SellerRestController {

    @GetMapping("/orders")
    @PreAuthorize("hasRole('SELLER')")
    public String getSellerOrders() {
        return "Orders assigned to this seller";
    }
}
