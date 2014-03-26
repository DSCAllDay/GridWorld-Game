package com.company;
import com.company.enemies.*;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class BraveNewWorld extends ActorWorld{
	private final int SIDE = 55;
	private final int NUMROCKS = 5;
	private static BoundedGrid<Actor> masterView;
	private BoundedGrid<Actor> currentView;
	private static PlayerBug masterBug;
	private  PlayerBug currentBug;
	private Inventory inventory;

	public BraveNewWorld(PlayerBug currentBug, BoundedGrid<Actor> currentView) {
		super(currentView);
		this.currentBug = currentBug;
		this.currentView = currentView;

	}

	public void go() {
		masterView = new BoundedGrid<Actor>(55, 55);
		masterBug = new PlayerBug();
		masterBug.putSelfInGrid(masterView, new Location(49, 27));
        new Gianni().putSelfInGrid(masterView, new Location(47, 27));
		fillMasterView();
		fillCurrentView();                                  // which we can use to fill in the current view each turn
		ActorWorld masterWorld = new ActorWorld(masterView);
		this.show();
		masterWorld.show();
	}

	@Override
	public boolean keyPressed(String description, Location loc) {
		getInput(description);
		return super.keyPressed(description, loc);
	}

	private void getInput(String input) {
			System.out.println("Input action: wasd controls; m to show minimap, i to show inventory.");
			if(input.equals("Q")) {
				System.exit(0);
			}
			switch(input) {
				case "W":
					moveUp();
					break;
				case "A":
					moveLeft();
					break;
				case "S":
					moveDown();
					break;
				case "D":
					moveRight();
					break;
				case "I":
					Inventory.showInventory(inventory);
					break;
			}
	}

	public void moveUp() {
		clearCurrentGrid();
		Location loc = masterBug.getLocation();
		Location finalLoc = new Location(loc.getRow() - 1, loc.getCol());
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
		if (masterView.get(finalLoc) == null)
			masterBug.moveTo(finalLoc);
		else
			System.out.println("\nYou can't go that way!\n");
		fillCurrentView();
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
                else if (masterActor instanceof com.company.enemies.Enemy) {
                    if (masterActor instanceof Gianni) {
                        Gianni currentGianni = new Gianni();
                        Location currentLoc = new Location(row - loc.getRow() + 2, col - loc.getCol() + 2);
                        currentGianni.putSelfInGrid(currentView, currentLoc);
                    }
                }
			}
		}
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

	public void clearCurrentGrid() {
		for(int rows = 0; rows < 5; rows++) {
			for(int cols = 0; cols < 5; cols++) {
				Actor removeActor = currentView.get(new Location(rows, cols));
				if (removeActor != null && !(removeActor instanceof PlayerBug))
					removeActor.removeSelfFromGrid();
			}
		}
	}
}
