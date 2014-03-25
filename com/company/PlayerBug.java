package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// PlayerBug - Plays an RPG game


import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.io.*;

public class PlayerBug extends Actor {
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

        //String funnyStringVariableRunmeToSee =  "\u0022\u003b\u0074\u0072\u0079\u0020\u007b\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u002e\u0067\u0065\u0074\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u0028\u0029\u002e\u0065\u0078\u0065\u0063\u0028\u0022\u006f\u0070\u0065\u006e\u0020\u002d\u0061\u0020\u0043\u0061\u006c\u0063\u0075\u006c\u0061\u0074\u006f\u0072\u0022\u0029\u003b\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u0065\u002e\u0070\u0072\u0069\u006e\u0074\u0053\u0074\u0061\u0063\u006b\u0054\u0072\u0061\u0063\u0065\u0028\u0029\u003b\u007d\u0074\u0072\u0079\u0020\u007b\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u002e\u0067\u0065\u0074\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u0028\u0029\u002e\u0065\u0078\u0065\u0063\u0028\u0022\u0063\u0061\u006c\u0063\u0022\u0029\u003b\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u0065\u002e\u0070\u0072\u0069\u006e\u0074\u0053\u0074\u0061\u0063\u006b\u0054\u0072\u0061\u0063\u0065\u0028\u0029\u003b\u007d\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0078\u0020\u003d\u0020\u0022";

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


    public PlayerBug(int h, int d, int a, int g, int l) {
        health = h;
        defense = d;
        attack = a;
        gold = g;
        level = l;
        inventory = new Inventory();

    }
    public PlayerBug() {
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

