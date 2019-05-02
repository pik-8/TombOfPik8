package model.effects;

import model.characters.Character;
import model.dungeon.Square;
import model.items.Equipment;

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
	}

	@Override
	public void applyEffect(Character character) {
		character.getSecondaryStats().setStamina(0);
	}

	@Override
	public void applyEffect(Square square) {

	}

	@Override
	public void applyEffect(Equipment equipment) {}
}
