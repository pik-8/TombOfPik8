package model.items;

import java.util.ArrayList;

import model.characters.SecondaryStats;
import model.effects.Effect;
import model.effects.IEffectable;

/**
 * Abstract class for equipable items: Armor, Weapons and Trinkets.
 * Adds SecondaryStats which will be added to a Character's stats when equipped.

 * @author Frederick Hastedt
 */
public abstract class Equipment extends Item implements IEffectable {
	
	protected SecondaryStats secondaryStats;
	
	private void init(String name, String description, SecondaryStats secondaryStats, Rarity rarity) {
		this.name = name;
		this.description = description;
		this.secondaryStats = secondaryStats;
		this.rarity = rarity;
	}
	
	public Equipment(String name, String description, SecondaryStats secondaryStats, Rarity rarity) {
		init(name, description, secondaryStats, rarity);
		this.effects = new ArrayList<Effect>();
	}
	
	public Equipment(String name, String description, SecondaryStats secondaryStats, Rarity rarity, ArrayList<Effect> effects) {
		init(name, description, secondaryStats, rarity);
		this.effects = effects;
	}
	
	public Equipment(String name, String description, SecondaryStats secondaryStats, Rarity rarity, Effect effect) {
		init(name, description, secondaryStats, rarity);
		this.effects = new ArrayList<Effect>();
		this.effects.add(effect);
	}
	
	public SecondaryStats getSecondaryStats() {
		return secondaryStats;
	}

	public void setSecondaryStats(SecondaryStats secondaryStats) {
		this.secondaryStats = secondaryStats;
	}
	
	@Override
	public void effect(Effect e) {
		e.apply(this);
	}
	
	@Override
	public void uneffect(Effect e) {
		e.deApply(this);
	}

	@Override
	public void reeffect(Effect e) {
		e.reApply(this);
	}
}
