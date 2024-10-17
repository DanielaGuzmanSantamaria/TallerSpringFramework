package com.example.accesso_datajpa.repositories;

import com.example.accesso_datajpa.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
