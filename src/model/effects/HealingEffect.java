package model.effects;

import model.characters.Character;
import model.characters.SecondaryStats;
import model.dungeon.Square;
import model.items.Equipment;

/**
 * 
 * HealingEffect extends Effect and is supposed to be used for any healing.
 * This can for example be a healing-over-time effect.
 * 
 * When used on a character, it will effect the character's hp.
 * When used on a square, it will add a copy of itself to the square.
 * When used on a piece of equipment TODO
 * 
 * @author Hagen and Frederick Hastedt
 *
 */
public class HealingEffect extends Effect{

	private final float flatHeal;
	private final float percentOfMaxHealthHeal;
	private final float percentOfMissingHealthHeal;
	private final float percentOfCurrentHealthHeal;


	/**
	 * Creates a new HealingEffect.
	 * 
	 * @param name
	 * @param description
	 * @param duration
	 * @param instantApply If true, this effect will be applied right away, but only once.
	 * 
	 * @param flatHeal An amount of health to be added to a character's hp directly.
	 * @param percentOfMaxHealthHeal A percentile of the maximum health of a character to be added to a its hp. 
	 * @param percentOfMissingHealthHeal A percentile of the missing health of a character to be added to its hp.
	 * @param percentOfCurrentHealthHeal A percentile of the current health of a character to to be added to its hp.
	 */
	public HealingEffect(String name, String description, int duration, boolean instantApply, float flatHeal, float percentOfMaxHealthHeal, float percentOfMissingHealthHeal, float percentOfCurrentHealthHeal) {
		super(name, description, duration, instantApply);
		this.flatHeal = flatHeal;
		this.percentOfMaxHealthHeal = percentOfMaxHealthHeal;
		this.percentOfMissingHealthHeal = percentOfMissingHealthHeal;
		this.percentOfCurrentHealthHeal = percentOfCurrentHealthHeal;
	}

	/**
	 * Creates a new HealingEffect.
	 * instantApply is set to false.
	 * 
	 * @param name
	 * @param description
	 * @param duration
	 * 
	 * @param flatHeal An amount of health to be added to a character's hp directly.
	 * @param percentOfMaxHealthHeal A percentile of the maximum health of a character to be added to a its hp. 
	 * @param percentOfMissingHealthHeal A percentile of the missing health of a character to be added to its hp.
	 * @param percentOfCurrentHealthHeal A percentile of the current health of a character to to be added to its hp.
	 */
	public HealingEffect(String name, String description, int duration, float flatHeal, float percentOfMaxHealthHeal, float percentOfMissingHealthHeal, float percentOfCurrentHealthHeal) {
		super(name, description, duration);
		this.flatHeal = flatHeal;
		this.percentOfMaxHealthHeal = percentOfMaxHealthHeal;
		this.percentOfMissingHealthHeal = percentOfMissingHealthHeal;
		this.percentOfCurrentHealthHeal = percentOfCurrentHealthHeal;
	}

	/**
	 * Creates a new HealingEffect.
	 * name and description are automatically set to default values, the duration is set to one.
	 * instantApply is set to true.
	 * flatDamage is set to 50, all other damage numbers are zero.
	 */
	public HealingEffect() {
		super("Healing Effect", "you get healed", 1, true);
		this.flatHeal = 50f;
		this.percentOfMaxHealthHeal = 0f;
		this.percentOfMissingHealthHeal = 0f;
		this.percentOfCurrentHealthHeal = 0f;
	}

	@Override
	public void apply(Character character) {
		SecondaryStats stats = character.getSecondaryStats();
		stats.addHp((int) this.flatHeal);
		stats.addHp((int) (this.percentOfMaxHealthHeal/100 * stats.getMaxHP()));
		stats.addHp((int) (this.percentOfMissingHealthHeal/100 * (stats.getMaxHP() - stats.getHp())));
		stats.addHp((int) (this.percentOfCurrentHealthHeal/100 * stats.getHp()));
	}

	@Override
	public void apply(Square square) {
		try {
			square.setEffect((HealingEffect) this.clone());
		} catch (Exception e) {
			square.setEffect(new HealingEffect(getName(), getDescription(), getDuration(), isInstantApply(), this.flatHeal, this.percentOfMaxHealthHeal, this.percentOfMissingHealthHeal, this.percentOfCurrentHealthHeal));
		}

	}

	@Override
	public void apply(Equipment equipment) {}
}
