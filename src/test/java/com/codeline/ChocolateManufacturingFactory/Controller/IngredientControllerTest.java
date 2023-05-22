package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.ResponseObject.IngredientResponseObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class IngredientControllerTest {
    @Autowired
    IngredientController ingredientController;



    @Test
    void testingGetLatestRow() {
        IngredientResponseObject latestIngredientRow = ingredientController.getLatestRow();
        assertNotNull(latestIngredientRow);
    }

//    @Test
//    void testingTheStatusFromGetCourseById() throws Exception {
//        IngredientResponseObject ingredientById = ingredientController.getIngredientById(5);
//        Boolean status = ingredientById.getProduct().getIsActive();
//        assertTrue(status);
//    }

    @Test
    void testingSizeOfAllActiveIngredient() {
        List<IngredientResponseObject> allActiveIngredients = ingredientController.getAllActiveIngredients();
        assertEquals(128,allActiveIngredients.size());
    }
}