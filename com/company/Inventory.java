package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// inventoryclasses - Holds the player's items

import com.company.inventoryclasses.InventoryItem;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<InventoryItem> inventory;
    private int numberItems;

    public Inventory() {
        inventory = new ArrayList<InventoryItem>(10);
        numberItems = 0;
    }

    public void addToInventory(InventoryItem item) {
        inventory.add(item);
        numberItems++;
    }

    public InventoryItem getItem(int index) {
        return inventory.get(index);
    }

    public String toString() {
        String answer = "You have " + numberItems + " items. You have…";
        for (int i = 0; i < numberItems; i++)
            answer += "\n" + inventory.get(i);
        return answer;
    }

    public static void showInventory(Inventory inventory) {}

    public int getNumberItems() {
        return numberItems;
    }
}

