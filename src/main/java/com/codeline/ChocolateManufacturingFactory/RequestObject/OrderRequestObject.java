package com.codeline.ChocolateManufacturingFactory.RequestObject;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
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
    Product product;
    Double customerPaidAmount;
    Double customerRemainingAmount;

    public static Order convert(OrderRequestObject request) {

        Order order = new Order();
        order.setOrderShippingAddress(request.getOrderShippingAddress());
        order.setOrderQuantity(request.getOrderQuantity());
        order.setCustomerPaidAmount(request.getCustomerPaidAmount());
        order.setCustomerRemainingAmount(request.getCustomerRemainingAmount());
        order.setIsActive(true);
        order.setCreatedDate(new Date());
        return order;
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
