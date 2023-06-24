package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // name of the column won't affect the generating of the PK
    Integer id; // to solve the issue of the Redundant and to keep the security of our database
    // we force the column name using @column annotation
    @Column(name = "customer_name")
    String name;
    @Column(name = "customer_phone_number")
    String phoneNumber;
    @Column(name = "customer_email")
    String email;
    @Column(name = "customer_payment_method")
    String paymentMethod;

    // Repeating initials means repeating code therefor we are not supposed to do that

}
