package com.codeline.ChocolateManufacturingFactory.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class CustomerOrderDTO {
    Integer customerName;
    Integer orderId;
    Integer productName;
    String orderShippingAddress;
    Integer orderQuantity;

}
