package model.items;

import java.util.ArrayList;

import model.effects.Effect;

/**
 * 
 * @author Frederick Hastedt
 * Class for consumable items.
 */
public class Consumable extends Item {
	
	private void init(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Consumable(String name, String description) {
		init(name, description);
		this.effects = new ArrayList<Effect>();
	}
	
	public Consumable(String name, String description, ArrayList<Effect> effects) {
		init(name, description);
		this.effects = effects;
	}
	
	public Consumable(String name, String description, Effect effect) {
		init(name, description);
		this.effects = new ArrayList<Effect>();
		this.effects.add(effect);
	}
}
