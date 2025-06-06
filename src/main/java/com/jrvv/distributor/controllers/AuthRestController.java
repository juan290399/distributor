package com.jrvv.distributor.controllers;

import com.jrvv.distributor.entities.AppUser;
import com.jrvv.distributor.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private AppUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        if (userService.usernameExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        AppUser created = userService.registerUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(created);
    }

    // Aquí más adelante agregarás el login con JWT
}
