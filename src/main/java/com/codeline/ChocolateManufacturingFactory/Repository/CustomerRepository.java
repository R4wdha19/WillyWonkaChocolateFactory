package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where c.id = :customerId")
    Customer getCustomerById(@Param("customerId") Integer id);

}
