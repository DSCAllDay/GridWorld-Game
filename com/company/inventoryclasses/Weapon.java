package com.company.inventoryclasses;

/**
 * Created by esauKang on 3/21/14.
 */
public class Weapon {
    private int strength;
    private String type;
	private String quality;
	private int minLevel;
	private int cost;

    public Weapon(int strength, String type, String quality, int minLevel, int cost) {
        this.strength = strength;
        this.type = type;
	    this.quality = quality;
	    this.minLevel = minLevel;
	    this.cost = cost;
    }
	public Weapon() {
		this.strength = 3;
		this.type = "Sword";
		this.quality = "Bad";
		this.minLevel = 1;
		this.cost = 5;
	}

    public int getStrength() {
        return strength;
    }

    public String toString() {
        return strength + "DMG " + quality + " " + type;
    }

	public int getMinLevel() {
		return minLevel;
	}

	public String getType() {
		return type;
	}

	public String getQuality() {
		return quality;
	}

	public int getCost() {
		return cost;
	}
}
