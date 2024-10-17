package com.example.accesso_datajpa.repositories;

import com.example.accesso_datajpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
