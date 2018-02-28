package com.udemy.springmvcdemo.repositories;

import com.udemy.springmvcdemo.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
