package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.IngredientRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.IngredientRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
            Product productById = productRepository.getProductById(request.getProduct().getId());
            ingredient.setIngredientsOfProduct(productById);
            ingredientRepository.save(ingredient);
        }

    }

    public Ingredient getIngredientById(Integer ingredientId) {
        return ingredientRepository.getIngredientById(ingredientId);
    }

    public Ingredient getLatestRow() {
        return ingredientRepository.getLatestRow();
    }

    public Ingredient getLatestUpdated() {
        return ingredientRepository.getLatestUpdated();
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.getAllIngredients();
    }

    public List<Ingredient> getAllIngredientsByCreatedDate(String createdDate) {
        return ingredientRepository.getAllIngredientsByCreatedDate(createdDate);
    }

    public List<Ingredient> getAllActiveIngredients() {
        return ingredientRepository.getAllActiveIngredients();
    }

    public List<Ingredient> getAllInActiveIngredients() {
        return ingredientRepository.getAllInActiveIngredients();
    }

    public List<Ingredient> getAllIngredientsCreatedAfterDate(Date createdDate) {
        return ingredientRepository.getAllIngredientsCreatedAfterDate(createdDate);
    }

    public void deleteAllIngredient() {
        ingredientRepository.deleteAllIngredient();
    }

    public void deleteAllIngredientCreatedAfterDate(Date createdDate) {
        List<Ingredient> ingredientList = ingredientRepository.deleteAllIngredientCreatedAfterDate(createdDate);
        ingredientList.stream().forEach(x -> x.setIsActive(false));
        ingredientRepository.saveAll(ingredientList);
    }

    public void updateIngredient(IngredientRequestObject ingredientRequestObject) {
        Ingredient ingredientById = ingredientRepository.getIngredientById(ingredientRequestObject.getId());
        ingredientById.setName(ingredientRequestObject.getName());
        ingredientById.setIngredientsOfProduct(ingredientRequestObject.getProduct());
        ingredientRepository.save(ingredientById);
    }
}
