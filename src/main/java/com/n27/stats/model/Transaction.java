package com.n27.stats.model;

public class Transaction {

    public Transaction() {
    }

    public Transaction(double amount, long timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    private double amount;

    private long timestamp;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }

}
