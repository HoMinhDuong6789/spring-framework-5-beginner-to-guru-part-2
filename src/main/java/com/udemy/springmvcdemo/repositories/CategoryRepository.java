package com.udemy.springmvcdemo.repositories;

import com.udemy.springmvcdemo.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
