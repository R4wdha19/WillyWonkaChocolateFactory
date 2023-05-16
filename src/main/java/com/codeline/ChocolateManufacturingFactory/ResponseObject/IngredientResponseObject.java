package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Builder
public class IngredientResponseObject {
    Integer id;
    String name;
    Product product;

    public static IngredientResponseObject convertRequestToResponse(Ingredient ingredientRequestFromUser) {
        return IngredientResponseObject.builder()
                .id(ingredientRequestFromUser.getIngredientId())
                .name(ingredientRequestFromUser.getIngredientName())
                .product(ingredientRequestFromUser.getIngredientsOfProduct())
                .build();
    }

    public static List<IngredientResponseObject> convertRequestListToResponseList(List<Ingredient> ingredientRequestFromUser) {
        List<IngredientResponseObject> ingredientResponseList = new ArrayList<>();
        if (!ingredientRequestFromUser.isEmpty()) {
            for (Ingredient ingredientRequest : ingredientRequestFromUser) {
                ingredientResponseList.add(convertRequestToResponse(ingredientRequest));
            }
        }
        return ingredientResponseList;
    }

}
