package com.udemy.springmvcdemo.repositories;

import com.udemy.springmvcdemo.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByTitle(String title);
}
