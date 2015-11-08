package com.example.foodnow.model;

import java.util.ArrayList;

public class Merchant {
    private String id;
    private String name;
    private Location location;
    private String phone;
    private ArrayList<String> cuisines;
    private int rating;
    private MerchantType type;

    public Merchant(String id, String name, Location location, String phone, ArrayList<String> cuisines, int rating, MerchantType type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.cuisines = cuisines;
        this.rating = rating;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<String> getCuisines() {
        return cuisines;
    }

    public int getRating() {
        return rating;
    }

    public MerchantType getType() {
        return type;
    }
}
