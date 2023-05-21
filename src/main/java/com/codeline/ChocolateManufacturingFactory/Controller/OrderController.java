package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.RequestObject.OrderRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.CustomerResponseObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.OrderResponseObject;
import com.codeline.ChocolateManufacturingFactory.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "Order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "createOrder", method = RequestMethod.POST)
    public void createOrder(@RequestBody OrderRequestObject orderRequestObject) {
        orderService.createOrder(orderRequestObject);
    }
    @RequestMapping(value = "getOrderById", method = RequestMethod.POST)
    public OrderResponseObject getOrderById(@RequestParam Integer orderId) {
        Order orderById = orderService.getOrderById(orderId);
        OrderResponseObject OrderResponse = OrderResponseObject.convertRequestToResponse(orderById);
        return OrderResponse;
    }
}
