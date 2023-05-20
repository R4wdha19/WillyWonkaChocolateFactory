package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query(value ="select i from Inventory i where i.id =:inventoryId")
     Inventory getInventoryById(@Param("inventoryId") Integer id);

    @Query("select i from Inventory i")
    Inventory getAllInventories();

    @Query(value = "select * from Inventory where created_Date Like Concat (?1,%)", nativeQuery = true)
    List<Inventory> getAllInventoriesByCreatedDate(@Param("createdDate") String createdDate);

    @Query("select i from Inventory i where i.isActive = 1")
    List<Inventory> getAllActiveInventories();

    @Query("select i from Inventory i where i.isActive = 0")
    List<Inventory> getAllInActiveInventories();

    @Query(value = "select i from Inventory i where i.id = (select Max(i.id) from Inventory i )")
    Inventory getLatestRow();


    @Query(value = "select i from Inventory i where i.updatedDate = (select Max(i.updatedDate) from Inventory i)")
    Inventory getLatestUpdated();

    @Query(value = "select i from Inventory i where i.createdDate > :createdDate")
    List<Inventory> getAllInventoriesCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Modifying
    @Transactional
    @Query(value = "update Inventory i Set i.isActive = false")
    void deleteAllInventory();

    @Query(value = "select i from Inventory i where i.createdDate > :createdDate")
    List<Inventory> deleteAllInventoriesCreatedAfterDate(@Param("createdDate") Date createdDate);
}
