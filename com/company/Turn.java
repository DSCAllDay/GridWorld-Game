package com.company;

import java.util.*;
import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class Turn
{
    private static ArrayList<BoundedGrid> grids = new ArrayList<BoundedGrid>();
    private static ArrayList<Integer> directions = new ArrayList<Integer>();
    private static int currentGrid;

    public static boolean inBounds(Location loc)
    {
        return loc.getRow() >= 0 && loc.getRow() < 4 && loc.getCol() >= 0 && loc.getCol() < 4;
    }
}

