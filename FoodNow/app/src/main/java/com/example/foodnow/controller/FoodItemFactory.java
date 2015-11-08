package com.example.foodnow.controller;

import com.example.foodnow.model.Item;
import com.example.foodnow.model.MenuChild;

import java.util.List;

/**
 * Created by narruda on 11/7/15.
 */
public class FoodItemFactory {

    public static Item buildFoodItem(Item randomlyChosenItem) {

        Item itemToAddToOrder = new Item();

        // TODO: this, but recursively
        List<MenuChild> randomChildrenToAddToOrderItem = randomlyChosenItem.getRandomChildrenToAddToOrderItem();
        itemToAddToOrder.addChildren(randomChildrenToAddToOrderItem);

        for (MenuChild child: randomChildrenToAddToOrderItem) {
            List<MenuChild> childrenToAdd = child.getRandomChildrenToAddToOrderItem();
            itemToAddToOrder.addChildren(childrenToAdd);

            for (MenuChild nextChild: childrenToAdd) {
                //...
            }
        }

        return randomlyChosenItem;
    }
}
