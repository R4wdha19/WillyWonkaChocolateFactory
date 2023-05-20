package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query(value ="select i from Inventory i where i.id =:inventoryId")
     Inventory getInventoryById(@Param("inventoryId") Integer id);
}
