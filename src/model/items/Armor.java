package model.items;

import java.util.ArrayList;

import model.characters.SecondaryStats;
import model.effects.Effect;


/**
 * 
 * @author Frederick Hastedt
 *
 * Armor is created from this class. Armor, in contrast to Weapon and Trinket, has a slot in which it will be equipped.
 */
public class Armor extends Equipment {

	private ArmorSlot slot;
	
	public Armor(String name, String description, SecondaryStats secondaryStats, Rarity rarity, ArmorSlot slot, ArrayList<Effect> effects) {
		super(name, description, secondaryStats, rarity, effects);
		this.slot = slot;
	}

	public Armor(String name, String description, SecondaryStats secondaryStats, Rarity rarity, ArmorSlot slot, Effect effect) {
		super(name, description, secondaryStats, rarity, effect);
		this.slot = slot;
	}

	public Armor(String name, String description, SecondaryStats secondaryStats, Rarity rarity, ArmorSlot slot) {
		super(name, description, secondaryStats, rarity);
		this.slot = slot;
	}
	
	public ArmorSlot getSlot() {
		return slot;
	}
	
}
