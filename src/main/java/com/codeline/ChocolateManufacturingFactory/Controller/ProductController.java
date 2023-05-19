package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.ProductRequestObject;
import com.codeline.ChocolateManufacturingFactory.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "createProduct", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductRequestObject productRequestObject) {
        productService.createProduct(productRequestObject);
    }
}
