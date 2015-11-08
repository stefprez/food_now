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
    private MenuChild parent;
    private List<MenuChild> listOfChildrenToCheck;

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
    public MenuChild getParent() {
        return this.parent;
    }

    @Override
    public void setParent(MenuChild parent) {
        this.parent = parent;
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
        this.children.addAll(children);
    }

    @Override
    public List<MenuChild> getRandomChildrenToAddToOrderItem() {
        return new ArrayList<MenuChild>();
    }

    @Override
    public void addChild(MenuChild child) {
        this.children.add(child);
    }

    @Override
    public List<MenuChild> getListOfChildrenToCheck() {
        return this.listOfChildrenToCheck;
    }

    @Override
    public void setListOfChildrenToCheck(List<MenuChild> listOfChildrenToCheck) {
        this.listOfChildrenToCheck = listOfChildrenToCheck;
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
