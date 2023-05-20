package com.codeline.ChocolateManufacturingFactory.RequestObject;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class IngredientRequestObject {
    Integer ingredientId;
    String ingredientName;
    Product product;
    public static Ingredient convert(IngredientRequestObject request) {

        Ingredient ingredient = new Ingredient();

        ingredient.setIngredientName(request.getIngredientName());
        ingredient.setIsActive(true);
        ingredient.setCreatedDate(new Date());
        return ingredient;
    }

    public static List<Ingredient> convert(List<IngredientRequestObject> requestList) {
        List<Ingredient> ingredients = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (IngredientRequestObject ingredientRequest : requestList) {
                ingredients.add(convert(ingredientRequest));
            }
        }
        return ingredients;


    }
}
