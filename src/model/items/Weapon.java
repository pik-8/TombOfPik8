package model.items;

import java.util.ArrayList;

import model.effects.Effect;
import model.other.SecondaryStats;

public class Weapon extends Equipment {

	public Weapon(String name, String description, SecondaryStats secStats, ArrayList<Effect> effects) {
		super(name, description, secStats, effects);
	}

	public Weapon(String name, String description, SecondaryStats secStats, Effect effect) {
		super(name, description, secStats, effect);
	}

	public Weapon(String name, String description, SecondaryStats secStats) {
		super(name, description, secStats);
	}


}
