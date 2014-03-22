package com.company;

import java.util.*;
import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class Turn
{
    private static ArrayList<BoundedGrid> grids = new ArrayList<BoundedGrid>();
    private static ArrayList<Integer> directions = new ArrayList<Integer>();
    private static int currentGrid;

    public static void move(PlayerBug player, Location loc)
    {
        if (Turn.inBounds(loc))
        {
            player.moveTo(loc);
        }
        else
        {
            //Location newLoc = findNewLocation(loc);
            //makeNewGrid(newLoc);			// wrong
        }
    }

    public static void makeNewGrid(Location loc)
    {
        // changeGrid calls makeNewGrid
        Grid<Actor> gr = new BoundedGrid<Actor>(4, 4);
        ActorWorld world = new ActorWorld(gr);
        //Turn.grids.add(gr);
        world.add(loc, new PlayerBug());
        world.show();
        Turn.currentGrid++;				// only works once
    }

    public static void changeGrid(Location loc)
    {
		/* if (there’s a grid there)
			put it in that grid
		else
			make a new grid
		*/
    }

    public static boolean inBounds(Location loc)
    {
        return loc.getRow() >= 0 && loc.getRow() < 4 && loc.getCol() >= 0 && loc.getCol() < 4;
    }
}

