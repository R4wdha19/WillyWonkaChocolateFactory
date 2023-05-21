package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Data
public class TrackInventoryResponse {
   String inventoryLocation;
   List<ProductResponseObject> productList;
}
