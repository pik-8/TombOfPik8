package model.effects;

import model.dungeon.Square;
import model.other.Character;

/**
 * 
 * @author Frederick Hastedt
 *
 * Roots the target in place for a given amount of time. It can still attack.
 */
public class RootEffect extends Effect {

	/**
	 * 
	 * @param name Name of the effect.
	 * @param description Description of the effect.
	 * @param duration How long the target is rooted for.
	 */
	public RootEffect(String name, String description, int duration) {
		super(name, description, duration);
		this.setInstantApply(true);
	}


	@Override
	public void applyEffect(Character cha) {
		cha.getSecondaryStats().setSpeed(0);
	}

	@Override
	public void applyEffect(Square square) {

	}

}
