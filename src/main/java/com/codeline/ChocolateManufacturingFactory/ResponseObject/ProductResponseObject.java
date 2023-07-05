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
    Double price;
    Integer currentQuantity;
    Integer reorderThreshold;
    Integer totalQuantity;

    public static ProductResponseObject convertRequestToResponse(Product requestFromUser) {
        return ProductResponseObject.builder()
                .id(requestFromUser.getId())
                .name(requestFromUser.getProductName())
                .price(requestFromUser.getPrice())
                .currentQuantity(requestFromUser.getAvailableQuantity())
                .reorderThreshold(requestFromUser.getReorderThreshold())
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
