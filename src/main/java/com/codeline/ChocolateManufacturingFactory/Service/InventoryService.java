package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.InventoryRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.ProductInventoryResponse;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.ProductResponseObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.TrackInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    ProductRepository productRepository;

    public void createInventory(InventoryRequestObject inventoryRequestObject) {
        Inventory inventory = InventoryRequestObject.convert(inventoryRequestObject);
        inventoryRepository.save(inventory);
    }

    public List<TrackInventoryResponse> trackInventoryLevels() {
      List<TrackInventoryResponse> trackInventoryResponses = new ArrayList<>();
        List<Inventory> allInventories = inventoryRepository.getAllActiveInventories();
        for (Inventory inventory : allInventories) {
            List<Product> allProductsByInventoryId = productRepository.allProductsByInventoryId(inventory.getInventoryId());
            List<ProductInventoryResponse> allProductsByInventoryIdResponse = ProductInventoryResponse.convertListOfRequestsToResponses(allProductsByInventoryId);
            TrackInventoryResponse inventoryResponse = new TrackInventoryResponse();
            inventoryResponse.setInventoryLocation(inventory.getInventoryLocation());
            inventoryResponse.setProductList(allProductsByInventoryIdResponse);
            trackInventoryResponses.add(inventoryResponse);
        }
        return trackInventoryResponses;
//        if(trackInventoryResponses.contains())
    }

}
