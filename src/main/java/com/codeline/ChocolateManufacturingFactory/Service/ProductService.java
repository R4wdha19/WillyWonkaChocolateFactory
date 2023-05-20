package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.InventoryRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.ProductRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
