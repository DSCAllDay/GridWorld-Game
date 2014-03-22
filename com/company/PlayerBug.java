package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// PlayerBug - Plays an RPG game-


import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class PlayerBug extends Actor
{
    private int level;
    private int health;
    private int defense;
    private int attack;
    private int gold;
    private Inventory inventory;
    private Location location;

    public PlayerBug(int h, int d, int a, int g, int l)
    {
        health = h;
        defense = d;
        attack = a;
        gold = g;
        level = l;
        inventory = new Inventory();

    }
    public PlayerBug()
    {
        health = 100;
        defense = 100;
        attack = 10;
        gold = 5;
        level = 1;
        inventory = new Inventory();
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

}

