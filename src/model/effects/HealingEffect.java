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
	 * @param name The name of this effect.
	 * @param description The description of this effect.
	 * @param duration The duration of this effect. Can be used with lower healing values for a regeneration effect.
	 * @param options {flat heal, % max health heal, % missing health heal, % current health heal} 
	 * Missing option values will be filled with zeros.
	 */
	public HealingEffect(String name, String description, int duration, float[] options) {
		super(name, description, duration, options);
		fillOptions(4);
	}

	@Override
	public void applyEffect(Character cha) {
		SecondaryStats stats = cha.getSecondaryStats();
		try {
			stats.heal((int)getOptions()[0]);
			stats.heal((int)(getOptions()[1]/100 * stats.getMax_Hp()));
			stats.heal((int)(getOptions()[2]/100 * (stats.getMax_Hp() - stats.getHp())));
			stats.heal((int)(getOptions()[3]/100 * stats.getHp()));			
		} catch(IllegalArgumentException e) {
			setRelevanze(false);
		}
	}

	@Override
	public void applyEffect(Square square) {
		square.setEffect(new HealingEffect(getName(), getDescription(), getDuration(), getOptions()));
	}

}
