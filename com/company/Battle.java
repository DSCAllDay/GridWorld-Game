package com.company;

import com.company.enemies.Enemy;
import com.company.inventoryclasses.Spell;
import com.company.inventoryclasses.Weapon;

import java.util.Scanner;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// Battle - Battle an enemy!

public class Battle {
    private PlayerBug player;
    private Enemy enemy;

    public Battle(PlayerBug player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        fightBattle(1);
    }

    public void fightBattle(int turn) {
        if (enemy.getEnemyHealth() > 0 && player.getHealth() > 0) {
            boolean realResponse = false;
            boolean successfulFlee = false;
            while (!realResponse) {
                System.out.println("\nYou are fighting " + enemy + ". It is turn " + turn + ". What would you like to do? You can just \'attack\', \'slash\' if you have a sword, \'cast fire\', or \'cast frost\' if you have spells.");
                Scanner keys = new Scanner(System.in);
                String input = keys.nextLine();
                input = Battle.clean(input);
                if (input.equals("options")) {
                    getOptions();
                } else if (input.equals("attack")) {
                    attack(0);
                    realResponse = true;
                } else if (input.equals("slash")) {
                    if (player.hasSword() > 0 ) {
                        attack(player.hasSword());
                        realResponse = true;
                    }
                    else
                        System.out.println("\nYou can't slash! You don't have a sword.");
                } else if (input.equals("cast fire")) {
                    if (player.hasFire()) {
                        attack(5);
                        realResponse = true;
                    }
                    else
                        System.out.println("\nYou can't cast fire! You don't have a spell.");
                } else if (input.equals("cast frost")) {
                    if (player.hasFrost()) {
                        attack(15);
                        realResponse = true;
                    }
                    else
                        System.out.println("\nYou can't cast frost! You don't have a spell.");
                } else if (input.equals("flee")) {
                    successfulFlee = flee();
                    realResponse = true;
                } else {
                    System.out.println("\nThat's not a valid response, I'm afraid.");
                }
            }
            if (enemy.getEnemyHealth() > 0) {
                int advantage = 0;
                enemyAttack(advantage);
            }
            if (!successfulFlee && player.getHealth() > 0 && enemy.getEnemyHealth() > 0)
                fightBattle(turn + 1);
        } if (player.getHealth() <= 0) {
            System.out.println("You lost to " + enemy + ".");
            die();
        } else if (enemy.getEnemyHealth() <= 0 && !enemy.defeated) {
		    calculateExp();
            collectSpoils();
		    enemy.removeSelfFromGrid();
		    enemy.defeated = true;
        }
    }

	private void calculateExp() {
		player.setExp(player.getExp() + enemy.getEnemyGold()*7);
		int newExp = player.getExp();
		if(newExp > 500) {
			player.setLevel(7);
		} else if(newExp > 300) {
			player.setLevel(6);
		} else if(newExp > 210) {
			player.setLevel(5);
		} else if(newExp > 135) {
			player.setLevel(4);
		} else if(newExp > 60) {
			player.setLevel(3);
		} else if(newExp > 35) {
			player.setLevel(2);
		}
	}

	public void getOptions() {
        com.company.Inventory inventory = player.getInventory();
        int numItems = inventory.getNumberItems();
        System.out.println("\nYou have these weapons to hit with: ");
        for (int i = 0; i < numItems; i++)
            if (inventory.getItem(i) instanceof Weapon)
                System.out.println(inventory.getItem(i));
        System.out.println("\nYou have these spells to use: ");
        for (int i = 0; i < numItems; i++)
            if (inventory.getItem(i) instanceof Spell)
                System.out.println(inventory.getItem(i));
        System.out.println("\nOr you can always flee.");
    }

    public void attack(int advantage) {
        int attack = player.getAttack() + advantage - enemy.getEnemyDefense();
        if (attack < 0)
            attack = 0;
        int levelDifference = player.getLevel() - enemy.getEnemyLevel();
        if (hitOrMiss(levelDifference)) {
            enemy.setEnemyHealth(enemy.getEnemyHealth() - attack);
            System.out.println("\nYou hit the enemy! " + enemy + " has " + enemy.getEnemyHealth() + " health left.");
        } else {
            System.out.println("\nYou missed the enemy! " + enemy + " still has " + enemy.getEnemyHealth() + " health left.");
        }
    }

    public void enemyAttack(int advantage) {     // Advantage for player
        int attack = enemy.getEnemyAttack() - player.getDefense() - advantage;
        if (attack < 0)
            attack = 0;
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
            chances = 90;
        else if (levelDifference >= 4)
            chances = 80;
        else if (levelDifference == 0)
            chances = 75;
        else if (levelDifference <= -1 && levelDifference >= -3)
            chances = 70;
        else if (levelDifference <= -4)
            chances = 60;
        return (int)(Math.random() * 100) + 1 <= chances;
    }

    public boolean flee() {
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
            return true;
        } else {
            player.setHealth(player.getHealth() - 10);
            if (player.getHealth() > 0) {
                System.out.println("You were unable to flee. You are whacked by the gamemaster and lose 10 health. You now have " + player.getHealth() + " health left.");
                return false;
            }
            else {
                System.out.println("You were unable to flee. You are whacked by the gamemaster and lose 10 health. You now have " + player.getHealth() + " health left, so you die.");
                die();
            }
        }
        return false;
    }

    public void collectSpoils() {
        player.setGold(player.getGold() + enemy.getEnemyGold());
        System.out.println("\nYou won! You get " + enemy.getEnemyGold() + " gold, " + enemy.getEnemyGold() * 7 + "xp, and you are now level " + player.getLevel());
    }

    public void die() {
        System.out.println("You died! Sucks.");
        System.exit(0);
    }

    // pre: none
    // post: Cleans a string (Making it lowercase) and takes away all spaces/punctuation
    public static String clean(String input) {
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
