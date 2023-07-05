package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Builder
public class InventoryResponseObject {
    Integer id;
    String location;
    String managedBy;

    public static InventoryResponseObject convertRequestToResponse(Inventory inventoryRequestFromUser) {
        return InventoryResponseObject.builder()
                .id(inventoryRequestFromUser.getId())
                .location(inventoryRequestFromUser.getLocation())
                .managedBy(inventoryRequestFromUser.getManagedBy())
                .build();
    }

    public static List<InventoryResponseObject> convertRequestListToResponseList(List<Inventory> inventoryRequestFromUser) {
        List<InventoryResponseObject> inventories = new ArrayList<>();
        if (!inventoryRequestFromUser.isEmpty()) {
            for (Inventory inventoryRequest : inventoryRequestFromUser) {
                inventories.add(convertRequestToResponse(inventoryRequest));
            }
        }
        return inventories;
    }

}
