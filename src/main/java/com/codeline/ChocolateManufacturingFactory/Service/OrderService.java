package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.DTO.CustomerOrderDTO;
import com.codeline.ChocolateManufacturingFactory.Model.Customer;
import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.CustomerRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.OrderRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.OrderRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        Product product = productRepository.
                getProductById(orderRequestObject.getProduct().getProductId());
        order.setProduct(product);
        order.setCustomerHistoryOfOrders(customer);
        orderRepository.save(order);
    }


    public Order getOrderById(Integer orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public void updateOrder(OrderRequestObject orderRequestObject) {
        Order order = getOrderById(orderRequestObject.getOrderId());
        order.setCustomerPaidAmount(orderRequestObject.getCustomerPaidAmount());
        order.setCustomerRemainingAmount(orderRequestObject.getCustomerRemainingAmount());
        order.setOrderQuantity(orderRequestObject.getOrderQuantity());
        order.setOrderShippingAddress(orderRequestObject.getOrderShippingAddress());
        order.setUpdatedDate(new Date());
        orderRepository.save(order);
    }
}
