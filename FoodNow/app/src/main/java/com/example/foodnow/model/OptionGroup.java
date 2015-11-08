package com.example.foodnow.model;

import com.example.foodnow.controller.Randomizer;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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
        List<MenuChild> childrenToAddToOrderItem = new ArrayList<MenuChild>();

        int minSelection = this.getMinSelection();
        int maxSelection = this.getMaxSelection();
        double numberToSelect = Randomizer.getRandomIntInclusive(minSelection, maxSelection);

        int childrenOfThisOptionGroup = this.getChildren().size();

        MenuChild childToAdd;
        for (int i = 0; i < numberToSelect; i++) {
            do {
                childToAdd = this.getChildren().get(Randomizer.getRandomIntInclusive(0, childrenOfThisOptionGroup));
            } while (!childrenToAddToOrderItem.contains(childToAdd));
            childrenToAddToOrderItem.add(childToAdd);
        }

        return childrenToAddToOrderItem;
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
