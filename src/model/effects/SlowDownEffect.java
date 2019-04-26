package model.effects;

import model.dungeon.Square;
import model.items.Equipment;
import model.other.Character;
import model.other.SecondaryStats;


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
    public void applyEffect(Character cha) {
        //TODO implement the addition of speed.
        setDuration(getDuration() -1);
    }

    @Override
    public void applyEffect(Square square) {
        square.setEffect(new SlowDownEffect(getName(), getDescription(), getDuration(), isInstantApply(), this.flatSlowDown,
                this.percentOfSpeedSlowDown));
    }

    @Override
    public void applyEffect(Equipment equip) {}
}
