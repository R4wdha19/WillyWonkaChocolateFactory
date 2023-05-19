package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.Repository.IngredientRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.IngredientRequestObject;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    public void createIngredient(IngredientRequestObject ingredientRequestObject) {
        Ingredient ingredient = IngredientRequestObject.convert(ingredientRequestObject);
        ingredientRepository.save(ingredient);
    }
}
