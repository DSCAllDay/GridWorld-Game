package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// BugRunner - Runs playerBugA

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Main {
	private int level;
	private int health;
	private int defense;
	private int attack;
	private int armorStrength;
	private int gold;
	private Inventory inventory;
	private Location location;
	private static final int SIDE = 55;
	private static final int NUMROCKS = 5;
	private static BoundedGrid<Actor> masterView;
	private static BoundedGrid<Actor> currentView;
	private static PlayerBug masterBug;
	private static PlayerBug currentBug;




	public static void main(String[] args) {
		currentBug = new PlayerBug();
		currentView = new BoundedGrid<Actor>(5,5);
		currentBug.putSelfInGrid(currentView, new Location(2, 2));
		BraveNewWorld braveNewWorld = new BraveNewWorld(currentBug, currentView);
		braveNewWorld.go();
	}
}


