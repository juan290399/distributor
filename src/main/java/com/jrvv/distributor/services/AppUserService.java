package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.AppUser;

public interface AppUserService {
    AppUser registerUser(String username, String rawPassword);
    boolean usernameExists(String username);
}
