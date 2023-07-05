package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "Customer_Order")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "order_shipping_address")
    String shippingAddress;
    @Column(name = "order_quantity")
    Integer quantity;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customerHistoryOfOrders;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;
    @Column(name = "customer_paid_amount")
    Double paidAmount;
    @Column(name = "customer_remaining_amount")
    Double remainingAmount;
}
