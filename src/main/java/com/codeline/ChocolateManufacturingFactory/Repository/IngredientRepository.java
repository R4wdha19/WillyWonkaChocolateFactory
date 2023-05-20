package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

    @Query(value = "select i from Ingredient i where i.id = :ingredientId ")
    Ingredient getIngredientById(@Param("ingredientId") Integer id);
}
