package com.jrvv.distributor.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jrvv.distributor.entities.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}