package model.effects;

import model.characters.Character;
import model.characters.SecondaryStats;
import model.dungeon.Square;
import model.items.Equipment;


/**
 * An Effect-Class that contains every possible slow-down effect.
 *
 * @author Hagen
 */
public class SlowDownEffect extends Effect {

    private final float flatSlowDown;
    private final float percentOfSpeedSlowDown;

    /**
     *
     * @param name
     * @param description
     * @param duration: How often the affect can be applied.
     * @param instantApply: Determines if the effect should be applied during an attack or at the beginning of
     *                    the turn of a character.
     * @param flatSlowDown: A fixed amount of speed that will be subtracted from the stats off a character.
     * @param percentOfSpeedSlowDown: Subtracts a percentage off the speed of a character.
     *                                50 = 50%.
     * The slowdown values can be negative, in this case they will increase the speed instead.
     */
    public SlowDownEffect(String name, String description, int duration, boolean instantApply, float flatSlowDown,
                        float percentOfSpeedSlowDown) {
        super(name, description, duration, instantApply);
        this.flatSlowDown = flatSlowDown;
        this.percentOfSpeedSlowDown = percentOfSpeedSlowDown;
    }


    public SlowDownEffect(String name, String description, int duration, float flatSlowDown,
                          float percentOfSpeedSlowDown) {
        super(name, description, duration);
        this.flatSlowDown = flatSlowDown;
        this.percentOfSpeedSlowDown = percentOfSpeedSlowDown;
    }

    @Override
    public void applyEffect(Character character) {
    	character.getSecondaryStats().setSpeed(character.getSecondaryStats().getSpeed() - Math.round(flatSlowDown));
    	character.getSecondaryStats().setSpeed(Math.round(character.getSecondaryStats().getSpeed() * (1 - percentOfSpeedSlowDown/100)));
    }

    @Override
    public void applyEffect(Square square) {
        square.setEffect(new SlowDownEffect(getName(), getDescription(), getDuration(), isInstantApply(), 
        		this.flatSlowDown,
                this.percentOfSpeedSlowDown));
    }

    @Override
    public void applyEffect(Equipment equipment) {}
}
