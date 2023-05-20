package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.IngredientRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.IngredientRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    ProductRepository productRepository;

    public void createIngredient(IngredientRequestObject ingredientRequestObject) {
        Ingredient ingredient = IngredientRequestObject.convert(ingredientRequestObject);
        Product productById = productRepository.getProductById(ingredientRequestObject.getProduct().getProductId());
        ingredient.setIngredientsOfProduct(productById);
                ingredientRepository.save(ingredient);
    }
}
