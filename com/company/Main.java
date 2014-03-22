package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// BugRunner - Runs a

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Main
{
    public static void main(String[] args)
    {
        Grid<Actor> gr = new BoundedGrid<Actor>(4, 4);
        ActorWorld world = new ActorWorld(gr);
        world.add(new Location(0, 0), new PlayerBug());
        world.show();
    }
}

