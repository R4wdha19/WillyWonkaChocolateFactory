package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.RequestObject.CustomerRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.CustomerResponseObject;
import com.codeline.ChocolateManufacturingFactory.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "createCustomer", method = RequestMethod.POST)
    public void createCustomer(@RequestBody CustomerRequestObject customerRequestObject) {
        customerService.createCustomer(customerRequestObject);
    }
    @RequestMapping(value = "getCustomerById", method = RequestMethod.POST)
    public CustomerResponseObject getCustomerById(@RequestParam Integer customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        CustomerResponseObject customerResponse = CustomerResponseObject.convertRequestToResponse(customer);
        return customerResponse;
    }


}
