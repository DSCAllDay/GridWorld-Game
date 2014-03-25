package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// BugRunner - Runs playerBugA

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Main {
	/*private final int SIDE = 55;
	private final int NUMROCKS = 5;
	private Grid<Actor> masterGrid = new BoundedGrid<Actor>(SIDE, SIDE);
	private ActorWorld masterWorld = new ActorWorld(masterGrid);
	private Grid<Actor> currentGrid = new BoundedGrid<Actor>(5, 5);
	private ActorWorld currentWorld = new ActorWorld(currentGrid);
	private PlayerBug playerBugA = new PlayerBug();
	private PlayerBug playerBugB = new PlayerBug();
	private static Main m  = new Main();                                //singleton
	private Main() { }
	public static Main getInstance() {
		return m;
	}


	public static void main(String[] args) {
	 m.start(); */
    public static void main(String[] args) {
        PlayerBug unReal = new PlayerBug();             // unreal as in it isn't an actual player
        unReal.play();
    }
/*
	private void start() {

		for(int i = 0; i < SIDE; i++) {                                 //cycles through each side
		    int rand = (int)(Math.random()*NUMROCKS+1);
		    for(int j = 0; j < rand; j++) {                             //random # of rocks on each side
			    Rock a = new Rock();
			    Rock b = new Rock();
			    Rock c = new Rock();
			    Rock d = new Rock();
			    a.putSelfInGrid(masterGrid, new Location(i, j));
			    b.putSelfInGrid(masterGrid, new Location(i, SIDE - 1 - j));
				c.putSelfInGrid(masterGrid, new Location(j, i));
			    d.putSelfInGrid(masterGrid, new Location(SIDE - 1 - j, i));
		    }
	    }
		//currentWorld.add(new Location(2, 2), playerBugA);
		playerBugA.putSelfInGrid(currentGrid, new Location(2, 2));
		currentWorld.show();
		//masterWorld.add(new Location(49, 27), playerBugB);
		playerBugB.putSelfInGrid(masterGrid, new Location(49, 27));
		System.out.println(playerBugB.getLocation());
		Rock rocks = new Rock();
		rocks.putSelfInGrid(currentGrid, new Location(4, 2));

		masterWorld.show();
	}


	public PlayerBug getPlayerBugA() {
		return playerBugA;
	}

	public void setPlayerBugA(PlayerBug playerBugA) {
		this.playerBugA = playerBugA;
	}

	public PlayerBug getPlayerBugB() {
		return playerBugB;
	}

	public void setPlayerBugB(PlayerBug playerBugB) {
		this.playerBugB = playerBugB;
	}

	public Grid<Actor> getMasterGrid() {
		return masterGrid;
	}

	public void setMasterGrid(Grid<Actor> masterGrid) {
		this.masterGrid = masterGrid;
	}

	public Grid<Actor> getCurrentGrid() {
		return currentGrid;
	}

	public void setCurrentGrid(Grid<Actor> currentGrid) {
		this.currentGrid = currentGrid;
	}
*/
}


