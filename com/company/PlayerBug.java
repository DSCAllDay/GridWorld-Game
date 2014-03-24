package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// PlayerBug - Plays an RPG game- asdfa


import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.io.*;

public class PlayerBug extends Actor
{
    private int level;
    private int health;
    private int defense;
    private int attack;
    private int gold;
    private Inventory inventory;
    private Location location;

    public void act() {
        super.act();
        getInput();

    }

    private void getInput() {
        try {
            System.out.println("Input action: wasd controls; m to show minimap, i to show inventory.");
            char input = (char)System.in.read();
            char carriagereturn = (char) System.in.read(); //for enter
            if(input == 'q') {
                System.exit(0);
            }
            switch(input) {
                case 'w':
                    moveUp();
                case 'a':
                    moveLeft();
                case 's':
                    moveDown();
                case 'd':
                    moveRight();
                case 'm':
                    showMap();
                case 'i':
                    Inventory.showInventory(inventory);
            }

            System.out.println(input);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showMap() {

    }

    public void moveRight() {

    }

    public void moveDown() {

    }

    public void moveLeft() {

    }

    public void moveUp() {

    }


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

