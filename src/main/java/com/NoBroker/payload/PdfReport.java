package com.NoBroker.payload;

import com.NoBroker.entity.User;
import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.util.List;
public class PdfReport {

    public static void generatePdfReport(List<User> userList, String pdfFilePath) throws IOException, java.io.IOException {
        PdfWriter pdfWriter = new PdfWriter(pdfFilePath);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        document.add(new Paragraph("User Report"));

        // Create a table for user data
        Table table = new Table(5);
        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Email");
        table.addCell("Mobile");
        table.addCell("Email Verified");

        for (User user : userList) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getName());
            table.addCell(user.getEmail());
            table.addCell(user.getMobile());
            table.addCell(String.valueOf(user.isEmailVerified()));
        }

        document.add(table);

        document.close();
    }
}

