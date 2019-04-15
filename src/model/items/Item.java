package model.items;

import java.util.ArrayList;

import model.effects.Effect;

public abstract class Item {
	protected String name;
	protected String description;
	protected ArrayList<Effect> effects;
	
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
}
