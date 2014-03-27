package com.company.inventoryclasses;

/**
 * Created by esauKang on 3/21/14.
 */
public class Spell {
    private int strength;
    private String type;

    public Spell(int strength, String type) {
        this.strength = strength;
        this.type = type;
    }

    public int getStrength() {
        return strength;
    }

    public String toString() {
        return "\tSpell\t\t" + type;
    }
}
