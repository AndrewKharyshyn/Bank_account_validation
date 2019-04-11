package com.verification;

public class Balance {
    private Double accountNo;
    private Double bankSum;
    private Double retailSum;
    private Double difference;
    private String currency;

    public Balance(Double accountNo, Double bankSum, Double retailSum, Double difference, String currency) {
        this.accountNo = accountNo;
        this.bankSum = bankSum;
        this.retailSum = retailSum;
        this.difference = difference;
        this.currency = currency;
    }

    public Double getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Double accountNo) {
        this.accountNo = accountNo;
    }

    public Double getBankSum() {
        return bankSum;
    }

    public void setBankSum(Double bankSum) {
        this.bankSum = bankSum;
    }

    public Double getRetailSum() {
        return retailSum;
    }

    public void setRetailSum(Double retailSum) {
        this.retailSum = retailSum;
    }

    public Double getDifference() {
        return difference;
    }

    public void setDifference(Double difference) {
        this.difference = difference;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "accountNo=" + accountNo +
                ", bankSum=" + bankSum +
                ", retailSum=" + retailSum +
                ", difference=" + difference +
                ", currency='" + currency + '\'' +
                '}';
    }
}
