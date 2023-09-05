package com.codeup.rentlister.controllers;

class Payment {
    private double amount;
    private String date;
    private String type;

    public Payment(double amount, String date, String type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}

