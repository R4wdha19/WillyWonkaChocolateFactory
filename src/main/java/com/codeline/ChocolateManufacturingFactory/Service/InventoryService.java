package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.InventoryRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.ProductInventoryResponse;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.TrackInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
            List<Product> allProductsByInventoryId = productRepository.allProductsByInventoryId(inventory.getId());
            List<ProductInventoryResponse> allProductsByInventoryIdResponse = ProductInventoryResponse.convertListOfRequestsToResponses(allProductsByInventoryId);
            TrackInventoryResponse inventoryResponse = new TrackInventoryResponse();
            inventoryResponse.setInventoryLocation(inventory.getLocation());
            inventoryResponse.setProductList(allProductsByInventoryIdResponse);
            trackInventoryResponses.add(inventoryResponse);

        }
        return trackInventoryResponses;
//        if(trackInventoryResponses.contains())
    }

    public Inventory getInventoryById(Integer inventoryId) {
        return inventoryRepository.getInventoryById(inventoryId);
    }

    public void updateInventory(InventoryRequestObject inventoryRequestObject) {
        Inventory inventory = getInventoryById(inventoryRequestObject.getInventoryId());
        inventory.setManagedBy(inventoryRequestObject.getInventoryManagedBy());
        inventory.setLocation(inventoryRequestObject.getInventoryLocation());
        inventory.setUpdatedDate(new Date());
        inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.getAllInventories();
    }

    public List<Inventory> getAllInventoriesByCreatedDate(String createdDate) {
        return inventoryRepository.getAllInventoriesByCreatedDate(createdDate);
    }

    public List<Inventory> getAllInActiveInventories() {
        return inventoryRepository.getAllInActiveInventories();
    }

    public Inventory getLatestRow() {
        return inventoryRepository.getLatestRow();
    }

    public Inventory getLatestUpdated() {
        return inventoryRepository.getLatestUpdated();
    }

    public List<Inventory> getAllInventoriesCreatedAfterDate(Date createdDate) {
        return inventoryRepository.getAllInventoriesCreatedAfterDate(createdDate);
    }

    public void deleteAllInventories() {
        inventoryRepository.deleteAllInventory();
    }

    public void deleteAllInventoriesCreatedAfterDate(Date createdDate) {
        List<Inventory> inventoryList = inventoryRepository.deleteAllInventoriesCreatedAfterDate(createdDate);
        inventoryList.stream().forEach(x -> x.setIsActive(false));
        inventoryRepository.saveAll(inventoryList);
    }
}
