package model.effects;

import model.characters.Character;
import model.characters.SecondaryStats;
import model.dungeon.Square;
import model.items.Equipment;

/**
 * 
 * @author Frederick Hastedt
 *
 * A standard healing effect with multiple options for the healing amount. When applied to a square it will give the square a healing effect.
 */
public class HealingEffect extends Effect{

	private final float flatHeal;
	private final float percentOfMaxHealthHeal;
	private final float percentOfMissingHealthHeal;
	private final float percentOfCurrentHealthHeal;


	/**
	 * 
	 * @param name: The name of this effect.
	 * @param description: The description of this effect.
	 * @param duration: The duration of this effect. Can be used with lower healing values for a regeneration effect.
	 * Missing option values will be filled with zeros.
	 * 
	 * flat_heal: 
	 * %_max_health_heal: 
	 * %_missing_health_heal: 
	 * %_current_health_heal: 
	 */
	public HealingEffect(String name, String description, int duration, boolean instantApply, float flatHeal, float percentOfMaxHealthHeal, float percentOfMissingHealthHeal, float percentOfCurrentHealthHeal) {
		super(name, description, duration, instantApply);
		this.flatHeal = flatHeal;
		this.percentOfMaxHealthHeal = percentOfMaxHealthHeal;
		this.percentOfMissingHealthHeal = percentOfMissingHealthHeal;
		this.percentOfCurrentHealthHeal = percentOfCurrentHealthHeal;
	}


	public HealingEffect(String name, String description, int duration, float flatHeal, float percentOfMaxHealthHeal, float percentOfMissingHealthHeal, float percentOfCurrentHealthHeal) {
		super(name, description, duration);
		this.flatHeal = flatHeal;
		this.percentOfMaxHealthHeal = percentOfMaxHealthHeal;
		this.percentOfMissingHealthHeal = percentOfMissingHealthHeal;
		this.percentOfCurrentHealthHeal = percentOfCurrentHealthHeal;
	}

	/**
	 * Returns a default HealingEffect that restores 50hp once.
	 */
	public HealingEffect() {
		super("Healing Effect", "you get healed", 1);
		this.flatHeal = 50f;
		this.percentOfMaxHealthHeal = 0f;
		this.percentOfMissingHealthHeal = 0f;
		this.percentOfCurrentHealthHeal = 0f;
	}

	@Override
	public void applyEffect(Character cha) {
		SecondaryStats stats = cha.getSecondaryStats();
		stats.addHp((int) this.flatHeal);
		stats.addHp((int) this.percentOfMaxHealthHeal/100 * stats.getMax_Hp());
		stats.addHp((int) this.percentOfMissingHealthHeal/100 * (stats.getMax_Hp() - stats.getHp()));
		stats.addHp((int) this.percentOfCurrentHealthHeal/100 * stats.getHp());
	}

	@Override
	public void applyEffect(Square square) {
		try {
			square.setEffect((HealingEffect) this.clone());
		} catch (Exception e) {
			square.setEffect(new HealingEffect(getName(), getDescription(), getDuration(), isInstantApply(), this.flatHeal, this.percentOfMaxHealthHeal, this.percentOfMissingHealthHeal, this.percentOfCurrentHealthHeal));
		}

	}

	@Override
	public void applyEffect(Equipment equip) {}
}
