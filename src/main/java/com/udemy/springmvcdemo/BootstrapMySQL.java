package com.udemy.springmvcdemo;

import com.udemy.springmvcdemo.domain.Category;
import com.udemy.springmvcdemo.domain.UnitOfMeasure;
import com.udemy.springmvcdemo.repositories.CategoryRepository;
import com.udemy.springmvcdemo.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L) {
            log.debug("Loading Categories");
            loadCategories();
        }
        if (unitOfMeasureRepository.count() == 0L) {
            log.debug("Loading Unit of Measures");
            loadUnitsOfMeasure();
        }
    }

    private void loadCategories() {
        Category cat1 = new Category();
        cat1.setDescription("American");
        categoryRepository.save(cat1);
        Category cat2 = new Category();
        cat2.setDescription("Italian");
        categoryRepository.save(cat2);
        Category cat3 = new Category();
        cat3.setDescription("Mexican");
        categoryRepository.save(cat3);
        Category cat4 = new Category();
        cat4.setDescription("Russian");
        categoryRepository.save(cat4);
    }

    private void loadUnitsOfMeasure() {
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setTitle("Teaspoon");
        unitOfMeasureRepository.save(uom1);
        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setTitle("Tablespoon");
        unitOfMeasureRepository.save(uom2);
        UnitOfMeasure uom3 = new UnitOfMeasure();
        uom3.setTitle("Cup");
        unitOfMeasureRepository.save(uom3);
        UnitOfMeasure uom4 = new UnitOfMeasure();
        uom4.setTitle("Pinch");
        unitOfMeasureRepository.save(uom4);
        UnitOfMeasure uom5 = new UnitOfMeasure();
        uom5.setTitle("Ounce");
        unitOfMeasureRepository.save(uom5);
        UnitOfMeasure uom6 = new UnitOfMeasure();
        uom6.setTitle("Pint");
        unitOfMeasureRepository.save(uom6);
        UnitOfMeasure uom7 = new UnitOfMeasure();
        uom7.setTitle("Dash");
        unitOfMeasureRepository.save(uom7);
        UnitOfMeasure uom8 = new UnitOfMeasure();
        uom8.setTitle("Piece");
        unitOfMeasureRepository.save(uom8);
    }
}
