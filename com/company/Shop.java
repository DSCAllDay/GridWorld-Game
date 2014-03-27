package com.company;

import com.company.inventoryclasses.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by esauKang on 3/26/14.
 */


public class Shop {

	private HashMap <String, HashMap> stock = new HashMap <> ();
	private HashMap <String, Weapon> swordStock = new HashMap <> ();
	private ArrayList crossbows = new ArrayList();
	private ArrayList staffs = new ArrayList();
	private ArrayList maces = new ArrayList();




	public Shop() {
		Weapon badSword = new Weapon(3, "Sword", "Bad", 1, 5);
		Weapon mediocreSword = new Weapon(5, "Sword", "Mediocre", 2, 8);
		Weapon goodSword = new Weapon(7, "Sword", "Good", 3, 11);
		Weapon greatSword = new Weapon(9, "Sword", "Great", 4, 14);
		Weapon epicSword = new Weapon(11, "Sword", "Epic", 5, 17);
		Weapon godSword = new Weapon(15, "Sword", "God-Tier", 6, 20);
		stock.put("Swords", swordStock);
		swordStock.put("" + badSword.getMinLevel(), badSword);
		swordStock.put("" + mediocreSword.getMinLevel(), mediocreSword);
		swordStock.put("" + goodSword.getMinLevel(), goodSword);
		swordStock.put("" + greatSword.getMinLevel(), greatSword);
		swordStock.put("" + epicSword.getMinLevel(), epicSword);
		swordStock.put("" + godSword.getMinLevel(), godSword);
	}

	public void open(PlayerBug masterBug) {
		System.out.println("Welcome to Esau's Emporium! \nHere is what we have for sale!");

		ArrayList<Object> mySwords = masterBug.getInventory().getInventoryArray();
		int maxLevel = 1;
		for(Object mySword : mySwords) {
			maxLevel = ((Weapon)(mySword)).getMinLevel();
		}

		for(int i = maxLevel; i <= masterBug.getLevel(); i++) {
			String quality = swordStock.get("" + i).getQuality();
			String type = swordStock.get("" + i).getType();
			if(!checkInventory(masterBug.getInventory(), quality, type)) {
				printShop(swordStock.get("" + i));
			}
		}
		Scanner keys = new Scanner(System.in);
		int minLevel = keys.nextInt();
		buy(swordStock.get(""+minLevel), masterBug);
	}

	private boolean checkInventory(Inventory myInventory, String shopType, String shopQuality) {
		for(Object mySword:myInventory.getInventoryArray()) {
			if(((Weapon)mySword).getType().equals(shopType) && ((Weapon)mySword).getQuality().equals(shopQuality)) {
				return true;
			}
		}
		return false;
	}

	public void printShop(Weapon shopSword) {
		System.out.println("Press (" + shopSword.getMinLevel()+") for " + shopSword.getQuality() + "\t\t" + shopSword.getType() + "\t\t" + shopSword.getStrength());
	}

	private void buy(Weapon weapon, PlayerBug masterBug) {
		if(masterBug.getGold() >= weapon.getCost()) {
			masterBug.getInventory().addToInventory(weapon);
			masterBug.setGold(masterBug.getGold() - weapon.getCost());
		} else {
			System.out.println("You can not afford this item.");
		}
	}
}
