package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.RequestObject.CustomerRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.CustomerResponseObject;
import com.codeline.ChocolateManufacturingFactory.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "createCustomer", method = RequestMethod.POST)
    public void createCustomer(@RequestBody CustomerRequestObject customerRequestObject) {
        customerService.createCustomer(customerRequestObject);
    }

    @RequestMapping(value = "getCustomerById", method = RequestMethod.GET)
    public CustomerResponseObject getCustomerById(@RequestParam Integer customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        CustomerResponseObject customerResponse = CustomerResponseObject.convertRequestToResponse(customer);
        return customerResponse;
    }

    @RequestMapping(value = "getAllCustomers", method = RequestMethod.GET)
    public List<CustomerResponseObject> getAllCustomers() {
        List<Customer> listOfCustomers = customerService.getAllCustomers();
        List<CustomerResponseObject> customerResponseList = CustomerResponseObject.convertRequestListToResponseList(listOfCustomers);
        return customerResponseList;
    }

    @RequestMapping(value = "getAllCustomersByCreatedDate", method = RequestMethod.GET)
    public List<CustomerResponseObject> getAllCustomersByCreatedDate(@RequestParam String createdDate) {
        List<Customer> listOfCustomers = customerService.getAllCustomersByCreatedDate(createdDate);
        List<CustomerResponseObject> customerResponseList = CustomerResponseObject.convertRequestListToResponseList(listOfCustomers);
        return customerResponseList;
    }

    @RequestMapping(value = "getAllActiveCustomers", method = RequestMethod.GET)
    public List<CustomerResponseObject> getAllActiveCustomers() {
        List<Customer> listOfCustomers = customerService.getAllActiveCustomers();
        List<CustomerResponseObject> customerResponseList = CustomerResponseObject.convertRequestListToResponseList(listOfCustomers);
        return customerResponseList;
    }

    @RequestMapping(value = "getAllInActiveCustomers", method = RequestMethod.GET)
    public List<CustomerResponseObject> getAllInActiveCustomers() {
        List<Customer> listOfCustomers = customerService.getAllInActiveCustomers();
        List<CustomerResponseObject> customerResponseList = CustomerResponseObject.convertRequestListToResponseList(listOfCustomers);
        return customerResponseList;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public CustomerResponseObject getLatestRow() {
        Customer customer = customerService.getLatestRow();
        CustomerResponseObject customerResponse = CustomerResponseObject.convertRequestToResponse(customer);
        return customerResponse;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public CustomerResponseObject getLatestUpdated() {
        Customer customer = customerService.getLatestUpdated();
        CustomerResponseObject customerResponse = CustomerResponseObject.convertRequestToResponse(customer);
        return customerResponse;
    }

    @RequestMapping(value = "getAllCustomersCreatedAfterDate", method = RequestMethod.GET)
    public List<CustomerResponseObject> getAllCustomersCreatedAfterDate(Date createdDate) {
        List<Customer> listOfCustomers = customerService.getAllCustomersCreatedAfterDate(createdDate);
        List<CustomerResponseObject> customerResponseList = CustomerResponseObject.convertRequestListToResponseList(listOfCustomers);
        return customerResponseList;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllCustomerCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllCustomerCreatedAfterDate(Date createdDate) {
        customerService.deleteAllCustomerCreatedAfterDate(createdDate);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllCustomer", method = RequestMethod.POST)
    public void deleteAllCustomer() {
        customerService.deleteAllCustomer();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteCustomerById", method = RequestMethod.GET)
    public String deleteCustomerById(Integer customerId) {
        try {
            customerService.deleteCustomerById(customerId);
        } catch (Exception e) {
            return "Deleting Failed Please Check The Id";
        }
        return " Customer Id " + customerId + " Deleted Successfully ";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "updateCustomerDetails", method = RequestMethod.POST)
    public void updateCustomerDetails(@RequestBody CustomerRequestObject customerRequestObject) {
        customerService.updateCustomerDetails(customerRequestObject);
    }
}
