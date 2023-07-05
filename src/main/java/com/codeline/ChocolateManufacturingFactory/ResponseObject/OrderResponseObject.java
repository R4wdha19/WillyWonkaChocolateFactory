package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@Builder
public class OrderResponseObject {
    Integer id;
    String address;
    Integer quantity;
    Customer customer;
    Product product;
    Double paidAmount;
    Double remainingAmount;

    public static OrderResponseObject convertRequestToResponse(Order requestFromUser) {
        return OrderResponseObject.builder()
                .id(requestFromUser.getId())
                .address(requestFromUser.getShippingAddress())
                .quantity(requestFromUser.getQuantity())
                .customer(requestFromUser.getCustomerHistoryOfOrders())
                .product(requestFromUser.getProduct())
                .build();
    }

    public static List<OrderResponseObject> convertRequestToListResponse(List<Order> requestFromUser) {
        List<OrderResponseObject> ordersList = new ArrayList<>();

        if (!requestFromUser.isEmpty()) {
            for (Order orderRequest : requestFromUser) {
                ordersList.add(convertRequestToResponse(orderRequest));
            }
        }
        return ordersList;
    }
}
