package com.NoBroker.payload;

import com.NoBroker.entity.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public static void exportToExcel(List<User> userList, String excelFilePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("User Data");

        createHeaderRow(sheet);

        int rowNum = 1;

        for (User user : userList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getEmail());
            row.createCell(4).setCellValue(user.getMobile());
            row.createCell(5).setCellValue(user.isEmailVerified());
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }

    private static void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Email");
        headerRow.createCell(4).setCellValue("Mobile");
        headerRow.createCell(5).setCellValue("Email Verified");
    }
}
