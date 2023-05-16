package com.codeline.ChocolateManufacturingFactory.ResponseObject;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Builder
public class CustomerResponseObject {
    Integer customerId;
    String customerName;
    String customerPhoneNumber;
    String customerEmail;
    String customerPaymentMethod;
}
