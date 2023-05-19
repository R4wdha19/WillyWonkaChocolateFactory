package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.CustomerRequestObject;
import com.codeline.ChocolateManufacturingFactory.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "createCustomer", method = RequestMethod.POST)
    public void createCustomer(@RequestBody CustomerRequestObject customerRequestObject) {
        customerService.createCustomer(customerRequestObject);
    }
}
