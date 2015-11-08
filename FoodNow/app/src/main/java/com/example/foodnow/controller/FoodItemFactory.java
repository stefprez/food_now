package com.example.foodnow.controller;

import com.example.foodnow.model.Item;
import com.example.foodnow.model.MenuChild;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by narruda on 11/7/15.
 */
public class FoodItemFactory {

    public static Item buildFoodItem(Item randomlyChosenItem) {

        Item itemToAddToOrder = new Item();

        List<MenuChild> childrenToExplore = new ArrayList<MenuChild>();

        List<MenuChild> randomChildrenToAddToOrderItem = itemToAddToOrder.getRandomChildrenToAddToOrderItem();
        childrenToExplore.addAll(randomChildrenToAddToOrderItem);

        MenuChild parent = itemToAddToOrder;
        MenuChild current;
        List<MenuChild> listOfChildrenToCheck;
        while (parent != null) {
            listOfChildrenToCheck = parent.getListOfChildrenToCheck();
            if (listOfChildrenToCheck == null) {
                parent.setListOfChildrenToCheck(parent.getRandomChildrenToAddToOrderItem());
            } else if (listOfChildrenToCheck.isEmpty()) {
                parent = parent.getParent();
            } else {
                current = popFromEndOfList(listOfChildrenToCheck);
                parent.addChild(current);
                parent = current;
            }
        }

        return itemToAddToOrder;
    }

    private static MenuChild popFromEndOfList(List<MenuChild> children) {
        MenuChild lastChild = children.get(children.size() - 1);
        children.remove(lastChild);
        return lastChild;
    }
}
