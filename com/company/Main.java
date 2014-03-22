package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// BugRunner - Runs a

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Grid<Actor> gr = new BoundedGrid<Actor>(5, 5);
        ActorWorld world = new ActorWorld(gr);
        world.add(new Location(2, 2), new PlayerBug());
        world.show();
    }

}


