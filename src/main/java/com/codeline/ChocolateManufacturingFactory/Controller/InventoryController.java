package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import com.codeline.ChocolateManufacturingFactory.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "createInventory", method = RequestMethod.POST)
    public void createInventory(@RequestBody InventoryRequestObject inventoryRequestObject) {
        inventoryService.createInventory(inventoryRequestObject);
    }
}
