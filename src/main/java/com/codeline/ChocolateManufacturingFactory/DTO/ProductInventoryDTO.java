package com.codeline.ChocolateManufacturingFactory.DTO;

import com.codeline.ChocolateManufacturingFactory.Model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ProductInventoryDTO {
    String inventoryLocation;

    Product product;
    String productName;

    Integer productAvailableQuantity;

    Integer productReorderThreshold;
}
