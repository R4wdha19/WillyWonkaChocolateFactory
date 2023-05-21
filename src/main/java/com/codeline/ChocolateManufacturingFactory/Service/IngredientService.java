package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.IngredientRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.IngredientRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    ProductRepository productRepository;

    public void createIngredient(List<IngredientRequestObject> ingredientRequestObject) {

        for (IngredientRequestObject request : ingredientRequestObject) {
            Ingredient ingredient = IngredientRequestObject.convert(request);

            Product productById = productRepository.getProductById(request.getProduct().getProductId());
            ingredient.setIngredientsOfProduct(productById);
            ingredientRepository.save(ingredient);
        }

    }
}
