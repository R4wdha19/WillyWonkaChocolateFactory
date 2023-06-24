package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Builder
public class CustomerResponseObject {
    Integer id;
    String name;
    String contactNumber;
    String email;
    String paymentType;

    public static CustomerResponseObject convertRequestToResponse(Customer customerRequestFromUser) {
        return CustomerResponseObject.builder()
                .id(customerRequestFromUser.getCustomerId())
                .name(customerRequestFromUser.getName())
                .contactNumber(customerRequestFromUser.getPhoneNumber())
                .email(customerRequestFromUser.getEmail())
                .paymentType(customerRequestFromUser.getPaymentMethod())
                .build();
    }

    public static List<CustomerResponseObject> convertRequestListToResponseList(List<Customer> customerRequestFromUser) {
        List<CustomerResponseObject> customerResponseList = new ArrayList<>();
        if (!customerRequestFromUser.isEmpty()) {
            for (Customer customerRequest : customerRequestFromUser) {
                customerResponseList.add(convertRequestToResponse(customerRequest));
            }
        }
        return customerResponseList;
    }
}
