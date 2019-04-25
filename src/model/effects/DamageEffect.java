package model.effects;

import model.dungeon.Square;
import model.other.Character;
import model.other.SecondaryStats;

public class DamageEffect extends Effect {

	/**
	 * 
	 * @param name The name of this effect.
	 * @param description The description of this effect.
	 * @param duration The duration of this effect. Can be used with lower damage values for a damage over time effect.
	 * @param options damage: {flat, % max health, % missing health, % current health} 
	 * Missing option values will be filled with zeros.
	 */
	public DamageEffect(String name, String description, int duration, float[] options) {
		super(name, description, duration, options);
		fillOptions(4);
	}

	@Override
	public void applyEffect(Character cha) {
		SecondaryStats stats = cha.getSecondaryStats();
		// The *-1 makes the function subtract the given hp instead of adding it.
		stats.addHp((int)(getOptions()[0] * -1));
		stats.addHp((int)(getOptions()[1]/100 * stats.getMax_Hp() * -1));
		stats.addHp((int)(getOptions()[2]/100 * (stats.getMax_Hp() - stats.getHp()) * -1));
		stats.addHp((int)(getOptions()[3]/100 * stats.getHp() * -1));			

	}

	@Override
	public void applyEffect(Square square) {
		square.setEffect(new DamageEffect(getName(), getDescription(), getDuration(), getOptions()));

	}

}
