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

	/**
	 * Von Hagen
	 */
	public HealingEffect (String name, String description, int duration, EffectType type, int value) {
		super(name, description, duration, new float[4]);
		setOption(type,value);
	}

	private void setOption (EffectType type, int value) {
		switch (type) {
			case FLAT_HEAL:
				setOneOption(0, value);
			case MAX_HEALTH_HEAL:
				setOneOption(1, value);
			case MISSING_HEALTH_HEAL:
				setOneOption(2, value);
			case CURRENT_HEALTH_HEAL:
				setOneOption(3, value);
		}
	}

	private float getOneOption (EffectType type) {
		switch (type) {
			case FLAT_HEAL:
				return getOptions()[0];
			case MAX_HEALTH_HEAL:
				return getOptions()[1];
			case MISSING_HEALTH_HEAL:
				return getOptions()[2];
			case CURRENT_HEALTH_HEAL:
				return getOptions()[3];
			default:
				return 0;
		}
	}


	/**
	 * von Hagen
	 *
	 * @param cha
	 * @param Test
	 */
	public void applyEffect(Character cha, int Test) {
		SecondaryStats stats = cha.getSecondaryStats();
		try {
			stats.heal((int) getOneOption(EffectType.FLAT_HEAL));
			stats.heal((int) (getOneOption(EffectType.MAX_HEALTH_HEAL)/100 * stats.getMax_Hp()));
			stats.heal((int) (getOneOption(EffectType.MISSING_HEALTH_HEAL)/100 * (stats.getMax_Hp() - stats.getHp())));
			stats.heal((int) (getOneOption(EffectType.CURRENT_HEALTH_HEAL)/100 * stats.getHp()));
		} catch(IllegalArgumentException e) {
			setRelevanze(false);
		}
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
