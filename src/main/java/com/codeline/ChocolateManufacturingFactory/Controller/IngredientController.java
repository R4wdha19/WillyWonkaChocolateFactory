package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.RequestObject.IngredientRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.IngredientResponseObject;
import com.codeline.ChocolateManufacturingFactory.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @RequestMapping(value = "getIngredientById", method = RequestMethod.GET)
    public IngredientResponseObject getIngredientById(Integer ingredientId) {
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
        IngredientResponseObject ingredientResponse = IngredientResponseObject.convertRequestToResponse(ingredient);
        return ingredientResponse;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public IngredientResponseObject getLatestRow() {
        Ingredient ingredient = ingredientService.getLatestRow();
        IngredientResponseObject ingredientResponse = IngredientResponseObject.convertRequestToResponse(ingredient);
        return ingredientResponse;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public IngredientResponseObject getLatestUpdated() {
        Ingredient ingredient = ingredientService.getLatestUpdated();
        IngredientResponseObject ingredientResponse = IngredientResponseObject.convertRequestToResponse(ingredient);
        return ingredientResponse;
    }

    @RequestMapping(value = "getAllIngredients", method = RequestMethod.GET)
    public List<IngredientResponseObject> getAllIngredients() {
        List<Ingredient> ingredientList = ingredientService.getAllIngredients();
        List<IngredientResponseObject> ingredientResponseList = IngredientResponseObject.convertRequestListToResponseList(ingredientList);
        return ingredientResponseList;
    }

    @RequestMapping(value = "getAllIngredientsByCreatedDate", method = RequestMethod.GET)
    public List<IngredientResponseObject> getAllIngredientsByCreatedDate(String createdDate) {
        List<Ingredient> ingredientList = ingredientService.getAllIngredientsByCreatedDate(createdDate);
        List<IngredientResponseObject> ingredientResponseList = IngredientResponseObject.convertRequestListToResponseList(ingredientList);
        return ingredientResponseList;
    }

    @RequestMapping(value = "getAllActiveIngredients", method = RequestMethod.GET)
    public List<IngredientResponseObject> getAllActiveIngredients() {
        List<Ingredient> ingredientList = ingredientService.getAllActiveIngredients();
        List<IngredientResponseObject> ingredientResponseList = IngredientResponseObject.convertRequestListToResponseList(ingredientList);
        return ingredientResponseList;
    }

    @RequestMapping(value = "getAllIngredientsCreatedAfterDate", method = RequestMethod.GET)
    public List<IngredientResponseObject> getAllIngredientsCreatedAfterDate(Date createdDate) {
        List<Ingredient> ingredientList = ingredientService.getAllIngredientsCreatedAfterDate(createdDate);
        List<IngredientResponseObject> ingredientResponseList = IngredientResponseObject.convertRequestListToResponseList(ingredientList);
        return ingredientResponseList;
    }

    @RequestMapping(value = "deleteAllIngredient", method = RequestMethod.POST)
    public void deleteAllIngredient() {
        ingredientService.deleteAllIngredient();
    }

    @RequestMapping(value = "getAllInActiveIngredients", method = RequestMethod.GET)
    public List<IngredientResponseObject> getAllInActiveIngredients() {
        List<Ingredient> ingredientList = ingredientService.getAllInActiveIngredients();
        List<IngredientResponseObject> ingredientResponseList = IngredientResponseObject.convertRequestListToResponseList(ingredientList);
        return ingredientResponseList;
    }

    @RequestMapping(value = "getAllInActiveIngredients", method = RequestMethod.POST)
    public void deleteAllIngredientCreatedAfterDate(Date createdDate) {
        ingredientService.deleteAllIngredientCreatedAfterDate(createdDate);
    }
    @RequestMapping(value = "updateIngredient", method = RequestMethod.POST)
    public void updateIngredient(@RequestBody IngredientRequestObject ingredientRequestObject) {
        ingredientService.updateIngredient(ingredientRequestObject);
    }
}
