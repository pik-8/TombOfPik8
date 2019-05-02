package model.items;

import java.util.ArrayList;

import model.effects.Effect;

/**
 * There are three different kinds of items in this program: Weapons, Armor and Consumables. 
 * This is the root class for all of them. Since an Item should not be created as just an Item, this class is abstract.
 * An Item has a name, a description (to be used for a tooltip), effects and a rarity.
 * 
 * @author Frederick Hastedt
 *
 */
public abstract class Item {
	protected String name;
	protected String description;
	protected ArrayList<Effect> effects;
	protected Rarity rarity;
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public ArrayList<Effect> getEffects() {
		return effects;
	}
	
	public void addEffect(Effect effect) {
		effects.add(effect);
	}
	
	public void removeEffect(Effect effect) {
		effects.remove(effect);
	}
	
	public void removeAllEffects() {
		effects.clear();
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
}
