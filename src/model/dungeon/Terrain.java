package model.dungeon;

import model.effects.*;


/**
 * An Enum-Class, that contains every Possible Terrain (obstacles), which has a value to determine how hard it is to walk over it
 * and an Effect than can be bestowed upon a Square or Character.
 *
 * The index-number is irrelevant.
 *
 * @author Hagen
 */
public enum Terrain {
    START_POINT(1, null),

    NONE (1, null),
    TREE(10, EffectFactory.getEffect(Condition.POISON)), //For Example
    BEDROCK(999999999, null),
    BUSH(2, null),
    BOULDER (5, null),
    WHITE_HOLE(999999999, null),
    COMET(10, null),
    ;


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
