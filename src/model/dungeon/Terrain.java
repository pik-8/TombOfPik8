package model.dungeon;


import model.effects.*;

import java.util.Objects;

/**
 * An Enum-Class, that contains every Possible Terrain, which has a value to determine how hard it is to walk over it
 * and an Effect than can be bestowed upon a Square or Character.
 *
 * The index-number is irrelevant.
 *
 * @author Hagen
 */
public enum Terrain {

    NONE (0, EffectFactory.getEffect(Condition.NONE)),
    TREE(10, EffectFactory.getEffect(Condition.POISON)), //For Example
    BEDROCK(999999999, EffectFactory.getEffect(Condition.NONE));


    private int effortToPass;
    private final Effect effect;

    Terrain (int effortToPass, Effect effect) {
        this.effortToPass = effortToPass;
        this.effect = effect;
    }

    public int getEffortToPass() {
        return effortToPass;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffortToPass(int effortToPass) {
        this.effortToPass = effortToPass;
    }
}