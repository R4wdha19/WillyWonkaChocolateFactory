package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.InventoryRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import com.codeline.ChocolateManufacturingFactory.RequestObject.ProductRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        product.setAvailableQuantity(productRequestObject.getProductAvailableQuantity());
        product.setPrice(productRequestObject.getProductPrice());
        product.setReorderThreshold(productRequestObject.getProductReorderThreshold());
        product.setInventory(InventoryRequestObject.convert(productRequestObject.getInventoryRequestObject()));
        product.setUpdatedDate(new Date());
        productRepository.save(product);

    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public List<Product> getAllProductsByCreatedDate(String createdDate) {
        return productRepository.getAllProductsByCreatedDate(createdDate);
    }

    public List<Product> getAllInActiveProducts() {
        return productRepository.getAllInActiveProducts();
    }
   public List<Product> getAllActiveProducts() {
        return productRepository.getAllActiveProducts();
    }

    public List<Product> getAllProductsCreatedAfterDate(Date createdDate) {
        return productRepository.getAllProductsCreatedAfterDate(createdDate);
    }

    public void deleteAllProduct() {
        productRepository.deleteAllProduct();
    }

    public void deleteAllProductsCreatedAfterDate(Date createdDate) {
        List<Product> productList= productRepository.deleteAllProductsCreatedAfterDate(createdDate);
        productList.stream().forEach(x-> x.setIsActive(false));
        productRepository.saveAll(productList);
    }
}
