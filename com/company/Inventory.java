package com.company;

/**
 * Created by esauKang on 3/21/14.
 */
// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// inventoryclasses - Holds the player's items

import java.util.*;
import com.company.inventoryclasses.*;

public class Inventory
{
    private ArrayList<InventoryItem> inventory;
    private int numberItems;

    public Inventory()
    {
        inventory = new ArrayList<InventoryItem>(10);
        numberItems = 0;
    }

    public void addToInventory(InventoryItem item)
    {
        inventory.add(item);
        numberItems++;
    }

    public String toString()
    {
        String answer = "You have " + numberItems + " items. You have…";
        for (int i = 0; i < numberItems; i++)
            answer += "\n" + inventory.get(i);              // Requires that all inventory items have toString methods
        return answer;
    }

    public static void showInventory(Inventory i) {

    }
}

