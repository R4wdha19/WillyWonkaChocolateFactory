package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.CustomerResponseObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerControllerTest {
    @Autowired
    CustomerController customerController;

    @Test
    void testingGetCustomerById() throws Exception {
        CustomerResponseObject customerById = customerController.getCustomerById(1);
        Integer customerId = customerById.getId();
        assertEquals(1, customerId);
    }

    @Test
    void testingTheCourseListSize() throws Exception {
        List<CustomerResponseObject> customerResponseObjectList = customerController.getAllCustomers();
        Integer listSize = customerResponseObjectList.size();
        assertNotEquals(0, listSize);
    }

    @Test
    void testingSizeOfAllActiveCourses() {
        List<CustomerResponseObject> allActiveCustomers = customerController.getAllActiveCustomers();
        Integer sizeOfActiveCustomersList = allActiveCustomers.size();
        assertNotNull(sizeOfActiveCustomersList);
    }
}