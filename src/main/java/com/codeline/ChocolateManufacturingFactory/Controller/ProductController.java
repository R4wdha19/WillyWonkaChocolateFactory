package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.ProductRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.ProductResponseObject;
import com.codeline.ChocolateManufacturingFactory.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "createProduct", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductRequestObject productRequestObject) {
        productService.createProduct(productRequestObject);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "updateProduct", method = RequestMethod.POST)
    public void updateProduct(@RequestBody ProductRequestObject productRequestObject) {
        productService.updateProduct(productRequestObject);
    }

    @RequestMapping(value = "getAllProducts", method = RequestMethod.GET)
    public List<ProductResponseObject> getAllProducts() {
        return ProductResponseObject.convertListOfRequestsToResponses(productService.getAllProducts());
    }

    @RequestMapping(value = "getAllProductsByCreatedDate", method = RequestMethod.GET)
    public List<ProductResponseObject> getAllProductsByCreatedDate(@RequestParam String createdDate) {
        return ProductResponseObject.convertListOfRequestsToResponses(productService.getAllProductsByCreatedDate(createdDate));
    }

    @RequestMapping(value = "getAllInActiveProducts", method = RequestMethod.GET)
    public List<ProductResponseObject> getAllInActiveProducts() {
        return ProductResponseObject.convertListOfRequestsToResponses(productService.getAllInActiveProducts());
    }
    @RequestMapping(value = "getAllActiveProducts", method = RequestMethod.GET)
    public List<ProductResponseObject> getAllActiveProducts() {
        return ProductResponseObject.convertListOfRequestsToResponses(productService.getAllActiveProducts()) ;
    }
    @RequestMapping(value = "getAllProductsCreatedAfterDate", method = RequestMethod.GET)
    public List<ProductResponseObject> getAllProductsCreatedAfterDate(@RequestParam Date createdDate) {
        return ProductResponseObject.convertListOfRequestsToResponses(productService.getAllProductsCreatedAfterDate(createdDate)) ;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllProduct", method = RequestMethod.POST)
    public void deleteAllProduct() {
        productService.deleteAllProduct();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllProductsCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllProductsCreatedAfterDate(@RequestParam Date createdDate) {
        productService.deleteAllProductsCreatedAfterDate(createdDate);
    }
}
