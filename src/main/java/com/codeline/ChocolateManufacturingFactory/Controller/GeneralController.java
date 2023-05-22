package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Report")
public class GeneralController {
    @Autowired
    ReportService reportService;
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "GenerateInventoryReport", method = RequestMethod.GET)
    public String GenerateInventoryReport() throws Exception {
        reportService.inventoryManagementReport();
        return "Created Successfully";
    }

}
