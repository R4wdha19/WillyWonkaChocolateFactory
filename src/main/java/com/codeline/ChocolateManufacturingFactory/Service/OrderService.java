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

import java.util.Date;
import java.util.List;

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
                getProductById(orderRequestObject.getProduct().getId());
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

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public List<Order> getAllActiveOrders() {
        return orderRepository.getAllActiveOrders();
    }

    public List<Order> getAllInActiveOrders() {
        return orderRepository.getAllInActiveOrders();
    }

    public List<Order> getAllOrdersCreatedAfterDate(Date createdDate) {
        return orderRepository.getAllOrdersCreatedAfterDate(createdDate);
    }

    public void deleteAllOrder() {
        orderRepository.deleteAllOrder();
    }

    public void deleteAllOrdersCreatedAfterDate(Date createdDate) {
        List<Order> orderList = orderRepository.deleteAllOrdersCreatedAfterDate(createdDate);
        orderList.stream().forEach(x -> x.setIsActive(false));
        orderRepository.saveAll(orderList);
    }
}
