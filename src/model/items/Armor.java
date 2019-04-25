package model.items;

import java.util.ArrayList;

import model.effects.Effect;
import model.other.SecondaryStats;


/**
 * 
 * @author Frederick Hastedt
 *
 * Armor is created from this class. Armor currently has the same content as Equipment,
 * it was created to offer further design space in the future.
 */
public class Armor extends Equipment {

	public Armor(String name, String description, SecondaryStats secStats, Rarity rarity, ArrayList<Effect> effects) {
		super(name, description, secStats, rarity, effects);
	}

	public Armor(String name, String description, SecondaryStats secStats, Rarity rarity, Effect effect) {
		super(name, description, secStats, rarity, effect);
	}

	public Armor(String name, String description, SecondaryStats secStats, Rarity rarity) {
		super(name, description, secStats, rarity);
	}
	
}
