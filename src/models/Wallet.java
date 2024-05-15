package models;

import exceptions.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Wallet {
    private UUID id;
    private double balance;
    private String username;
    private List<Transaction> transactions = new ArrayList<>();
    public Wallet(String username, double balance) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addAmount(double amount) {
        this.balance += amount;
    }

    public void withdrawAmount(double amount) throws InsufficientFundsException {
        if (this.balance - amount < 0) {
            throw new InsufficientFundsException();
        } else {
            this.balance -= amount;
        }
    }
}
