package com.verification;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteTable {
    public static void writeIntoExcel(String excelFile, String csvFile) throws IOException {

        List<Balance> invalidAccounts = Processing.process(excelFile, csvFile);

        FileInputStream fileInputStream = new FileInputStream(excelFile);
        XSSFWorkbook excelBook = new XSSFWorkbook(fileInputStream);
        XSSFSheet excelSheet = excelBook.createSheet("Results");

        Row row = excelSheet.createRow(0);

        Cell accountNoCol = row.createCell(0);
        Cell sum1Col = row.createCell(1);
        Cell sum2Col = row.createCell(2);
        Cell differenceCol = row.createCell(3);
        Cell currencyCol = row.createCell(4);
        accountNoCol.setCellValue("Номер рахунку");
        sum1Col.setCellValue("Сума (За банком)");
        sum2Col.setCellValue("Сума (За мережею)");
        differenceCol.setCellValue("Відхилення");
        currencyCol.setCellValue("Валюта");

        int rowIndex = 1;
        for (int i = 0; i < invalidAccounts.size(); i++) {
            Row dataRow = excelSheet.createRow(rowIndex);

            Cell accountNo = dataRow.createCell(0);
            Cell sum1 = dataRow.createCell(1);
            Cell sum2 = dataRow.createCell(2);
            Cell difference = dataRow.createCell(3);
            Cell currency = dataRow.createCell(4);

            Double accNoStr = invalidAccounts.get(i).getAccountNo();
            accountNo.setCellValue(accNoStr);
            sum1.setCellValue(invalidAccounts.get(i).getBankSum());
            sum2.setCellValue(invalidAccounts.get(i).getRetailSum());
            difference.setCellValue(invalidAccounts.get(i).getDifference());
            currency.setCellValue(invalidAccounts.get(i).getCurrency());

            rowIndex = ++rowIndex;
        }

        for (int i = 0; i < 5; i++) {
            excelSheet.autoSizeColumn(i);
        }

        excelBook.write(new FileOutputStream(excelFile));
        excelBook.close();
        System.out.println("Validation report has been created successfully!"
                + "\n" + "Open Excel file for further details.");
    }
}