package com.codeline.ChocolateManufacturingFactory.RequestObject;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Model.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class OrderRequestObject {
    Integer orderId;
    String orderShippingAddress;
    Integer orderQuantity;
    Customer customer;
    public static Order convert(OrderRequestObject request) {

        Order inventory = new Order();
        inventory.setOrderShippingAddress(request.getOrderShippingAddress());
        inventory.setOrderQuantity(request.getOrderQuantity());
        inventory.setCustomerHistoryOfOrders(request.getCustomer());
        inventory.setIsActive(true);
        inventory.setCreatedDate(new Date());
        return inventory;
    }

    public static List<Order> convert(List<OrderRequestObject> requestList) {
        List<Order> orders = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (OrderRequestObject orderRequest : requestList) {
                orders.add(convert(orderRequest));
            }
        }
        return orders;

    }
}
