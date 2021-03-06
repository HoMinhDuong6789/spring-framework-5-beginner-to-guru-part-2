package com.udemy.springmvcdemo.repositories;

import com.udemy.springmvcdemo.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() {
        unitOfMeasureRepository.deleteAll();
    }

    @Test
    public void findByTitle() {
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByTitle("Teaspoon");
        teaspoon.ifPresent(unitOfMeasure -> assertEquals("Teaspoon", unitOfMeasure.toString()));
    }
}