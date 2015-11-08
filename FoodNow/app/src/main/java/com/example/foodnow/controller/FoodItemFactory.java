package com.example.foodnow.controller;

import android.util.Log;

import com.example.foodnow.model.Item;
import com.example.foodnow.model.MenuChild;
import com.example.foodnow.model.Option;
import com.example.foodnow.model.OptionGroup;

import java.util.ArrayList;
import java.util.List;

public class FoodItemFactory {

//    public static void main(String[] args) {
//        Item pizza = new Item();
//        pizza.setEverything("1", "Pizza");
//
//        OptionGroup toppings = new OptionGroup();
//        toppings.setEverything("2", "Toppings", 1, 1);
//
//        toppings.addChild(new Option());
//
//        pizza.addChild(toppings);
//        Item orderedItem = FoodItemFactory.buildFoodItem(pizza);
//
//        System.out.println(orderedItem.getName());
//        System.out.println(orderedItem.getChildren().get(0).getChildren().size());
////        System.out.println(orderedItem.getChildren().get(0).getName());
//
//        System.out.println("MADE ITTTTT");
//        System.exit(0);
//    }

    public static Item buildFoodItem(Item randomlyChosenItem) {
        MenuChild itemToAddToOrder = randomlyChosenItem.getCopy();
        MenuChild parentInMenu = randomlyChosenItem;

        MenuChild parentInOrderItem = itemToAddToOrder;
        MenuChild current;
        List<MenuChild> listOfChildrenToCheck;
        List<MenuChild> childrenToAdd;

//        System.out.println(parentInMenu.getChildren().size());
        while (parentInOrderItem != null) {
            listOfChildrenToCheck = parentInMenu.getListOfChildrenToCheck();
            if (listOfChildrenToCheck == null) {
//                System.out.println("Stage 1");
                childrenToAdd = parentInMenu.getRandomChildrenToAddToOrderItem();
                parentInMenu.setListOfChildrenToCheck(childrenToAdd);
            } else if (listOfChildrenToCheck.isEmpty()) {
//                System.out.println("Stage 2");
                parentInMenu = parentInMenu.getParent();
                parentInOrderItem = parentInOrderItem.getParent();

//                if (parentInMenu != null && parentInOrderItem != null) {
//                    System.out.println("parentInMenu: " + parentInMenu.getId() + " parentInOrderItem: " + parentInOrderItem.getId());
//                } else
//                {
//                    System.out.println("Something was null");
//                }

            } else {
//                System.out.println("Stage 3");
                current = popFromEndOfList(listOfChildrenToCheck);
                current.setParent(parentInMenu);
                parentInMenu = current;
                current = current.getCopy();
                parentInOrderItem.addChild(current);
                parentInOrderItem = current;

//                System.out.println("parentInMenu: " + parentInMenu.getId() + " parentInOrderItem: " + parentInOrderItem.getId());
            }
        }

        return (Item) itemToAddToOrder;
    }

    private static MenuChild popFromEndOfList(List<MenuChild> children) {
        MenuChild lastChild = children.get(children.size() - 1);
        children.remove(lastChild);
        return lastChild;
    }
}
