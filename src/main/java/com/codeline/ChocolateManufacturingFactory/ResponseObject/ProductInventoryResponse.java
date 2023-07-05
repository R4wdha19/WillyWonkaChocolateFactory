package com.codeline.ChocolateManufacturingFactory.ResponseObject;

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
public class ProductInventoryResponse {
    String name;
    Integer currentQuantity;


    public static ProductInventoryResponse convertRequestToResponse(Product requestFromUser) {
        return ProductInventoryResponse.builder()
                .name(requestFromUser.getProductName())
                .currentQuantity(requestFromUser.getAvailableQuantity())
                .build();

    }

    public static List<ProductInventoryResponse> convertListOfRequestsToResponses(List<Product> requestFromUser) {
        List<ProductInventoryResponse> productList = new ArrayList<>();
        if (!requestFromUser.isEmpty()) {
            for (Product userRequest : requestFromUser) {
                productList.add(convertRequestToResponse(userRequest));
            }
        }
        return productList;
    }
}
