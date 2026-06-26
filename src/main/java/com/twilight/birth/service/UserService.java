package com.twilight.birth.service;

import com.twilight.birth.entity.User;

public interface UserService {
    boolean register(String username, String password, String email);
    User login(String username, String password);
    boolean isUsernameExists(String username);
}