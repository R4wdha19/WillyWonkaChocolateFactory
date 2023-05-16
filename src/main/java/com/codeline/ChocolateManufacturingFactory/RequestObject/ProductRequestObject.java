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
    Integer productPrice;
    Integer productAvailableQuantity;
    Integer productReorderThreshold;
    public static Product convert(ProductRequestObject request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductPrice(request.getProductPrice());
        product.setProductAvailableQuantity(request.getProductAvailableQuantity());
        product.setProductReorderThreshold(request.getProductReorderThreshold());
        product.setIsActive(true);
        product.setCreatedDate(new Date());
        product.setInventoryProductList(InventoryRequestObject.convert(request.getInventoryRequestObject()));
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
