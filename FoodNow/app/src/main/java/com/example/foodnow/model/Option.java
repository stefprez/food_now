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
        for (MenuChild child: children) {
            child.setParent(this);
        }
        this.children.addAll(children);
    }

    @Override
    public List<MenuChild> getRandomChildrenToAddToOrderItem() {
        return new ArrayList<MenuChild>();
    }

    @Override
    public void addChild(MenuChild child) {
        child.setParent(this);
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

    @Override
    public MenuChild getCopy() {
        Option option = new Option();

        option.id = new String(this.name);
        option.price = this.price;
        option.maxPrice = this.maxPrice;
        option.name = new String(this.name);
        option.description = new String(this.description);
        option.increment = this.increment;
        option.children = new ArrayList<>();
        option.parent = this.parent;
        option.listOfChildrenToCheck = null;

        return option;
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
