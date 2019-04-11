package com.verification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processing {

    static List<Balance> process(String excelFile, String csvFile) throws IOException {
        List<BankAccount> csvList = CSVFile.readCSVFile(csvFile);
        List<BankAccount> excelList = ExcelFile.readFromExcel(excelFile);
        List<Balance> invalidAccounts = new ArrayList<>();

        for (int i = 0; i < excelList.size(); i++) {
            BankAccount account = excelList.get(i);
            Double accountNo = account.getAccountNumber();
            Double bankValue = excelList.stream()
                    .filter(v -> v.getAccountNumber().equals(accountNo))
                    .map(v -> v.getBalance())
                    .mapToDouble(Double::doubleValue).sum();

            Double retailValue = csvList.stream()
                    .filter(v -> v.getAccountNumber().equals(accountNo))
                    .map(v -> v.getBalance())
                    .mapToDouble(Double::doubleValue).sum();

            Double balanceCheck = bankValue + retailValue;
            String currency = account.getCurrency();

            if (balanceCheck != 0) {
                Balance balance = new Balance(accountNo, bankValue, retailValue, balanceCheck, currency);
                invalidAccounts.add(balance);
                excelList.removeIf(v -> v.getAccountNumber().equals(accountNo));
            }
        }
        return invalidAccounts;
    }
}