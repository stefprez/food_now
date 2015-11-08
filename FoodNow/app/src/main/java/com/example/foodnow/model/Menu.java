package com.example.foodnow.model;

import java.util.ArrayList;

public class Menu {

    private String id;
    private String name;
    private ArrayList<MenuChild> children;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<MenuChild> getChildren() {
        return children;
    }
}
