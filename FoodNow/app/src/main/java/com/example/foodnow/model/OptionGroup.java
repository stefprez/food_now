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
    private MenuChild parent;
    private List<MenuChild> listOfChildrenToCheck;

    public void setEverything(String id, String name, int minSelection, int maxSelection) {
        this.id = id;
        this.name = name;
        this.minSelection = minSelection;
        this.maxSelection = maxSelection;
        this.children = new ArrayList<>();
    }

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
        OptionGroup optionGroup = new OptionGroup();

        optionGroup.id = new String(this.id);
        optionGroup.name = new String(this.name);
        if (this.description == null) {
            optionGroup.description = null;
        } else {
            optionGroup.description = new String(this.description);
        }
        optionGroup.minSelection = this.minSelection;
        optionGroup.maxSelection = this.maxSelection;
        optionGroup.selDep = this.selDep;
        optionGroup.children = new ArrayList<>();
        optionGroup.parent = this.parent;
        optionGroup.listOfChildrenToCheck = new ArrayList<>();

        return optionGroup;
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
