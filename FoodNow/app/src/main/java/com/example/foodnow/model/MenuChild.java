package com.example.foodnow.model;

import java.util.ArrayList;
import java.util.List;

public interface MenuChild {
    public String getId();

    public String getName();

    public String getDescription();

    public List<MenuChild> getChildren();

    public boolean hasChildren();

    public void addChildren(List<MenuChild> children);

    public List<MenuChild> getRandomChildrenToAddToOrderItem();
}
