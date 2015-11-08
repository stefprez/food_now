package com.example.foodnow.model;

public class Order {
    private String id;
    private Customer customer;
    private Merchant merchant;
    private Item item;
    private float total;
    private int estimatedTime;

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public Item getItem() {
        return item;
    }

    public float getTotal() {
        return total;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }
}
