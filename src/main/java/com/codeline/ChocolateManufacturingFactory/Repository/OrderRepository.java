package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select o from Order o where o.id =: orderId")
    Order getOrderById (@Param("orderId") Integer id);
}
