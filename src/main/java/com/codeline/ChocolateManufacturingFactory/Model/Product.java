package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "product_name")
    String name;
    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    Inventory inventory;
    @Column(name = "product_price")
    Double price;
    @Column(name = "product_available_quantity")
    Integer availableQuantity;
    @Column(name = "total_product_quantity")
    Integer totalQuantity;
    @Column(name = "product_reorder_threshold")
    Integer reorderThreshold;

}
