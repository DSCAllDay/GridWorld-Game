package com.company.inventoryclasses;

/**
 * Created by esauKang on 3/21/14.
 */
public class Spells {
    private int strength;
    private String type;

    public Spells(int strength, String type) {
        this.strength = strength;
        this.type = type;
    }

    public int getStrength() {
        return strength;
    }

    public String getType() {
        return type;
    }
}
