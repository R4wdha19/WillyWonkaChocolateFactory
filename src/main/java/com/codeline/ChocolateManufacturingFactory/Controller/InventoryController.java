package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.RequestObject.InventoryRequestObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.InventoryResponseObject;
import com.codeline.ChocolateManufacturingFactory.ResponseObject.TrackInventoryResponse;
import com.codeline.ChocolateManufacturingFactory.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public List<TrackInventoryResponse> trackInventories() {
        return inventoryService.trackInventoryLevels();
    }

    @RequestMapping(value = "getAllInventories", method = RequestMethod.GET)
    public List<InventoryResponseObject> getAllInventories() {
        return InventoryResponseObject.convertRequestListToResponseList(inventoryService.getAllInventories());
    }

    @RequestMapping(value = "getAllInventoriesByCreatedDate", method = RequestMethod.GET)
    public List<InventoryResponseObject> getAllInventoriesByCreatedDate(@RequestParam String createdDate) {
        return InventoryResponseObject.convertRequestListToResponseList(inventoryService.getAllInventoriesByCreatedDate(createdDate));
    }

    @RequestMapping(value = "getAllInActiveInventories", method = RequestMethod.GET)
    public List<InventoryResponseObject> getAllInActiveInventories() {
        return InventoryResponseObject.convertRequestListToResponseList(inventoryService.getAllInActiveInventories());
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public InventoryResponseObject getLatestRow() {
        return InventoryResponseObject.convertRequestToResponse(inventoryService.getLatestRow());
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public InventoryResponseObject getLatestUpdated() {
        return InventoryResponseObject.convertRequestToResponse(inventoryService.getLatestUpdated());
    }

    @RequestMapping(value = "getAllInventoriesByCreatedDate", method = RequestMethod.GET)
    public List<InventoryResponseObject> getAllInventoriesCreatedAfterDate(@RequestParam Date createdDate) {
        return InventoryResponseObject.convertRequestListToResponseList(inventoryService.getAllInventoriesCreatedAfterDate(createdDate));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllInventories", method = RequestMethod.POST)
    public void deleteAllInventories() {
        inventoryService.deleteAllInventories();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteAllInventoriesCreatedAfterDate", method = RequestMethod.POST)
    public void deleteAllInventoriesCreatedAfterDate(@RequestParam Date createdDate) {
        inventoryService.deleteAllInventoriesCreatedAfterDate(createdDate);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "updateInventory", method = RequestMethod.POST)
    public void updateInventory(@RequestBody InventoryRequestObject inventoryRequestObject) {
        inventoryService.updateInventory(inventoryRequestObject);
    }
}
