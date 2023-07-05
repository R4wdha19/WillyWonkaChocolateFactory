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

    public void deleteAllCustomerCreatedAfterDate(Date createdDate) {
        List<Customer> listOfCustomers =customerRepository.deleteAllCustomerCreatedAfterDate(createdDate);
        listOfCustomers.stream().forEach(x-> x.setIsActive(false));
        customerRepository.saveAll(listOfCustomers);
    }

    public void deleteAllCustomer() {
        customerRepository.deleteAllCustomer();
    }

    public String deleteCustomerById(Integer customerId) {
        Customer customer = customerRepository.getCustomerById(customerId);
        customer.setIsActive(false);
        customerRepository.save(customer);
        return "Customer Id " + customerId + "Deleted Successfully ";
    }

    public void updateCustomerDetails(CustomerRequestObject customerRequestObject) {
        Customer customer = customerRepository.getCustomerById(customerRequestObject.getId());
        customer.setEmail(customerRequestObject.getEmail());
        customer.setPaymentMethod(customerRequestObject.getPaymentMethod());
        customer.setPhoneNumber(customerRequestObject.getPhoneNumber());
        customer.setUpdatedDate(new Date());
        customerRepository.save(customer);
    }

}
