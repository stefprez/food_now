package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Menu {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("children")
    private ArrayList<MenuChild> children;

    @SerializedName("description")
    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<MenuChild> getChildren() {
        return children;
    }

    public String getDescription() {
        return description;
    }
}
