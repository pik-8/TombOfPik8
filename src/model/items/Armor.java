package model.items;

import java.util.ArrayList;

import model.effects.Effect;
import model.other.SecondaryStats;

public class Armor extends Equipment {
	
	public Armor(String name, String description, SecondaryStats secStats, ArrayList<Effect> effects) {
		super(name, description, secStats, effects);
	}

	public Armor(String name, String description, SecondaryStats secStats, Effect effect) {
		super(name, description, secStats, effect);
	}

	public Armor(String name, String description, SecondaryStats secStats) {
		super(name, description, secStats);
	}
}
