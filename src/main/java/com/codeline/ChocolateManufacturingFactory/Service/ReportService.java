package com.codeline.ChocolateManufacturingFactory.Service;

import com.codeline.ChocolateManufacturingFactory.DTO.ProductInventoryDTO;
import com.codeline.ChocolateManufacturingFactory.Model.Inventory;
import com.codeline.ChocolateManufacturingFactory.Model.Product;
import com.codeline.ChocolateManufacturingFactory.Repository.InventoryRepository;
import com.codeline.ChocolateManufacturingFactory.Repository.ProductRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    InventoryService inventoryService;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    ProductRepository productRepository;
    public static final String pathToReports = "C:\\Users\\user013\\OneDrive\\Desktop\\Rawdha\\WillyWonka\\WillyWonkaChocolateFactory\\Reports";

    public String generateAReport(String jasperReportName, String fileName, JRBeanCollectionDataSource dataSource) throws Exception {
        File file = new File("C:\\Users\\user013\\OneDrive\\Desktop\\Rawdha\\WillyWonka\\WillyWonkaChocolateFactory\\src\\main\\resources\\" + jasperReportName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "RawdhaSaid");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\" + fileName + ".pdf");
        return "Report generated : " + pathToReports + "\\" + fileName + ".pdf";
    }

    public String inventoryManagementReport() throws Exception {
        List<Inventory> allInventories = inventoryRepository.getAllActiveInventories();
        List<ProductInventoryDTO> productInventoryDTOS = new ArrayList<>();
        for (Inventory inventory : allInventories) {
            List<Product> allProductsByInventoryId = productRepository.allProductsByInventoryId(inventory.getId());
            for (Product product : allProductsByInventoryId) {
                ProductInventoryDTO productInventoryDTO = new ProductInventoryDTO();
                productInventoryDTO.setInventoryLocation(inventory.getLocation());
                productInventoryDTO.setProductName(product.getProductName());
                productInventoryDTO.setProductAvailableQuantity(product.getAvailableQuantity());
                productInventoryDTO.setProductReorderThreshold(product.getReorderThreshold());
                productInventoryDTOS.add(productInventoryDTO);

            }
        }
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productInventoryDTOS);
        return generateAReport("InventoryAndProductReport", "InventoryAndProduct", dataSource);
    }
}
