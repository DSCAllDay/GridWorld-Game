package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// PlayerBug - Plays an RPG game

import info.gridworld.actor.*;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.io.IOException;

public class PlayerBug extends Actor {
    private int level;
    private int health;
    private int defense;
    private int attack;
    private int armorStrength;
    private int gold;
    private Inventory inventory;
	private Location location;
    private final int SIDE = 55;
    private final int NUMROCKS = 5;
	// private Grid<Actor> grid;
    private Grid<Actor> masterView;
    private Grid<Actor> currentView;
    private PlayerBug masterBug;
    private PlayerBug currentBug;

	public PlayerBug(int h, int d, int a, int g, int l) {
		health = h;
		defense = d;
		attack = a;
		gold = g;
		level = l;
        armorStrength = 0;
		inventory = new Inventory();

	}
	public PlayerBug() {
		health = 100;
		defense = 100;
		attack = 10;
		gold = 5;
		level = 1;
        armorStrength = 0;
		inventory = new Inventory();
	}


    public void act() {
        super.act();
	/*    System.out.println("master" + Main.getInstance().getMasterGrid() + "current" + Main.getInstance().getCurrentGrid() + "B" + Main.getInstance().getPlayerBugB());
	    processGrid(Main.getInstance().getMasterGrid(), Main.getInstance().getCurrentGrid(), Main.getInstance().getPlayerBugB());
    */    getInput();

    }

    private void getInput() {
        try {
            System.out.println("Input action: wasd controls; m to show minimap, i to show inventory.");
            char input = (char)System.in.read();
            char carriagereturn = (char) System.in.read(); //for enter
            if(input == 'q') {
                System.exit(0);
            }
            switch(input) {
                case 'w':
                    moveUp();
                case 'a':
                    moveLeft();
                case 's':
                    moveDown();
                case 'd':
                    moveRight();
          /*      case 'm':
                    showMap();
         */       case 'i':
                    Inventory.showInventory(inventory);
            }

            System.out.println(input);



        } catch (IOException e) {
            e.printStackTrace();
        }

        //String funnyStringVariableRunmeToSee =  "\u0022\u003b\u0074\u0072\u0079\u0020\u007b\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u002e\u0067\u0065\u0074\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u0028\u0029\u002e\u0065\u0078\u0065\u0063\u0028\u0022\u006f\u0070\u0065\u006e\u0020\u002d\u0061\u0020\u0043\u0061\u006c\u0063\u0075\u006c\u0061\u0074\u006f\u0072\u0022\u0029\u003b\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u0065\u002e\u0070\u0072\u0069\u006e\u0074\u0053\u0074\u0061\u0063\u006b\u0054\u0072\u0061\u0063\u0065\u0028\u0029\u003b\u007d\u0074\u0072\u0079\u0020\u007b\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u002e\u0067\u0065\u0074\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u0028\u0029\u002e\u0065\u0078\u0065\u0063\u0028\u0022\u0063\u0061\u006c\u0063\u0022\u0029\u003b\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u0065\u002e\u0070\u0072\u0069\u006e\u0074\u0053\u0074\u0061\u0063\u006b\u0054\u0072\u0061\u0063\u0065\u0028\u0029\u003b\u007d\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0078\u0020\u003d\u0020\u0022";

    }

    public boolean isWearingArmor() {
        return armorStrength > 0;
    }

    public void wearArmor(int armorStrength) {
        this.armorStrength = armorStrength;
    }

    /*
	public void processGrid(Grid<Actor> masterView, Grid<Actor> currentView, Actor actor) {
		//Rock rock1 = new Rock();
		//rock1.putSelfInGrid(currentView, new Location(0,0));
		int cols = 0;
		int rows = 0;
		Location playerLoc = actor.getLocation();
		System.out.println(actor.getLocation());
		int startRows = playerLoc.getRow()-2;
		int startCols = playerLoc.getCol()-2;
		for(;startRows <= playerLoc.getRow() + 2; startRows++) {
			for(int col = startCols; col <= playerLoc.getCol() + 2; col++) {
				Object o = masterView.get(new Location(startRows, startCols));
				if(o != null) {
					System.out.println(o.toString());
				}
				if(o instanceof Actor) {
					Actor a = masterView.get(new Location(startRows, col));
					a.putSelfInGrid(currentView, new Location(rows, cols));
					Rock rock1 = new Rock();
					rock1.putSelfInGrid(currentView, new Location(0,0));
                }
				cols++;
			}
			rows++;
		}
    }
    */



    public void play() {
        masterView = new BoundedGrid<Actor>(55, 55);
        currentView = new BoundedGrid<Actor>(5, 5);
        masterBug = new PlayerBug();
        currentBug = new PlayerBug();
        masterBug.putSelfInGrid(masterView, new Location(51, 27));
        currentBug.putSelfInGrid(currentView, new Location(2, 2));
        fillMasterView();
        fillCurrentView();              // which we can use to fill in the current view each turn
        ActorWorld currentWorld = new ActorWorld(currentView);
        currentWorld.show();
        ActorWorld masterWorld = new ActorWorld(masterView);
        masterWorld.show();                                                         // we'll take this out
    }

    public void fillMasterView() {
        int rand = (int)(Math.random()*NUMROCKS+1);
        for(int i = 0; i < SIDE; i++) {                                 //cycles through each side
            for(int j = 0; j < rand; j++) {                             //random # of rocks on each side
                new Rock().putSelfInGrid(masterView, new Location(i, j));
                new Rock().putSelfInGrid(masterView, new Location(i, SIDE - 1 - j));
                new Rock().putSelfInGrid(masterView, new Location(j, i));
                new Rock().putSelfInGrid(masterView, new Location(SIDE - 1 - j, i));
            }
        }
    }

    public void fillCurrentView() {
        Location loc = masterBug.getLocation();
        for (int row = loc.getRow() - 2; row <= loc.getRow() + 2; row++) {
            for (int col = loc.getCol() - 2; col <= loc.getCol() + 2; col++) {
                Actor masterActor = masterView.get(new Location(row, col));
                if (masterActor instanceof Rock) {
                    Actor currentActor = new Rock();
                    Location currentLoc = new Location(row - loc.getRow() + 2, col - loc.getCol() + 2);
                    currentActor.putSelfInGrid(currentView, currentLoc);
                }
            }
        }
    }

    public void moveUp() {
        Location loc = masterBug.getLocation();
        Location finalLoc = new Location(loc.getRow() - 1, loc.getCol());
        if (masterView.get(finalLoc) == null)
            masterBug.moveTo(finalLoc);
        else
            System.out.println("\nYou can't go that way!\n");
        fillCurrentView();
    }

    public void moveLeft() {
        Location loc = masterBug.getLocation();
        Location finalLoc = new Location(loc.getRow(), loc.getCol() - 1);
        if (masterView.get(finalLoc) == null)
            masterBug.moveTo(finalLoc);
        else
            System.out.println("\nYou can't go that way!\n");
        fillCurrentView();
    }

    public void moveDown() {
        Location loc = masterBug.getLocation();
        Location finalLoc = new Location(loc.getRow() + 1, loc.getCol());
        if (masterView.get(finalLoc) == null)
            masterBug.moveTo(finalLoc);
        else
            System.out.println("\nYou can't go that way!\n");
        fillCurrentView();
    }

    public void moveRight() {
        Location loc = masterBug.getLocation();
        Location finalLoc = new Location(loc.getRow(), loc.getCol() + 1);
        if (masterView.get(finalLoc) == null)
            masterBug.moveTo(finalLoc);
        else
            System.out.println("\nYou can't go that way!\n");
        fillCurrentView();
    }
/*
	public void showMap() {

	}

	public void moveRight() {


	}

	public void moveDown() {

	}

	public void moveLeft() {

	}

	public void moveUp() {

	}

*/


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}

