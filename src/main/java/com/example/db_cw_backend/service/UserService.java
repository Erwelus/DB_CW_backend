package com.example.db_cw_backend.service;


import com.example.db_cw_backend.model.User;

public interface UserService {
    User register(User user);
    User findByUsername(String username);
    User getCurrentUser();
}
