package com.codeline.ChocolateManufacturingFactory.Controller;

import com.codeline.ChocolateManufacturingFactory.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Report")
public class GeneralController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "GenerateInventoryReport", method = RequestMethod.GET)
    public String GenerateInventoryReport() throws Exception {
        reportService.inventoryManagementReport();
        return "Created Successfully";
    }

}
