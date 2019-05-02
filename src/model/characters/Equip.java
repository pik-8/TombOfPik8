package model.characters;

import model.items.Armor;
import model.items.Equipment;
import model.items.Trinket;
import model.items.Weapon;


public class Equip {

	private Weapon weapon;
	private Armor headgear;
	private Armor chestplate;
	private Armor legwear;
	private Trinket[] trinkets;
	private int currentTrinketSlot;
	
	public Equip() {
		weapon = null;
		headgear = null;
		chestplate = null;
		legwear = null;
		trinkets = new Trinket[2];
		currentTrinketSlot = 0;
	}
	
	public Equipment equip(Weapon piece) {
		Weapon tmp = this.weapon;
		this.weapon = piece;
		return tmp;
	}

	public Equipment equip(Armor piece) {
		Armor tmp;
		switch(piece.getSlot()) {
		case HEAD:
			tmp = this.headgear;
			this.headgear = piece;
			return tmp;
		case CHEST:
			tmp = this.chestplate;
			this.chestplate = piece;
			return tmp;
		case LEGS:
			tmp = this.legwear;
			this.legwear = piece;
			return tmp;
		default:
			return null;
		}
	}
	
	public Equipment equip(Trinket trinket) {
		Trinket tmp = trinkets[currentTrinketSlot];
		this.trinkets[currentTrinketSlot] = trinket;
		currentTrinketSlot ^= 1;
		return tmp;
	}
	
}
