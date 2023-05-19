package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.OrderRequestObject;
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
}
