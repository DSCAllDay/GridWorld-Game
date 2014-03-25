package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// BugRunner - Runs a

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Main {
	private static final int NUMROCKS = 5;
	private static final int SIDE = 55;

	public static void main(String[] args) {
	    Grid<Actor> masterView = new BoundedGrid<Actor>(SIDE, SIDE);
		ActorWorld masterWorld = new ActorWorld(masterView);
		Grid<Actor> currentView = new BoundedGrid<Actor>(5, 5);
		ActorWorld currentWorld = new ActorWorld(currentView);


	    for(int i = 0; i < SIDE; i++) {                                 //cycles through each side
		    int rand = (int)(Math.random()*NUMROCKS+1);
		    for(int j = 0; j < rand; j++) {                             //random # of rocks on each side
			    Rock a = new Rock();
			    Rock b = new Rock();
			    Rock c = new Rock();
			    Rock d = new Rock();
			    a.putSelfInGrid(masterView, new Location(i, j));
			    b.putSelfInGrid(masterView, new Location(i, SIDE - 1 - j));
				c.putSelfInGrid(masterView, new Location(j, i));
			    d.putSelfInGrid(masterView, new Location(SIDE - 1 - j, i));
		    }
	    }

		currentWorld.add(new Location(2, 2), new PlayerBug());
		currentWorld.show();
		masterWorld.add(new Location(49, 27), new PlayerBug());
        //masterWorld.show();
    }

}


