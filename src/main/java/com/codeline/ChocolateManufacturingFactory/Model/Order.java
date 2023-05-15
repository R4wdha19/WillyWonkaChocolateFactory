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
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer orderId;
    String orderShippingAddress;
    Integer orderQuantity;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customerHistoryOfOrders;
}
