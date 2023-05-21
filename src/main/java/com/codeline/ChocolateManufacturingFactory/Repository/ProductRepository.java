package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p from Product p where p.id =:productId")
    Product getProductById(@Param("productId") Integer id);

    @Query("select p from Product p")
    Product getAllProducts();

    @Query(value = "select * from Product where created_Date Like Concat (?1,%)", nativeQuery = true)
    List<Product> getAllProductsByCreatedDate(@Param("createdDate") String createdDate);

    @Query("select p from Product p where p.isActive = 1")
    List<Product> getAllActiveProducts();

    @Query("select p from Product p where p.isActive = 0")
    List<Product> getAllInActiveProducts();

    @Query(value = "select p from Product p where p.id = (select Max(p.id) from Product p )")
    Product getLatestRow();


    @Query(value = "select p from Product p where p.updatedDate = (select Max(p.updatedDate) from Product p)")
    Product getLatestUpdated();

    @Query(value = "select p from Product p where p.createdDate > :createdDate")
    List<Product> getAllProductsCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Modifying
    @Transactional
    @Query(value = "update Product p Set p.isActive = false")
    void deleteAllProduct();

    @Query(value = "select p from Product p where p.createdDate > :createdDate")
    List<Product> deleteAllProductsCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query("select p from Product p where p.inventory.id = :inventoryId")
    List<Product> allProductsByInventoryId(@Param("inventoryId") Integer inventoryId);

}
