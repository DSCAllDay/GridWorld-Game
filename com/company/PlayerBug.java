package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// PlayerBug - Plays an RPG game

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
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
    private static Grid<Actor> masterView;
    private static Grid<Actor> currentView;
    private static PlayerBug masterBug;
    private static PlayerBug currentBug;


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
        //super.act();
	    //getInput();

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
	                break;
                case 'a':
                    moveLeft();
	                break;
                case 's':
                    moveDown();
	                break;
                case 'd':
                    moveRight();
	                break;
                case 'i':
                    Inventory.showInventory(inventory);
	                break;
            }

            System.out.println(input);



        } catch (IOException e) {
            e.printStackTrace();
        }

        // String funnyStringVariableRunmeToSee =  "\u0022\u003b\u0074\u0072\u0079\u0020\u007b\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u002e\u0067\u0065\u0074\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u0028\u0029\u002e\u0065\u0078\u0065\u0063\u0028\u0022\u006f\u0070\u0065\u006e\u0020\u002d\u0061\u0020\u0043\u0061\u006c\u0063\u0075\u006c\u0061\u0074\u006f\u0072\u0022\u0029\u003b\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u0065\u002e\u0070\u0072\u0069\u006e\u0074\u0053\u0074\u0061\u0063\u006b\u0054\u0072\u0061\u0063\u0065\u0028\u0029\u003b\u007d\u0074\u0072\u0079\u0020\u007b\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u002e\u0067\u0065\u0074\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u0028\u0029\u002e\u0065\u0078\u0065\u0063\u0028\u0022\u0063\u0061\u006c\u0063\u0022\u0029\u003b\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u0065\u002e\u0070\u0072\u0069\u006e\u0074\u0053\u0074\u0061\u0063\u006b\u0054\u0072\u0061\u0063\u0065\u0028\u0029\u003b\u007d\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0078\u0020\u003d\u0020\u0022";

    }

    public boolean isWearingArmor() {
        return armorStrength > 0;
    }

    public void wearArmor(int armorStrength) {
        this.armorStrength = armorStrength;
    }



    public void fillMasterView() {
        for(int i = 0; i < SIDE; i++) {                                     //cycles through each side
	        int rand = (int)(Math.random()*NUMROCKS+1);
	        for(int j = 0; j < 2; j++) {                                    //forces a 2 wide border
		        new Rock().putSelfInGrid(masterView, new Location(i, j));
		        new Rock().putSelfInGrid(masterView, new Location(i, SIDE - 1 - j));
		        new Rock().putSelfInGrid(masterView, new Location(j, i));
		        new Rock().putSelfInGrid(masterView, new Location(SIDE - 1 - j, i));
	        }
	        for(int j = 0; j < rand; j++) {                                 //random # of rocks on each side
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

	public void clearCurrentGrid() {
		for(int rows = 0; rows < 5; rows++) {
			for(int cols = 0; cols < 5; cols++) {
				Actor removeActor = currentView.get(new Location(rows, cols));
				if (removeActor != null && !(removeActor instanceof PlayerBug))
					removeActor.removeSelfFromGrid();
			}
		}
	}

	public void moveUp() {
		clearCurrentGrid();
	    Location loc = masterBug.getLocation();
	    Location finalLoc = new Location(loc.getRow() - 1, loc.getCol());
	    //System.out.println(finalLoc);
	    if (masterView.get(finalLoc) == null)
		    masterBug.moveTo(finalLoc);
	    else
		    System.out.println("\nYou can't go that way!\n");
	    fillCurrentView();
    }


    public void moveLeft() {
	    clearCurrentGrid();
        Location loc = masterBug.getLocation();
        Location finalLoc = new Location(loc.getRow(), loc.getCol() - 1);
	    //System.out.println(finalLoc);
	    if (masterView.get(finalLoc) == null)
            masterBug.moveTo(finalLoc);
        else
            System.out.println("\nYou can't go that way!\n");
        fillCurrentView();
    }

    public void moveDown() {
	    clearCurrentGrid();
	    Location loc = masterBug.getLocation();
	    Location finalLoc = new Location(loc.getRow() + 1, loc.getCol());
	    //System.out.println(finalLoc);
	    if (masterView.get(finalLoc) == null)
		    masterBug.moveTo(finalLoc);
	    else
		    System.out.println("\nYou can't go that way!\n");
	    fillCurrentView();
    }

    public void moveRight() {
	    clearCurrentGrid();
	    Location loc = masterBug.getLocation();
	    Location finalLoc = new Location(loc.getRow(), loc.getCol() + 1);
	    //System.out.println(finalLoc);
	    if (masterView.get(finalLoc) == null)
		    masterBug.moveTo(finalLoc);
	    else
		    System.out.println("\nYou can't go that way!\n");
	    fillCurrentView();
    }

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

