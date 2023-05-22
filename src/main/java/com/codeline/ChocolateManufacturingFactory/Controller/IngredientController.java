package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.IngredientRequestObject;
import com.codeline.ChocolateManufacturingFactory.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Ingredient")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @RequestMapping(value = "createIngredient", method = RequestMethod.POST)
    public void createIngredient(@RequestBody List<IngredientRequestObject> ingredientRequestObject) {
        ingredientService.createIngredient(ingredientRequestObject);
    }

}
