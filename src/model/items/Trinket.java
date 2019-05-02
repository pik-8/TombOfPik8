package model.items;

import java.util.ArrayList;

import model.characters.PrimeStats;
import model.characters.SecondaryStats;
import model.effects.Effect;

/**
 * Trinket adds PrimaryStats to Equipment. 
 * Trinkets can be used for deeper stat manipulation.
 * 
 * @author Frederick Hastedt
 *
 */
public class Trinket extends Equipment {

	private PrimeStats primeStats;
	
	public Trinket(String name, String description, SecondaryStats secondaryStats, Rarity rarity, ArrayList<Effect> effects, PrimeStats primeStats) {
		super(name, description, secondaryStats, rarity, effects);
		this.primeStats = primeStats;
	}

	public Trinket(String name, String description, SecondaryStats secondaryStats, Rarity rarity, Effect effect, PrimeStats primeStats) {
		super(name, description, secondaryStats, rarity, effect);
		this.primeStats = primeStats;
	}

	public Trinket(String name, String description, SecondaryStats secondaryStats, Rarity rarity, PrimeStats primeStats) {
		super(name, description, secondaryStats, rarity);
		this.primeStats = primeStats;
	}
	
	public PrimeStats getPrimeStats() {
		return primeStats;
	}
	
	public void setPrimeStats(PrimeStats prime) {
		this.primeStats = prime;
	}

}
