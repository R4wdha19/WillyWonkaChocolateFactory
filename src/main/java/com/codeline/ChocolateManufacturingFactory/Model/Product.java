package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer productId;
    String productName;
    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    Inventory inventoryProductList;
    Integer productPrice;
    Integer productAvailableQuantity;


}
