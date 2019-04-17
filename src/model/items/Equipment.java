package model.items;

import java.util.ArrayList;

import model.effects.Effect;
import model.other.SecondaryStats;

/**
 * 
 * @author Frederick Hastedt
 * Abstract lass for equipable items: Armor, Weapons and Trinkets.
 * Adds secondary stats to Items.
 */
public abstract class Equipment extends Item {
	
	protected SecondaryStats secStats;
	
	private void init(String name, String description, SecondaryStats secStats, Rarity rarity) {
		this.name = name;
		this.description = description;
		this.secStats = secStats;
		this.rarity = rarity;
	}
	
	public Equipment(String name, String description, SecondaryStats secStats, Rarity rarity) {
		init(name, description, secStats, rarity);
		this.effects = new ArrayList<Effect>();
	}
	
	public Equipment(String name, String description, SecondaryStats secStats, Rarity rarity, ArrayList<Effect> effects) {
		init(name, description, secStats, rarity);
		this.effects = effects;
	}
	
	public Equipment(String name, String description, SecondaryStats secStats, Rarity rarity, Effect effect) {
		init(name, description, secStats, rarity);
		this.effects = new ArrayList<Effect>();
		this.effects.add(effect);
	}
	
	public SecondaryStats getSecStats() {
		return secStats;
	}

	public void setSecStats(SecondaryStats secStats) {
		this.secStats = secStats;
	}
}
