package com.example.foodnow.model;

import java.util.ArrayList;
import java.util.List;

public class OptionGroup implements MenuChild {
    private String id;
    private String name;
    private String description;
    private int minSelection;
    private int maxSelection;
    private boolean selDep;
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
        OptionGroup optionGroupFromMenu = new OptionGroup();
        List<MenuChild> childrenToAddToOrderItem = new ArrayList<MenuChild>();

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
