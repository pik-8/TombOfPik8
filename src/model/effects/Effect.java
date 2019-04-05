package model.effects;

import constants.ExceptionConstants;
import model.dungeon.Square;
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
 * Has a relevant-boolean, that indicates if the Effect-Object should be considered by a controller-Object
 * Is per default true.
 *
 * Can not be directly instantiated.
 *
 * @author Hagen
 */
public abstract class Effect {

    private String name;
    private String description;

    private int duration;


    private boolean relevant;

    protected Effect(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.relevant = true;
    }

    protected Effect(String name, String description, int duration, boolean isRelevant) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.relevant = isRelevant;
    }

    public abstract void applyEffect (Character cha);

    public abstract void applyEffect (Square square);

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

    public void addDuration (int add) {
        if (add <= 0 && (add + this.duration) < 0) {
            throw new IllegalArgumentException(ExceptionConstants.ADDING_TO_NEGATIV);
        }
        this.duration += add;
    }

    public boolean isRelevant () {
        return this.relevant;
    }

    public void setRelevant(boolean relevant) {
        this.relevant = relevant;
    }
}
