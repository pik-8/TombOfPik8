package model.effects;

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
 * To get an instance of this class please visit the EffectGiver-Class.
 *
 * @author Hagen
 */
public abstract class Effect {

    private String name;
    private String description;

    private int duration;

    Effect(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
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
}
