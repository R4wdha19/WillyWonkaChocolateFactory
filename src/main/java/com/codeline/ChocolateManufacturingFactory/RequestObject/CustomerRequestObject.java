package com.codeline.ChocolateManufacturingFactory.RequestObject;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class CustomerRequestObject {
    Integer customerId;
    String customerName;
    String customerPhoneNumber;
    String customerEmail;
    String customerPaymentMethod;


    public static Customer convert(CustomerRequestObject request) {

        Customer customer = new Customer();

        customer.setName(request.getCustomerName());
        customer.setPhoneNumber(request.getCustomerPhoneNumber());
        customer.setEmail(request.getCustomerEmail());
        customer.setPaymentMethod(request.getCustomerPaymentMethod());
        customer.setIsActive(true);
        customer.setCreatedDate(new Date());
        return customer;
    }

    public static List<Customer> convert(List<CustomerRequestObject> requestList) {
        List<Customer> customers = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (CustomerRequestObject customerRequest : requestList) {
                customers.add(convert(customerRequest));
            }
        }
        return customers;


    }
}
