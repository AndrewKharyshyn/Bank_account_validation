package com.verification;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //        System.err.close();
//        System.setErr(System.out);
        String csvFilePath = "C:\\Users\\Andrew\\Downloads\\RPA\\RPA\\DMS_RPA_Challenge\\торговая сеть сент 2017.csv";
        String excelFilePath = "C:\\Users\\Andrew\\Downloads\\RPA\\RPA\\DMS_RPA_Challenge\\Банк выгрузка 2017 Сент.xlsx";
        WriteTable.writeIntoExcel(excelFilePath, csvFilePath);
    }
}
