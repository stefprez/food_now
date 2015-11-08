package com.example.foodnow.model;

import java.util.ArrayList;

public class Item implements MenuChild{
    private String id;
    private float price;
    private String name;
    private ArrayList<MenuChild> children;

    public Item(float price, String name) {
        this.price = price;
        this.name = name;
    }

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
}
