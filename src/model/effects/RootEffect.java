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

	private static int originalStamina;
	
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
	public void apply(Character character) {
		originalStamina = character.getSecondaryStats().getStamina();
		character.getSecondaryStats().setStamina(0);
	}

	@Override
	public void apply(Square square) {
		//TODO
	}

	@Override
	public void apply(Equipment equipment) {
		//TODO
	}

	@Override
	public void deApply(Character character) {
		character.getSecondaryStats().setStamina(originalStamina);
	}
}
