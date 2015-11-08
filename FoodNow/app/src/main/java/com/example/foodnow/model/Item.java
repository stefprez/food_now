package com.example.foodnow.model;

import java.util.ArrayList;

public class Item implements MenuChild {
    private String id;
    private float price;
    private float maxPrice;
    private String name;
    private String description;
    private int minQuantity;
    private int maxQuantity;
    private ArrayList<MenuChild> children;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public ArrayList<MenuChild> getChildren() {
        return children;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }
}
