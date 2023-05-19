package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Repository.CustomerRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.CustomerRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void createCustomer(CustomerRequestObject customerRequestObject) {
        Customer customer = CustomerRequestObject.convert(customerRequestObject);
        customerRepository.save(customer);
    }
}
