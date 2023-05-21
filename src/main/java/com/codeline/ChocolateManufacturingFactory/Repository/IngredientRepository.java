package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

//    @Query("select i from Ingredient i where i.id = :ingredientId")
//    Ingredient getIngredientById(@Param("ingredientId") Integer id);
//
//    @Query("select i from Ingredient i")
//    Ingredient getAllIngredients();
//
//    @Query(value = "select * from ingredient where created_Date Like concat (?1,%)", nativeQuery = true)
//    List<Ingredient> getAllIngredientsByCreatedDate(@Param("createdDate") String createdDate);
//
//    @Query("select i from Ingredient i where i.isActive = 1")
//    List<Ingredient> getAllActiveIngredients();
//
//    @Query("select i from Ingredient i where i.isActive = 0")
//    List<Ingredient> getAllInActiveIngredients();
//
//    @Query(value = "select i from Ingredient i where i.id = (select Max(i.id) from Ingredient i )")
//    Ingredient getLatestRow();
//
//
//    @Query(value = "select i from Ingredient i where i.updatedDate = (select Max(i.updatedDate) from Ingredient i)")
//    Ingredient getLatestUpdated();
//
//    @Query(value = "select i from Ingredient i where i.createdDate > :createdDate")
//    List<Ingredient> getAllIngredientsCreatedAfterDate(@Param("createdDate") Date createdDate);
//
//    @Modifying
//    @Transactional
//    @Query(value = "update Ingredient i Set i.isActive = false")
//    void deleteAllIngredient();
//
//    @Query(value = "select i from Ingredient i where i.createdDate > :createdDate")
//    List<Ingredient> deleteAllIngredientCreatedAfterDate(@Param("createdDate") Date createdDate);


}
