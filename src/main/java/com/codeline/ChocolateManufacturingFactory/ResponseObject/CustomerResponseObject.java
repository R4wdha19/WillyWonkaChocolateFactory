package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
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
public class CustomerResponseObject {
    Integer id;
    String name;
    String contactNumber;
    String email;
    String payment;
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
