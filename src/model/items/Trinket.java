package model.items;

import java.util.ArrayList;

import model.effects.Effect;
import model.other.PrimeStats;
import model.other.SecondaryStats;

public class Trinket extends Equipment {

	private PrimeStats primeStats;
	
	public Trinket(String name, String description, SecondaryStats secStats, Rarity rarity, ArrayList<Effect> effects, PrimeStats primeStats) {
		super(name, description, secStats, rarity, effects);
		this.primeStats = primeStats;
	}

	public Trinket(String name, String description, SecondaryStats secStats, Rarity rarity, Effect effect, PrimeStats primeStats) {
		super(name, description, secStats, rarity, effect);
		this.primeStats = primeStats;
	}

	public Trinket(String name, String description, SecondaryStats secStats, Rarity rarity, PrimeStats primeStats) {
		super(name, description, secStats, rarity);
		this.primeStats = primeStats;
	}
	
	public PrimeStats getPrimeStats() {
		return primeStats;
	}
	
	public void setPrimeStats(PrimeStats prime) {
		this.primeStats = prime;
	}

}