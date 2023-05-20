package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.CustomerRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.OrderRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.OrderRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    public void createOrder(OrderRequestObject orderRequestObject) {
        Order order = OrderRequestObject.convert(orderRequestObject);
        Customer customer = customerRepository.getCustomerById(orderRequestObject.getCustomer().getCustomerId());
        Product product = productRepository.getProductById(orderRequestObject.getProduct().getProductId());
       order.setProduct(product);
       order.setCustomerHistoryOfOrders(customer);
        orderRepository.save(order);
    }
}
