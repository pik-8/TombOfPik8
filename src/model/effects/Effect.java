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
    private float[] options;
    // If false, effect is applied before the character starts its turn.
    private boolean instantApply;
    private boolean relevance;

    private void init(String name, String desc, int dur) {
    	this.name = name;
        this.description = desc;
        this.duration = dur;
    }
    
    protected Effect(String name, String description, int duration) {
    	init(name, description, duration);
    	this.relevance = true;
    }

    protected Effect(String name, String description, int duration, boolean isRelevant) {
    	init(name, description, duration);
        this.relevance = isRelevant;
    }

    protected Effect(String name, String description, int duration, float[] options) {
    	init(name, description, duration);
        this.options = options;
        this.relevance = true;
    }
    
    protected Effect(String name, String description, int duration, float[] options, boolean isRelevant) {
    	init(name, description, duration);
        this.options = options;
        this.relevance = isRelevant;
    }
        	
    public abstract void applyEffect (Character cha);

    public abstract void applyEffect (Square square);
    
    // public abstract void applyEffect (Equipment equip);

    protected void checkDurationAndRelevanze () {
        if (this.duration == 0) {
            this.relevance = false;
        }
    }

    /**
     * This method can extend the option array with zeros if it does not have enough values for the specified effect.
     * @param assumedLength The length (amount of values) the option array needs to have.
     */
    protected void fillOptions(int assumedLength) {
    	options = lengthenArray(options, assumedLength);
    }
    
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

    public float[] getOptions() {
		return options;
	}
    
    protected float getOneOption(int index) {
    	return options[index];
    }
    
    protected void setOneOption (int index, float value) {
    	this.options[index] = value;
    }

	public boolean isInstantApply() {
		return instantApply;
	}

	public void setInstantApply(boolean instantApply) {
		this.instantApply = instantApply;
	}

	public boolean isRelevant() {
        return relevance;
    }

    protected void setDuration(int duration) {
        this.duration = duration;
    }

    protected void setRelevance(boolean relevance) {
        this.relevance = relevance;
    }
}
