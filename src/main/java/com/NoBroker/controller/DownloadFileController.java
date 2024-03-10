package com.NoBroker.controller;

import com.NoBroker.Service.UserService;
import com.NoBroker.entity.User;
import com.NoBroker.payload.ExcelExporter;
import com.NoBroker.payload.PdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;



@RestController
@RequestMapping("/api")
public class DownloadFileController {

    @Autowired
    private UserService userService;

    @GetMapping("/export-to-excel")
    public String exportToExcel() {
        List<User> userList = userService.getAllUsers();

        try {
            ExcelExporter.exportToExcel(userList, "D://Doc//users.xlsx");
            return "Data exported to Excel successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error exporting data to Excel";
        }
    }


    @GetMapping("/generate-pdf-report")
    public String generatePdfReport() {
        List<User> userList = userService.getAllUsers();

        try {
            PdfReport.generatePdfReport(userList, "D://Doc//user_report.pdf");
            return "PDF report generated successfully!";
        } catch (com.itextpdf.io.IOException | java.io.IOException e) {
            e.printStackTrace();
            return "Error generating PDF report";
        }
    }
}
