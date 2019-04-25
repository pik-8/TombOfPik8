package model.effects;

import model.dungeon.Square;
import model.other.Character;
import model.other.SecondaryStats;

/**
 * 
 * @author Frederick Hastedt
 *
 * A standard healing effect with multiple options for the healing amount. When applied to a square it will give the square a healing effect.
 */
public class HealingEffect extends Effect{

	/**
	 * 
	 * @param name: The name of this effect.
	 * @param description: The description of this effect.
	 * @param duration: The duration of this effect. Can be used with lower healing values for a regeneration effect.
	 * @param options: {flat_heal, %_max_health_heal, %_missing_health_heal, %_current_health_heal} 
	 * Missing option values will be filled with zeros.
	 * 
	 * flat_heal: 
	 * %_max_health_heal: 
	 * %_missing_health_heal: 
	 * %_current_health_heal: 
	 */
	public HealingEffect(String name, String description, int duration, float[] options) {
		super(name, description, duration, options);
		fillOptions(4);
	}

	/**
	 * Returns a default HealingEffect that restores 50hp once.
	 */
	public HealingEffect() {
		super("Healing Effect", "you get healed", 1, new float[]{50.0f, 0, 0, 0});
	}

	@Override
	public void applyEffect(Character cha) {
		SecondaryStats stats = cha.getSecondaryStats();
		try {
			stats.addHp((int)getOptions()[0]);
			stats.addHp((int)(getOptions()[1]/100 * stats.getMax_Hp()));
			stats.addHp((int)(getOptions()[2]/100 * (stats.getMax_Hp() - stats.getHp())));
			stats.addHp((int)(getOptions()[3]/100 * stats.getHp()));			
		} catch(IllegalArgumentException e) {
			setRelevance(false);
		}
	}

	@Override
	public void applyEffect(Square square) {
		square.setEffect(new HealingEffect(getName(), getDescription(), getDuration(), getOptions()));
	}

}
