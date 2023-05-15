package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Data
@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer customerId;
    String customerName;
    String customerPhoneNumber;
    String customerEmail;
    String customerPaymentMethod;
    List<String> customerOrders;

}
