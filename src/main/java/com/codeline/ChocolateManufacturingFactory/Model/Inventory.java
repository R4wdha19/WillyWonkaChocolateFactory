package com.codeline.ChocolateManufacturingFactory.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class Inventory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer inventoryId;
    String inventoryLocation;
    String inventoryManagedBy;



}
