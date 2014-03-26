package com.company;

import java.util.Scanner;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// Battle - Battle an enemy!

public class Battle {
    private com.company.PlayerBug player;
    private com.company.enemies.Enemy enemy;

    public Battle(com.company.PlayerBug player, com.company.enemies.Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        fightBattle(1);
    }

    public void fightBattle(int turn) {
        System.out.println("You are fighting " + enemy + ". It is turn " + turn + ". What would you like to do?");
        if (enemy.getEnemyHealth() > 0 && player.getHealth() > 0) {
            Scanner keys = new Scanner(System.in);
            String input = keys.nextLine();
            input = Battle.clean(input);                    // Should be PlayerBug.clean(input) later but i won't edit that for now
            if (input.equals("options")) {
                getOptions();
            } else if (input.equals("attack")) {
                attack(0);
            } else if (input.equals("slash")) {
                attack(10);
            } else if (input.equals("cast fire")) {
                attack(5);
            } else if (input.equals("cast frost")) {
                attack(15);
            } else if (input.equals("flee")) {
                flee();
            }
            if (enemy.getEnemyHealth() > 0) {
                int advantage = 0;
                if (player.isWearingArmor())

                enemyAttack(advantage);
            }
        } else if (enemy.getEnemyHealth() < 0) {
            collectSpoils();
        } else {
            System.out.println("You lost to " + enemy + ".");
            die();
        }
    }

    public void getOptions() {
        com.company.Inventory inventory = player.getInventory();
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

    public void attack(int advantage) {
        int attack = player.getAttack() + advantage - enemy.getEnemyDefense();
        int levelDifference = player.getLevel() - enemy.getEnemyLevel();
        if (hitOrMiss(levelDifference)) {
            enemy.setEnemyHealth(enemy.getEnemyHealth() - attack);
            System.out.println("\nYou hit the enemy! " + enemy + " has " + enemy.getEnemyHealth() + "health left.");
        } else {
            System.out.println("\nYou missed the enemy! " + enemy + " still has " + enemy.getEnemyHealth() + "health left.");
        }
    }

    public void enemyAttack(int advantage) {     // Advantage for player
        int attack = enemy.getEnemyAttack() - player.getDefense() - advantage;
        int levelDifference = enemy.getEnemyLevel() - player.getLevel();
        if (hitOrMiss(levelDifference)) {
            player.setHealth(player.getHealth() - attack);
            if (player.getHealth() > 0)
                System.out.println("\nThe enemy hit you! You now have " + player.getHealth() + " health left.");
            else {
                System.out.println("\n" + enemy + " killed you with that last hit. :(");
                die();
            }
        } else {
            System.out.println("The enemy missed you! You still have " + player.getHealth() + " health left.");
        }
    }

    public boolean hitOrMiss(int levelDifference) {
        int chances = 0;
        if (levelDifference >= 1 && levelDifference <= 3)
            chances = 60;
        else if (levelDifference >= 4 && levelDifference <= 5)
            chances = 75;
        else if (levelDifference == 0)
            chances = 50;
        else if (levelDifference <= -1 && levelDifference >= -3)
            chances = 40;
        else if (levelDifference <= -4 && levelDifference >= -5)
            chances = 25;
        return (int)(Math.random() * 100) <= chances;
    }

    public void flee() {
        int levelDifference = player.getLevel() - enemy.getEnemyLevel();
        int chances = 0;
        if (levelDifference >= 1 && levelDifference <= 3)
            chances = 40;
        else if (levelDifference >= 4 && levelDifference <= 5)
            chances = 50;
        else if (levelDifference == 0)
            chances = 25;
        else if (levelDifference <= -1 && levelDifference >= -3)
            chances = 15;
        else if (levelDifference <= -4 && levelDifference >= -5)
            chances = 10;
        if ((int)(Math.random() * 100) <= chances) {
            System.out.println("You fleed! You are away from the battle.");
            // End battle
        } else {
            if (player.getHealth() > 10) {
                player.setHealth(player.getHealth() - 10);
                System.out.println("You were unable to flee. You are whacked by the gamemaster and lose 10 health. You now have " + player.getHealth() + " health left.");
            }
            else
                die();
        }
    }

    public void collectSpoils() {
        System.out.println("\nYou won! You get " + enemy.getEnemyGold() + " and you are now level " + player.getLevel() + 1);
        player.setGold(player.getGold() + enemy.getEnemyGold());
        player.setLevel(player.getLevel() + 1);
    }

    public void die() {

    }

    // pre: none
    // post: Cleans a string (Making it lowercase) and takes away all spaces/punctuation
    public static String clean(String input)
    {
        String cleaned = "";
        for (int i = 0; i < input.length(); i++)
        {
            char charAt = input.charAt(i);
            if (input.charAt(i) >= 'a' && charAt <= 'z')
                cleaned += charAt;
            else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
            {
                charAt += 32;
                cleaned += charAt;
            }
        }
        return cleaned;
    }
}
