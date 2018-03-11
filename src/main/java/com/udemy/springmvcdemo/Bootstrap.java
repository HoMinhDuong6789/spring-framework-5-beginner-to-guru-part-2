package com.udemy.springmvcdemo;

import com.udemy.springmvcdemo.domain.*;
import com.udemy.springmvcdemo.repositories.CategoryRepository;
import com.udemy.springmvcdemo.repositories.RecipeRepository;
import com.udemy.springmvcdemo.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Profile("default")
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public Bootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("in Bootstrap.onApplicationEvent()");
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> teaSpoonMeasureOptional = unitOfMeasureRepository.findByTitle("Teaspoon");
        if (!teaSpoonMeasureOptional.isPresent()) {
            throw new RuntimeException("Teaspoon UnitOfMeasure Is Not Present");
        }

        Optional<UnitOfMeasure> tableSpoonMeasureOptional = unitOfMeasureRepository.findByTitle("Tablespoon");
        if (!tableSpoonMeasureOptional.isPresent()) {
            throw new RuntimeException("Tablespoon UnitOfMeasure Is Not Present");
        }

        Optional<UnitOfMeasure> cupsMeasureOptional = unitOfMeasureRepository.findByTitle("Cup");
        if (!cupsMeasureOptional.isPresent()) {
            throw new RuntimeException("Cup UnitOfMeasure Is Not Present");
        }

        Optional<UnitOfMeasure> pinchMeasureOptional = unitOfMeasureRepository.findByTitle("Pinch");
        if (!pinchMeasureOptional.isPresent()) {
            throw new RuntimeException("Pinch UnitOfMeasure Is Not Present");
        }

        Optional<UnitOfMeasure> ounceMeasureOptional = unitOfMeasureRepository.findByTitle("Ounce");
        if (!ounceMeasureOptional.isPresent()) {
            throw new RuntimeException("Ounce UnitOfMeasure Is Not Present");
        }

        Optional<UnitOfMeasure> dashMeasureOptional = unitOfMeasureRepository.findByTitle("Dash");
        if (!dashMeasureOptional.isPresent()) {
            throw new RuntimeException("Dash UnitOfMeasure Is Not Present");
        }

        Optional<UnitOfMeasure> pintMeasureOptional = unitOfMeasureRepository.findByTitle("Pint");
        if (!pintMeasureOptional.isPresent()) {
            throw new RuntimeException("Pint UnitOfMeasure Is Not Present");
        }

        Optional<UnitOfMeasure> pieceMeasureOptional = unitOfMeasureRepository.findByTitle("Piece");
        if (!pieceMeasureOptional.isPresent()) {
            throw new RuntimeException("Piece UnitOfMeasure Is Not Present");
        }

        UnitOfMeasure teapoonMeasure = teaSpoonMeasureOptional.get();
        UnitOfMeasure tableSpoonMeasure = tableSpoonMeasureOptional.get();
        UnitOfMeasure cupsMeasure = cupsMeasureOptional.get();
        UnitOfMeasure dashMeasure = dashMeasureOptional.get();
        UnitOfMeasure pintMeasure = dashMeasureOptional.get();
        UnitOfMeasure pieceMeasure = pieceMeasureOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("American Category Is Not Present");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("Mexican Category Is Not Present");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setServings(4);
        guacamoleRecipe.setSource("ELISE BAUER");
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown." +
                "\nAdd the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness." +
                "\nRemember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                "\n4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve." +
                "\nChilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving." +
                "\nFor a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados." +
                "\nFeel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries." +
                "\nThe simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole." +
                "\nTo extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Guacamole, a dip made from avocados, is originally from Mexico. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce)." +
                "\nAll you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato." +
                "\nThe trick to making perfect guacamole is using good, ripe avocados." +
                "\nCheck for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");
        guacamoleRecipe.setNotes(guacamoleNotes);
        guacamoleRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), pieceMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(".5"), teapoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), pieceMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("cilantro", new BigDecimal(2), tableSpoonMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashMeasure));
        guacamoleRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), pieceMeasure));
        guacamoleRecipe.getCategories().add(americanCategory);
        guacamoleRecipe.getCategories().add(mexicanCategory);
        recipes.add(guacamoleRecipe);

        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacoRecipe.setCookTime(15);
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setServings(6);
        tacoRecipe.setSource("SALLY VARGAS");
        tacoRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacoRecipe.setDifficulty(Difficulty.EASY);
        tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat." +
                "\n2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over." +
                "\nSet aside to marinate while the grill heats and you prepare the rest of the toppings." +
                "\n3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes." +
                "\n4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side." +
                "\nWrap warmed tortillas in a tea towel to keep them warm until serving." +
                "\n5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla." +
                "\nAny and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house." +
                "\nToday’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!" +
                "\nFirst, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings." +
                "\nGrill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!" +
                "\nThe ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online." +
                "\nI like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos." +
                "\nEveryone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\nYou could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!");
        tacoRecipe.setNotes(tacoNotes);
        tacoRecipe.addIngredient(new Ingredient("ancho chili Powder", new BigDecimal(2), tableSpoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), teapoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), teapoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("sugar", new BigDecimal(1), teapoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("salt", new BigDecimal(".5"), teapoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("clove of garlic, choppedr", new BigDecimal(1), pieceMeasure));
        tacoRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("olive oil", new BigDecimal(2), tableSpoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSpoonMeasure));
        tacoRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), pieceMeasure));
        tacoRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupsMeasure));
        tacoRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), pieceMeasure));
        tacoRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), pieceMeasure));
        tacoRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pintMeasure));
        tacoRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), pieceMeasure));
        tacoRecipe.addIngredient(new Ingredient("roughly chopped cilantro", new BigDecimal(4), pieceMeasure));
        tacoRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupsMeasure));
        tacoRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), pieceMeasure));
        tacoRecipe.getCategories().add(americanCategory);
        tacoRecipe.getCategories().add(mexicanCategory);
        recipes.add(tacoRecipe);
        return recipes;
    }
}
