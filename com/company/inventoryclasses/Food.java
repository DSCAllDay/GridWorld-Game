package com.company.inventoryclasses;

/**
 * Created by esauKang on 3/21/14.
 */
public class Food {
    private int strength;
    private String type;

    public Food(int strength, String type) {
        this.strength = strength;
        this.type = type;
    }

    public int getStrength() {
        return strength;
    }

    public String toString() {
        return "\tFood\t\t" + type;
    }
}
