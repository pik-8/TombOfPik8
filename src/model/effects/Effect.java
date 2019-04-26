package model.effects;

import model.dungeon.Square;
import model.items.Equipment;
import model.other.Character;


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

    private void init(String name, String desc, int dur, boolean instantApply) {
    	this.name = name;
        this.description = desc;
        this.duration = dur;
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

        	
    public abstract void applyEffect (Character cha);

    public abstract void applyEffect (Square square);
    
    public abstract void applyEffect (Equipment equip);
    
    /**
     * This method can extend an array to a specified length with zeros.
     * @param array The array to extend.
     * @param toLength The length to extend to.
     * @return The extended array.
     */
    protected float[] lengthenArray(float[] array, int toLength) {
    	if(array.length < toLength) {
			float[] tmp = new float[toLength];
			for(int i = 0; i < toLength; i++) {
				if(i < array.length)
					tmp[i] = array[i];
				else
					tmp[i] = 0;
			}
			array = tmp;			
		}
    	return array;
    }

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
}
