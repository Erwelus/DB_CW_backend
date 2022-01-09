package com.example.db_cw_backend.repository;

import com.example.db_cw_backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String name);
}
