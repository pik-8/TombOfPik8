package model.effects;

import model.characters.Character;
import model.dungeon.Square;
import model.items.Equipment;

/**
 * Roots the target in place for a given amount of time, making it unable to move. 
 * It still retains its ability to attack.
 * 
 * @author Frederick Hastedt
 *
 */
public class RootEffect extends Effect {

	/**
	 * Creates a new RootEffect.
	 * 
	 * @param name: Name of the effect.
	 * @param description: Description of the effect.
	 * @param duration: How long the target is rooted for.
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
		//TODO
	}

	@Override
	public void applyEffect(Equipment equipment) {
		//TODO
	}
}
