package com.company;

// Esau Kang, thomas Madden
// Period 5
// March 21st, 2014
// BugRunner - Runs playerBugA

import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Main {

	public static void main(String[] args) {
		BraveNewWorld braveNewWorld = new BraveNewWorld(new BoundedGrid<Actor>(5, 5));
		braveNewWorld.go();
	}
}


