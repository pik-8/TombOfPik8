package model.items;

import java.util.ArrayList;

import model.characters.SecondaryStats;
import model.effects.Effect;

/**
 * Weapons are created from this class. Weapons have secondary stats, like attack and magic attack.
 * They also have Effects which could for example be enchantments, as well as on-hit-effects, which are applied
 * when a character is hit with this weapon.
 * 
 * @author Frederick Hastedt
 *
 */
public class Weapon extends Equipment {

	protected ArrayList<Effect> onHitEffects;
	
	public ArrayList<Effect> getOnHitEffects() {
		return onHitEffects;
	}

	public void setOnHitEffects(ArrayList<Effect> onHitEffects) {
		this.onHitEffects = onHitEffects;
	}

	/**
	 * Constructor that takes two ArrayLists for effects and onHitEffects
	 * @param name
	 * @param description
	 * @param secondaryStats This weapon's stats.
	 * @param effects Effects that are applied to this weapon.
	 * @param onHitEffects Effects that this weapon applies.
	 */
	public Weapon(String name, String description, SecondaryStats secondaryStats, Rarity rarity, ArrayList<Effect> effects, ArrayList<Effect> onHitEffects) {
		super(name, description, secondaryStats, rarity, effects);
		this.onHitEffects = onHitEffects;
	}

	/**
	 * Constructor that takes two single Effect objects for effects and onHitEffects.
	 * @param name
	 * @param description
	 * @param secondaryStats This weapon's stats.
	 * @param effect Effect that is applied to this weapon.
	 * @param onHitEffect Effect that this weapon applies.
	 */
	public Weapon(String name, String description, SecondaryStats secondaryStats, Rarity rarity, Effect effect, Effect onHitEffect) {
		super(name, description, secondaryStats, rarity, effect);
		onHitEffects = new ArrayList<Effect>();
		this.onHitEffects.add(onHitEffect);
	}
	
	/**
	 * Constructor for a weapon without effects.
	 * @param name
	 * @param description
	 * @param secondaryStats This weapon's stats.
	 */
	public Weapon(String name, String description, SecondaryStats secondaryStats, Rarity rarity) {
		super(name, description, secondaryStats, rarity);
		onHitEffects = new ArrayList<Effect>();
	}
	
}