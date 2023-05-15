package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class Ingredient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer ingredientId;
    String ingredientName;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product ingredientsOfProduct;

}
