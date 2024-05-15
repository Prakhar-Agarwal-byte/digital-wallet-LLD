package models;

import java.util.Date;

public class Transaction {
    Date transactionDate;
    Double amount;
    TransactionType transactionType;

    public Transaction(Date transactionDate, Double amount, TransactionType transactionType) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionDate=" + transactionDate +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }
}
