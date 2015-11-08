package com.example.foodnow.model;

public class Customer {

    private String address;
    private String creditCardNumber;

    public Customer(String address, String creditCardNumber) {
        this.address = address;
        this.creditCardNumber = creditCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}
