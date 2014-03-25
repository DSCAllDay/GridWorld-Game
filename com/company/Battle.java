package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// InventoryItem - Item which can be put in the inventory

import java.util.*;

public class Battle {

    public Battle(PlayerBug player, Enemy enemy) {
        fightBattle(player, enemy, 1);
    }

    public void fightBattle(PlayerBug player, Enemy enemy, int turn) {
        System.out.println("You are fighting " + enemy + ". It is turn " + turn + ". What would you like to do?");
        if (enemy.getEnemyHealth() > 0 && player.getHealth() > 0) {
            Scanner keys = new Scanner(System.in);
            String input = keys.nextLine();
            if (input.equals("options")) {         // we can use my Commands file and StringUtil to figure out punctuation stuff
                getOptions(player);
            } else if (input.equals("attack")) {
                attack(player, enemy, 0);
            } else if (input.equals("slash")) {
                attack(player, enemy, 10);
            } else if (input.equals("cast fire")) {
                attack(player, enemy, 5);
            } else if (input.equals("cast frost")) {
                attack(player, enemy, 15);
            } else if (input.equals("flee")) {
                flee(player, enemy);
            }
            // Enemy attacks you, haven't done it yet
        } else if (enemy.getEnemyHealth() < 0) {
            collectSpoils(player, enemy);
        } else {
            // You lose, i haven't done it yet
        }
    }

    public void getOptions(PlayerBug player) {
        Inventory inventory = player.getInventory();
        int numItems = inventory.getNumberItems();
        System.out.println("\nYou have these weapons to hit with: ");
        for (int i = 0; i < numItems; i++)
            if (inventory.getItem(i) instanceof com.company.inventoryclasses.Weapons)
                System.out.println(inventory.getItem(i));
        System.out.println("\nYou have these spells to use: ");
        for (int i = 0; i < numItems; i++)
            if (inventory.getItem(i) instanceof com.company.inventoryclasses.Spells)
                System.out.println(inventory.getItem(i));
        System.out.println("\nOr you can always flee.");
    }

    public void attack(PlayerBug player, Enemy enemy, int advantage) {
        int attack = player.getAttack() + advantage - enemy.getEnemyDefense();
        int levelDifference = player.getLevel() - enemy.getEnemyLevel();
        if (hitOrMiss(levelDifference)) {
            enemy.setEnemyHealth(enemy.getEnemyHealth() - attack);
            System.out.println("You hit the enemy! " + enemy + " has " + enemy + "health left.");
        } else {
            System.out.println("You missed the enemy! " + enemy + " still has " + enemy + "health left.");
        }
    }

    public boolean hitOrMiss(int levelDifference) {
        int chances = 0;
        if (levelDifference >= 1 && levelDifference <= 3)
            chances = 65;
        else if (levelDifference >= 4 && levelDifference <= 5)
            chances = 85;
        else if (levelDifference == 0)
            chances = 50;
        else if (levelDifference <= -1 && levelDifference >= -3)
            chances = 35;
        else if (levelDifference <= -4 && levelDifference >= -5)
            chances = 15;
        return (int)(Math.random() * 100) <= chances;
    }

    public void flee(PlayerBug player, Enemy enemy) {
        int levelDifference = player.getLevel() - enemy.getEnemyLevel();
    }

    public void collectSpoils(PlayerBug player, Enemy enemy) {
        System.out.println("\nYou won! You get " + enemy.getEnemyGold());
        player.setGold(player.getGold() + enemy.getEnemyGold());
    }
}
