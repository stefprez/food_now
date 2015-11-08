package com.example.foodnow.model;

import java.util.ArrayList;
import java.util.List;

public interface MenuChild {
    public String getId();

    public String getName();

    public String getDescription();

    public MenuChild getParent();

    public void setParent(MenuChild parent);

    public List<MenuChild> getChildren();

    public boolean hasChildren();

    public void addChildren(List<MenuChild> children);

    public List<MenuChild> getRandomChildrenToAddToOrderItem();

    void addChild(MenuChild child);

    public List<MenuChild> getListOfChildrenToCheck();

    public void setListOfChildrenToCheck(List<MenuChild> listOfChildrenToCheck);

    public MenuChild getCopy();
}
