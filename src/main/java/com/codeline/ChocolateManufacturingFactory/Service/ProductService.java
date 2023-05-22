package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Order;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.InventoryRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import com.codeline.ChocolateManufacturingFactory.RequestObject.OrderRequestObject;
import com.codeline.ChocolateManufacturingFactory.RequestObject.ProductRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    public void createProduct(ProductRequestObject productRequestObject) {
        Product product = ProductRequestObject.convert(productRequestObject);
        Inventory inventoryById = inventoryRepository
                .getInventoryById(productRequestObject
                        .getInventoryRequestObject().getInventoryId());
        product.setInventory(inventoryById);
        productRepository.save(product);
    }

    public Product getProductById(Integer productId) {
        return productRepository.getProductById(productId);
    }

    public void updateProduct(ProductRequestObject productRequestObject) {
        Product product = getProductById(productRequestObject.getProductId());
        product.setProductName(productRequestObject.getProductName());
        product.setProductAvailableQuantity(productRequestObject.getProductAvailableQuantity());
        product.setProductPrice(productRequestObject.getProductPrice());
        product.setProductReorderThreshold(productRequestObject.getProductReorderThreshold());
        product.setInventory(InventoryRequestObject.convert(productRequestObject.getInventoryRequestObject()));
        product.setUpdatedDate(new Date());
        productRepository.save(product);

    }
}
