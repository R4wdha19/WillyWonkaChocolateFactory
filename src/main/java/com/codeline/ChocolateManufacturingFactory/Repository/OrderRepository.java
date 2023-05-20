package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select o from Order o where o.id =: orderId")
    Order getOrderById (@Param("orderId") Integer id);

    @Query("select i from Order i")
    Order getAllOrders();

    @Query(value = "select * from customer_order where created_Date Like Concat (?1,%)", nativeQuery = true)
    List<Order> getAllOrdersByCreatedDate(@Param("createdDate") String createdDate);

    @Query("select i from Order i where i.isActive = 1")
    List<Order> getAllActiveOrders();

    @Query("select i from Order i where i.isActive = 0")
    List<Order> getAllInActiveOrders();

    @Query(value = "select i from Order i where i.id = (select Max(i.id) from Order i )")
    Order getLatestRow();


    @Query(value = "select i from Order i where i.updatedDate = (select Max(i.updatedDate) from Order i)")
    Order getLatestUpdated();

    @Query(value = "select i from Order i where i.createdDate > :createdDate")
    List<Order> getAllOrdersCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Modifying
    @Transactional
    @Query(value = "update Order i Set i.isActive = false")
    void deleteAllOrder();

    @Query(value = "select i from Order i where i.createdDate > :createdDate")
    List<Order> deleteAllOrdersCreatedAfterDate(@Param("createdDate") Date createdDate);

}
