package com.verification;

public class BankAccount {
    private Double balance;
    private Double accountNumber;
    private String currency;

    public BankAccount(Double balance, Double accountNumber, String currency) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount account = (BankAccount) o;

        if (!balance.equals(account.balance)) return false;
        if (!accountNumber.equals(account.accountNumber)) return false;
        return currency.equals(account.currency);
    }

    @Override
    public int hashCode() {
        int result = balance.hashCode();
        result = 31 * result + accountNumber.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance='" + balance + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
