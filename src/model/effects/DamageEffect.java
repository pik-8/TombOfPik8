package model.effects;

import model.characters.Character;
import model.characters.SecondaryStats;
import model.dungeon.Square;
import model.items.Equipment;


/**
 * 
 * DamageEffect extends Effect and is supposed to be used for any non-basic way of applying damage.
 * This can for example be a damage-over-time effect or an execution effect.
 * 
 * When used on a character, it will effect the character's hp.
 * When used on a square, it will add a copy of itself to the square.
 * When used on a piece of equipment TODO
 * 
 * @author Hagen and Frederick Hastedt
 *
 */
public class DamageEffect extends Effect {


	private final float flatDamage;
	private final float percentOfMaxHealthDamage;
	private final float percentOfMissingHealthDamage;
	private final float percentOfCurrentHealthDamage;

	/**
	 * Creates a new DamageEffect.
	 * 
	 * @param name
	 * @param description
	 * @param duration
	 * @param instantApply If true, this effect will be applied right away, but only once.
	 * 
	 * @param flatDamage An amount of health to be subtracted from a character's hp directly.
	 * @param percentOfMaxHealthDamage A percentile of the maximum health of a character to subtract from its hp. 
	 * @param percentOfMissingHealthDamage A percentile of the missing health of a character to subtract from its hp.
	 * @param percentOfCurrentHealthDamage A percentile of the current health of a character to subtract from its hp.
	 */
	public DamageEffect(String name, String description, int duration, boolean instantApply, float flatDamage,
						float percentOfMaxHealthDamage, float percentOfMissingHealthDamage,
						float percentOfCurrentHealthDamage) {
		super(name, description, duration, instantApply);
		this.flatDamage = flatDamage;
		this.percentOfMaxHealthDamage = percentOfMaxHealthDamage;
		this.percentOfMissingHealthDamage = percentOfMissingHealthDamage;
		this.percentOfCurrentHealthDamage = percentOfCurrentHealthDamage;
	}

	/**
	 * Creates a new DamageEffect.
	 * InstantApply will be set to false.
	 * 
	 * @param name
	 * @param description
	 * @param duration
	 * 
	 * @param flatDamage An amount of health to be subtracted from a character's hp directly.
	 * @param percentOfMaxHealthDamage A percentile of the maximum health of a character to subtract from its hp. 
	 * @param percentOfMissingHealthDamage A percentile of the missing health of a character to subtract from its hp.
	 * @param percentOfCurrentHealthDamage A percentile of the current health of a character to subtract from its hp.
	 */
	public DamageEffect(String name, String description, int duration, float flatDamage, float percentOfMaxHealthDamage,
						float percentOfMissingHealthDamage, float percentOfCurrentHealthDamage) {
		super(name, description, duration);
		this.flatDamage = flatDamage;
		this.percentOfMaxHealthDamage = percentOfMaxHealthDamage;
		this.percentOfMissingHealthDamage = percentOfMissingHealthDamage;
		this.percentOfCurrentHealthDamage = percentOfCurrentHealthDamage;
	}
	
	/**
	 * Creates a new DamageEffect.
	 * name and description are automatically set to default values, the duration is set to one.
	 * instantApply is set to true.
	 * flatDamage is set to 20, all other damage numbers are zero.
	 */
	public DamageEffect() {
		super("Damage", "Damage was dealt", 1, true);
		this.flatDamage = 20;
		this.percentOfMaxHealthDamage = 0;
		this.percentOfMissingHealthDamage = 0;
		this.percentOfCurrentHealthDamage = 0;
	}

	@Override
	public void applyEffect(Character character) {
		SecondaryStats stats = character.getSecondaryStats();
		// The *-1 makes the function subtract the given hp instead of adding it.
		stats.addHp((int) this.flatDamage * -1);
		stats.addHp((int) (this.percentOfMaxHealthDamage /100 * stats.getMaxHP() * -1));
		stats.addHp((int) (this.percentOfMissingHealthDamage /100 * (stats.getMaxHP() - stats.getHp()) * -1));
		stats.addHp((int) (this.percentOfCurrentHealthDamage /100 * stats.getHp() * -1));
	}

	@Override
	public void applyEffect(Square square) {
		square.setEffect(new DamageEffect(getName(), getDescription(), getDuration(), this.flatDamage,
				this.percentOfMaxHealthDamage, this.percentOfMissingHealthDamage, this.percentOfCurrentHealthDamage));
	}

	@Override
	public void applyEffect(Equipment equipment) {}
}
