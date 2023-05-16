package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Builder
public class ProductResponseObject {
    Integer id;
    String name;
    Inventory inventory;
    Integer price;
    Integer quantity;
    Integer reorderThreshold;

    public static ProductResponseObject convertRequestToResponse(Product requestFromUser) {
        return ProductResponseObject.builder()
                .id(requestFromUser.getProductId())
                .name(requestFromUser.getProductName())
                .price(requestFromUser.getProductPrice())
                .quantity(requestFromUser.getProductAvailableQuantity())
                .reorderThreshold(requestFromUser.getProductReorderThreshold())
                .inventory(requestFromUser.getInventory())
                .build();

    }

    public static List<ProductResponseObject> convertListOfRequestsToResponses(List<Product> requestFromUser) {
        List<ProductResponseObject> productList = new ArrayList<>();
        if (!requestFromUser.isEmpty()) {
            for (Product userRequest : requestFromUser) {
                productList.add(convertRequestToResponse(userRequest));
            }
        }
        return productList;
    }
}
