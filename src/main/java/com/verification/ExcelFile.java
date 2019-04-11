package com.verification;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFile {

    public static List<BankAccount> readFromExcel(String filePath) throws IOException {
        Double accountNumber;
        Double balance;
        String currency;
        List<BankAccount> accountList = new ArrayList<>();
        File excelFile = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(excelFile);
        XSSFWorkbook excelBook = new XSSFWorkbook(fileInputStream);
        XSSFSheet myExcelSheet = excelBook.getSheet("Sheet1");

        Iterator<Row> rows = myExcelSheet.iterator();
        if (rows.hasNext()) {
            rows.next();
        }
        while (rows.hasNext()) {
            Row excelRow = rows.next();
            accountNumber = excelRow.getCell(0).getNumericCellValue();
            currency = excelRow.getCell(1).getStringCellValue();
            balance = excelRow.getCell(2).getNumericCellValue();
            BankAccount bankAccount = new BankAccount(balance, accountNumber, currency);
            accountList.add(bankAccount);
        }
        excelBook.close();
        return accountList;
    }
}
