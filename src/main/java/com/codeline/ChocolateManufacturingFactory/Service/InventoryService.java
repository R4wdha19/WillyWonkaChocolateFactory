package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Repository.InventoryRepository;
import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public void createInventory(InventoryRequestObject inventoryRequestObject) {
        Inventory inventory = InventoryRequestObject.convert(inventoryRequestObject);
        inventoryRepository.save(inventory);
    }
}
