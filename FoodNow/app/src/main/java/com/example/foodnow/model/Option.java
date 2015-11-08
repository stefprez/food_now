package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Option implements MenuChild {
    @SerializedName("id")
    private String id;

    @SerializedName("price")
    private float price;

    @SerializedName("max_price")
    private float maxPrice;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("increment")
    private float increment;

    @SerializedName("children")
    private ArrayList<MenuChild> children;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ArrayList<MenuChild> getChildren() {
        return children;
    }

    @Override
    public boolean hasChildren() {
        return !(this.children.isEmpty());
    }

    @Override
    public void addChildren(List<MenuChild> children) {
        this.children = new ArrayList<MenuChild>(children);
    }

    @Override
    public List<MenuChild> getRandomChildrenToAddToOrderItem() {
        return new ArrayList<MenuChild>();
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public float getIncrement() {
        return increment;
    }

    public float getPrice() {
        return price;
    }
}
