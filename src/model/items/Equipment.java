package model.items;

import java.util.ArrayList;

import model.effects.Effect;
import model.other.SecondaryStats;

/**
 * 
 * @author Frederick Hastedt
 * Class for equipable items.
 */
public class Equipment extends Item {
	
	protected SecondaryStats secStats;

	private void init(String name, String description, SecondaryStats secStats) {
		this.name = name;
		this.description = description;
		this.secStats = secStats;
	}
	
	public Equipment(String name, String description, SecondaryStats secStats) {
		init(name, description, secStats);
		this.effects = new ArrayList<Effect>();
	}
	
	public Equipment(String name, String description, SecondaryStats secStats, ArrayList<Effect> effects) {
		init(name, description, secStats);
		this.effects = effects;
	}
	
	public Equipment(String name, String description, SecondaryStats secStats, Effect effect) {
		init(name, description, secStats);
		this.effects = new ArrayList<Effect>();
		this.effects.add(effect);
	}
	
	public SecondaryStats getSecStats() {
		return secStats;
	}
}
