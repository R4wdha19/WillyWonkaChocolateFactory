package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import com.codeline.ChocolateManufacturingFactory.RequestObject.IngredientRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.IngredientResponseObject;
import com.codeline.ChocolateManufacturingFactory.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public IngredientResponseObject getIngredientById(@RequestParam Integer ingredientId) {
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
    public List<IngredientResponseObject> getAllIngredientsByCreatedDate(@RequestParam String createdDate) {
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
    public List<IngredientResponseObject> getAllIngredientsCreatedAfterDate(@RequestParam Date createdDate) {
        List<Ingredient> ingredientList = ingredientService.getAllIngredientsCreatedAfterDate(createdDate);
        List<IngredientResponseObject> ingredientResponseList = IngredientResponseObject.convertRequestListToResponseList(ingredientList);
        return ingredientResponseList;
    }
    @PreAuthorize("hasRole('ADMIN')")
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
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllIngredientCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllIngredientCreatedAfterDate(@RequestParam Date createdDate) {
        ingredientService.deleteAllIngredientCreatedAfterDate(createdDate);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "updateIngredient", method = RequestMethod.POST)
    public void updateIngredient(@RequestBody IngredientRequestObject ingredientRequestObject) {
        ingredientService.updateIngredient(ingredientRequestObject);
    }
}
