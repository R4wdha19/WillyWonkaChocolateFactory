package com.codeline.ChocolateManufacturingFactory.Repository;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where c.id = :customerId")
    Customer getCustomerById(@Param("customerId") Integer id);

    @Query("select c from Customer c")
    List<Customer> getAllCustomers();

    @Query(value = "select * from customer where created_Date Like concat (?1,%)", nativeQuery = true)
    List<Customer> getAllCustomersByCreatedDate(@Param("createdDate") String createdDate);

    @Query("select c from Customer c where c.isActive = 1")
    List<Customer> getAllActiveCustomers();

    @Query("select c from Customer c where c.isActive = 0")
    List<Customer> getAllInActiveCustomers();

    @Query(value = "select c from Customer c where c.id = (select Max(c.id) from Customer c )")
    Customer getLatestRow();


    @Query(value = "select c from Customer c where c.updatedDate = (select Max(c.updatedDate) from Customer c)")
    Customer getLatestUpdated();

    @Query(value = "select c from Customer c where c.createdDate > :createdDate")
    List<Customer> getAllCustomersCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Modifying
    @Transactional
    @Query(value = "update Customer c Set c.isActive = false")
    void deleteAllCustomer();

    @Query(value = "select c from Customer c where c.createdDate > :createdDate")
    void deleteAllCustomerCreatedAfterDate(@Param("createdDate") Date createdDate);




}
