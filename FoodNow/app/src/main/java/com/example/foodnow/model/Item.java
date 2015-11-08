package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item implements MenuChild {
    @SerializedName("id") private String id;
    @SerializedName("price") private float price;
    @SerializedName("max_price") private float maxPrice;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("min_qty") private int minQuantity;
    @SerializedName("max_qty") private int maxQuantity;
    @SerializedName("children") private ArrayList<MenuChild> children;

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
