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

    private float flatSlowDown;
    private float percentOfSpeedSlowDown;
    private int deltaPercentSpeed;
    private boolean alreadyApplied;

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
        init(flatSlowDown, percentOfSpeedSlowDown);
}


    public SlowDownEffect(String name, String description, int duration, float flatSlowDown,
                          float percentOfSpeedSlowDown) {
        super(name, description, duration);
        init(flatSlowDown, percentOfSpeedSlowDown);
    }
    
    private void init(float flatSlowDown, float percentOfSpeedSlowDown){
    	this.flatSlowDown = flatSlowDown;
    	this.percentOfSpeedSlowDown = percentOfSpeedSlowDown;
    	alreadyApplied = false;
    }

    @Override
    public void apply(Character character) {
		if(!alreadyApplied) {
			character.getSecondaryStats().setSpeed(character.getSecondaryStats().getSpeed() - Math.round(flatSlowDown));
			deltaPercentSpeed = Math.round(character.getSecondaryStats().getSpeed() * (percentOfSpeedSlowDown/100));
			character.getSecondaryStats().setSpeed(character.getSecondaryStats().getSpeed() - deltaPercentSpeed);
			alreadyApplied = true;
		}
    }
    
    @Override
    public void deApply(Character character) {
    	character.getSecondaryStats().setSpeed(character.getSecondaryStats().getSpeed() + deltaPercentSpeed);
    	character.getSecondaryStats().setSpeed(character.getSecondaryStats().getSpeed() + Math.round(flatSlowDown));
    }
    
    @Override
    public void reApply(Character character) {
    	character.getSecondaryStats().setSpeed(character.getSecondaryStats().getSpeed() - Math.round(flatSlowDown));
		deltaPercentSpeed = Math.round(character.getSecondaryStats().getSpeed() * (percentOfSpeedSlowDown/100));
		character.getSecondaryStats().setSpeed(character.getSecondaryStats().getSpeed() - deltaPercentSpeed);
    }
    
    @Override
    public void apply(Square square) {
        square.setEffect(new SlowDownEffect(getName(), getDescription(), getDuration(), isInstantApply(), 
        		this.flatSlowDown,
                this.percentOfSpeedSlowDown));
    }

    @Override
    public void apply(Equipment equipment) {
    }
}
