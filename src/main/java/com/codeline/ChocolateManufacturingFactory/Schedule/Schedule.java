package com.codeline.ChocolateManufacturingFactory.Schedule;

import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.OrderRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Schedule {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Scheduled(cron = "0 0 0 * * *")
    public void getAllOrdersByCreatedDate() {
        List<Order> ordersByCreatedDate = orderRepository.getAllOrdersByCreatedDate(new Date().toString());
        for (Order order : ordersByCreatedDate) {
            Integer productCurrentQuantity = order.getProduct().getProductAvailableQuantity();
            Integer productOrderedQuantity = order.getOrderQuantity();
            Integer productUpdatedQuantity = productCurrentQuantity - productOrderedQuantity;
            Product productTotalRemainingQuantity = order.getProduct();
            productTotalRemainingQuantity.setProductAvailableQuantity(productUpdatedQuantity);
            productRepository.save(productTotalRemainingQuantity);
        }
    }
}
