package model.items;

import java.util.ArrayList;

import model.effects.Effect;
import model.other.PrimeStats;
import model.other.SecondaryStats;

public class Trinkets extends Equipment {

	private PrimeStats primeStats;
	

	public Trinkets(String name, String description, SecondaryStats secStats, PrimeStats primeStats, ArrayList<Effect> effects) {
		super(name, description, secStats, effects);
		this.primeStats = primeStats;
	}

	public Trinkets(String name, String description, SecondaryStats secStats, PrimeStats primeStats, Effect effect) {
		super(name, description, secStats, effect);
		this.primeStats = primeStats;
	}

	public Trinkets(String name, String description, SecondaryStats secStats, PrimeStats primeStats) {
		super(name, description, secStats);
		this.primeStats = primeStats;
	}
	
	public PrimeStats getPrimeStats() {
		return primeStats;
	}

}
