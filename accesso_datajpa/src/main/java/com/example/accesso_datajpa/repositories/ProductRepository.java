package com.example.accesso_datajpa.repositories;

import com.example.accesso_datajpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
}
