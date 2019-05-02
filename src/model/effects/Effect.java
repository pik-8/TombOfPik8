package model.effects;

import model.characters.Character;
import model.dungeon.Square;
import model.items.Equipment;


/**
 * The class to give Characters and Squares an Effect, that will affect the battle.
 *
 * An object contains a name, a description and a duration, with the last one can not be alternated after
 * initialisation and an instance can not be created directly from another class, that is outside the Effect-hierarchy.
 *
 * It also contains a applyEffect-methode, that can alter the behaviour of an Character or Square, depending of
 * the specific implementation of an instance.
 *
 * To get an instance of this class please visit the EffectGiver-Class.
 *
 * @author Hagen
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

        	
    public abstract void applyEffect (Character character);

    public abstract void applyEffect (Square square);
    
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

    protected void setDuration(int duration) {
        this.duration = duration;
    }
    
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
