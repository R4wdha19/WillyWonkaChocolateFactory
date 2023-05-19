package com.codeline.ChocolateManufacturingFactory.RequestObject;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Data
public class InventoryRequestObject {
    Integer inventoryId;
    String inventoryLocation;
    String inventoryManagedBy;


    public static Inventory convert(InventoryRequestObject request) {
        Inventory inventory = new Inventory();
        inventory.setInventoryLocation(request.getInventoryLocation());
        inventory.setInventoryManagedBy(request.getInventoryManagedBy());
        inventory.setIsActive(true);
        inventory.setCreatedDate(new Date());
        return inventory;
    }

    public static List<Inventory> convert(List<InventoryRequestObject> requestList) {
        List<Inventory> inventories = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (InventoryRequestObject inventoryRequest : requestList) {
                inventories.add(convert(inventoryRequest));
            }
        }
        return inventories;


    }


}
