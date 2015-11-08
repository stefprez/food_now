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

        // TODO: Probably borked
        MenuChild itemToAddToOrder = randomlyChosenItem.getCopy(); // give information
        MenuChild parentInMenu = randomlyChosenItem;

        MenuChild parentInOrderItem = itemToAddToOrder;
        MenuChild current;
        List<MenuChild> listOfChildrenToCheck;
        List<MenuChild> childrenToAdd;
        while (parentInOrderItem != null) {
            listOfChildrenToCheck = parentInOrderItem.getListOfChildrenToCheck();
            if (listOfChildrenToCheck == null) {
                childrenToAdd = parentInMenu.getRandomChildrenToAddToOrderItem();
                parentInOrderItem.setListOfChildrenToCheck(childrenToAdd);
            } else if (listOfChildrenToCheck.isEmpty()) {
                parentInMenu = parentInMenu.getParent();
                parentInOrderItem = parentInOrderItem.getParent();
            } else {
                current = popFromEndOfList(listOfChildrenToCheck);
                parentInMenu = current;
                current = current.getCopy();
                parentInOrderItem.addChild(current);
                parentInOrderItem = current;
            }
        }

        return (Item)itemToAddToOrder;
    }

    private static MenuChild popFromEndOfList(List<MenuChild> children) {
        MenuChild lastChild = children.get(children.size() - 1);
        children.remove(lastChild);
        return lastChild;
    }
}
