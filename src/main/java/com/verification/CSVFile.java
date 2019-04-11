package com.verification;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    public static List<BankAccount> readCSVFile(String filePath) throws IOException {
        List<BankAccount> accounts = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(filePath));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ) {
            for (CSVRecord csvRecord : csvParser) {
                Double balance = Double.parseDouble(csvRecord.get(0));
                Double accountNumber = Double.parseDouble(csvRecord.get(1));
                String currency = csvRecord.get(2);
                BankAccount bankAccount = new BankAccount(balance, accountNumber, currency);
                accounts.add(bankAccount);
            }
        }
        return accounts;
    }
}


