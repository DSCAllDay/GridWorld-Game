package com.company;

import java.util.*;
import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class Turn
{
    private Grid<Actor> master = new BoundedGrid<Actor>(50, 50);

    public static boolean inBounds(Location loc)
    {
        return loc.getRow() >= 0 && loc.getRow() < 4 && loc.getCol() >= 0 && loc.getCol() < 4;
    }
}

