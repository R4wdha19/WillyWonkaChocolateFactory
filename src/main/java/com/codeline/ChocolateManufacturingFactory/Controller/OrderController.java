package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.RequestObject.OrderRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.OrderResponseObject;
import com.codeline.ChocolateManufacturingFactory.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "updateOrder", method = RequestMethod.POST)
    public void updateOrder(@RequestBody OrderRequestObject orderRequestObject) {
        orderService.updateOrder(orderRequestObject);
    }

    @RequestMapping(value = "getAllOrders", method = RequestMethod.GET)
    public List<OrderResponseObject> getAllOrders() {
        return OrderResponseObject.convertRequestToListResponse(orderService.getAllOrders());
    }

    @RequestMapping(value = "getAllActiveOrders", method = RequestMethod.GET)
    public List<OrderResponseObject> getAllActiveOrders() {
        return OrderResponseObject.convertRequestToListResponse(orderService.getAllActiveOrders());
    }

    @RequestMapping(value = "getAllInActiveOrders", method = RequestMethod.GET)
    public List<OrderResponseObject> getAllInActiveOrders() {
        return OrderResponseObject.convertRequestToListResponse(orderService.getAllInActiveOrders());
    }

    @RequestMapping(value = "getAllOrdersCreatedAfterDate", method = RequestMethod.GET)
    public List<OrderResponseObject> getAllOrdersCreatedAfterDate(Date createdDate) {
        return OrderResponseObject.convertRequestToListResponse(orderService.getAllOrdersCreatedAfterDate(createdDate));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllOrder", method = RequestMethod.GET)
    public void deleteAllOrder() {
        orderService.deleteAllOrder();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllOrdersCreatedAfterDate", method = RequestMethod.GET)
    public void deleteAllOrdersCreatedAfterDate(Date createdDate) {
        orderService.deleteAllOrdersCreatedAfterDate(createdDate);
    }
}
