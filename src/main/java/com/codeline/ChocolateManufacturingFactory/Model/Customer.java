package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer customerId;
    String customerName;
    String customerPhoneNumber;
    String customerEmail;
    String customerPaymentMethod;

}
