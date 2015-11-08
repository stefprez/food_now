package com.example.foodnow.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OptionGroup implements MenuChild {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("min_selection")
    private int minSelection;

    @SerializedName("max_selection")
    private int maxSelection;

    @SerializedName("sel_dep")
    private boolean selDep;

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

    public int getMaxSelection() {
        return maxSelection;
    }

    public int getMinSelection() {
        return minSelection;
    }

    public boolean isSelDep() {
        return selDep;
    }
}
