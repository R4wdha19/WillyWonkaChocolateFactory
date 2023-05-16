package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Builder
public class ProductResponseObject {
    Integer id;
    String name;
    Inventory productList;
    Integer price;
    Integer quantity;
    Integer reorderThreshold;
}
