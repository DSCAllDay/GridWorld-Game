package com.company.enemies;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

// Esau Kang, thomas Madden
// Period 5
// March 25, 2014
// Gianni - An enemy of the Mr. B PlayerBug

public class Gianni extends Enemy {
    public Gianni() {
        super(25, 25, 15, 1, "Gianni");
    }

    public void act() {
        if (Math.random() < 0.1) {
            Location loc = getLocation();
            int direction = (int)(Math.random() * 4);
            Location finalLoc;
            if (direction == 0)
                finalLoc = new Location(loc.getRow() - 1, loc.getCol());
            else if (direction == 1)
                finalLoc = new Location(loc.getRow(), loc.getCol() - 1);
            else if (direction == 2)
                finalLoc = new Location(loc.getRow() + 1, loc.getCol());
            else
                finalLoc = new Location(loc.getRow(), loc.getCol() + 1);
            if (!(getGrid().get(finalLoc) instanceof Actor))
                moveTo(finalLoc);
        }
    }

}