package com.codeline.ChocolateManufacturingFactory.RequestObject;

import com.codeline.ChocolateManufacturingFactory.Model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class ProductRequestObject {
    Integer productId;
    String productName;
    InventoryRequestObject inventoryRequestObject;
    Double productPrice;
    Integer productAvailableQuantity;
    Integer totalQuantityOfTheProduct;
    Integer productReorderThreshold;
    public static Product convert(ProductRequestObject request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setPrice(request.getProductPrice());
        product.setAvailableQuantity(request.getProductAvailableQuantity());
        product.setReorderThreshold(request.getProductReorderThreshold());
        product.setTotalQuantity(request.getTotalQuantityOfTheProduct());
        product.setIsActive(true);
        product.setCreatedDate(new Date());
        return product;
    }

    public static List<Product> convert(List<ProductRequestObject> requestList) {
        List<Product> productList = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (ProductRequestObject productRequest : requestList) {
                productList.add(convert(productRequest));
            }
        }
        return productList;


    }

}
