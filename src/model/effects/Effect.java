package model.effects;

import model.characters.Character;
import model.dungeon.Square;
import model.items.Equipment;


/**
 * The class to give Characters and Squares an Effect, that will affect the battle.
 *
 * An Effect contains a name, a description and a duration. The effect's duration is managed by the controller.
 * Effect is abstract as it should never be instantiated.
 *
 * It also contains applyEffect() methods, that can take effect on a given Character, Square or piece of Equipment,
 * which need to be overriden by child classes.
 *
 * @author Hagen and Frederick Hastedt
 */
public abstract class Effect {

    private String name;
    private String description;

    private int duration;

    // If false, effect is applied before the character starts its turn.
    private boolean instantApply;

    private void init(String name, String description, int duration, boolean instantApply) {
    	this.name = name;
        this.description = description;
        this.duration = duration;
        this.instantApply = instantApply;
    }


    /**
     *
     * When using this constructor the instantapply-Param will be set to false.
     *
     * @param name
     * @param description
     * @param duration: How many rounds the effect lasts. -1 for infinite.
     */
    protected Effect(String name, String description, int duration) {
    	init(name, description, duration, false);
    }

    protected Effect(String name, String description, int duration, boolean instantApply) {
        init(name, description, duration, instantApply);
    }

     /**   	
      * Applies the Effect on a given Character
      *
      * @param character
      */
    public abstract void applyEffect (model.characters.Character character);

    /**
     * Applies the Effect on a given Square
     * 
     * @param square
     */
    public abstract void applyEffect (Square square);
    
    /**
     * Applies the Effect on a given piece of Equipment
     * 
     * @param equipment
     */
    public abstract void applyEffect (Equipment equipment);

    public String getName() {
        return name;
    }

    public void setString (String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

	public boolean isInstantApply() {
		return instantApply;
	}

	public void setInstantApply(boolean instantApply) {
		this.instantApply = instantApply;
	}
    
    /**
     * Lowers the duration of the effect by one.
     */
    public void lowerDuration() {
    	duration -= 1;
    }
    
    public String toString() {
    	return "Name: " + name + 
    			"\nDescription: " + description +
    			"\nDuration: " + duration +
    			"\nisInstantApply: " + (instantApply ? "True" : "False");
    }
}
