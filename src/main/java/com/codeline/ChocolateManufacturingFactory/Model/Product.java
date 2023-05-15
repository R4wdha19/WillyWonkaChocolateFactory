package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer productId;
    String productName;
    List<String> productIngredients;
    Integer productPrice;
    Integer productAvailableQuantity;


}
