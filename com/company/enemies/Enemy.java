package com.company.enemies;

// Esau Kang, thomas Madden
// Period 5
// March 24, 2014
// Enemy - Stores info for an enemy of Player

import info.gridworld.actor.Actor;

public abstract class Enemy extends Actor {
    private int enemyHealth;
    private int enemyDefense;
    private int enemyAttack;
    private int enemyGold;
    private int enemyLevel;
    private String enemyName;
	public boolean defeated = false;

    public Enemy(int eH, int eD, int eA, int eL, int eG, String eN) {
        this.enemyHealth = eH;
        this.enemyDefense = eD;
        this.enemyAttack = eA;
        this.enemyGold = (int)(Math.random() * eG);
        this.enemyLevel = eL;
        this.enemyName = eN;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyDefense() {
        return enemyDefense;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public int getEnemyLevel() {
        return enemyLevel;
    }

    public int getEnemyGold() {
        return enemyGold;
    }

    public String toString() {
        return enemyName;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setEnemyDefense(int enemyDefense) {
        this.enemyDefense = enemyDefense;
    }

    public void setEnemyAttack(int enemyAttack) {
        this.enemyAttack = enemyAttack;
    }
}