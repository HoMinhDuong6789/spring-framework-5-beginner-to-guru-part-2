package com.udemy.springmvcdemo.controllers;

import com.udemy.springmvcdemo.domain.Category;
import com.udemy.springmvcdemo.domain.UnitOfMeasure;
import com.udemy.springmvcdemo.repositories.CategoryRepository;
import com.udemy.springmvcdemo.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Russian");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByTitle("Teaspoon");
        System.out.println("Category Id is: " + categoryOptional.get().getId());
        System.out.println("UnitOfMeasure ID is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
