package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Item implements MenuChild {

    @SerializedName("id") private String id;
    @SerializedName("price") private float price;
    @SerializedName("max_price") private float maxPrice;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("min_qty") private int minQuantity;
    @SerializedName("max_qty") private int maxQuantity;
    @SerializedName("children") private ArrayList<MenuChild> children;
    private MenuChild parent;
    private List<MenuChild> listOfChildrenToCheck;

    public void setEverything(String id, String name) {
        this.id = id;
        this.name = name;
        this.children = new ArrayList<MenuChild>();
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
    public List<MenuChild> getChildren() {
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
        Item item = new Item();
        item.id = new String (this.id);
        item.name = new String(this.name);
        item.maxPrice = this.maxPrice;
        item.price = this.price;
        item.description = new String(this.description);
        item.minQuantity = this.minQuantity;
        item.maxQuantity = this.maxQuantity;
        item.children = new ArrayList<>();
        item.parent = this.parent;
        item.listOfChildrenToCheck = new ArrayList<>();

        return item;
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
