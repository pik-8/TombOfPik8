package model.effects;

import model.dungeon.Square;
import model.other.Character;

public abstract class Effect {

    private String name;
    private String description;

    private int duration;

    public Effect(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public abstract void applyEffect (Character cha);

    public abstract void applyEffect (Square square);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
