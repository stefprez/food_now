package com.example.foodnow.model;

import java.util.ArrayList;
import java.util.List;

public class Item implements MenuChild {
    private String id;
    private float price;
    private float maxPrice;
    private String name;
    private String description;
    private int minQuantity;
    private int maxQuantity;
    private List<MenuChild> children;

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
    public List<MenuChild> getChildren() {
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
