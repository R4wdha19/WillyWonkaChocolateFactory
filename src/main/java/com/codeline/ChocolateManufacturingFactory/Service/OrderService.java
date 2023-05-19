package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.Repository.OrderRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.OrderRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void createOrder(OrderRequestObject orderRequestObject) {
        Order order = OrderRequestObject.convert(orderRequestObject);
        orderRepository.save(order);
    }
}
