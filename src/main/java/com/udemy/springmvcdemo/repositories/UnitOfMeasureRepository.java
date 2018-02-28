package com.udemy.springmvcdemo.repositories;

import com.udemy.springmvcdemo.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
