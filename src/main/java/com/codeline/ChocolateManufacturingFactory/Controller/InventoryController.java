package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.ProductInventoryResponse;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.TrackInventoryResponse;
import com.codeline.ChocolateManufacturingFactory.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "createInventory", method = RequestMethod.POST)
    public void createInventory(@RequestBody InventoryRequestObject inventoryRequestObject) {
        inventoryService.createInventory(inventoryRequestObject);
    }
    @RequestMapping(value = "trackInventories", method = RequestMethod.GET)
    public List<TrackInventoryResponse> trackInventories(){
        return inventoryService.trackInventoryLevels();
    }
}
