package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Repository.CustomerRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.CustomerRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void createCustomer(CustomerRequestObject customerRequestObject) {
        Customer customer = CustomerRequestObject.convert(customerRequestObject);
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public List<Customer> getAllCustomersByCreatedDate(String createdDate) {
        return customerRepository.getAllCustomersByCreatedDate(createdDate);
    }

    public List<Customer> getAllActiveCustomers() {
        return customerRepository.getAllActiveCustomers();
    }

    public List<Customer> getAllInActiveCustomers() {
        return customerRepository.getAllInActiveCustomers();
    }

    public Customer getLatestRow() {
        return customerRepository.getLatestRow();
    }

    public Customer getLatestUpdated() {
        return customerRepository.getLatestUpdated();
    }

    public List<Customer> getAllCustomersCreatedAfterDate(Date createdDate) {
        return customerRepository.getAllCustomersCreatedAfterDate(createdDate);
    }

    public List<Customer> deleteAllCustomerCreatedAfterDate(Date createdDate) {
        return customerRepository.deleteAllCustomerCreatedAfterDate(createdDate);
    }

    public void deleteAllCustomer() {
        customerRepository.deleteAllCustomer();
    }

    public String deleteCustomerById(Integer customerId){
        Customer customer = customerRepository.getCustomerById(customerId);
        customer.setIsActive(false);
        return "Customer Id "+customerId +"Deleted Successfully ";
    }


}
