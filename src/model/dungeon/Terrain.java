package model.dungeon;


import model.effects.Effect;

import java.util.Objects;

/**
 * A Terrain is an Object, which will be placed onto a Square, to make it more difficult or impossible
 * to go over the square.
 *
 * Can also contain an Effect.
 *
 * @author Hagen
 */
public class Terrain {

    private String name;
    private int effortToPass;
    private Effect effect;


    /**
     *
     * @param name To identify a specific type of terrain.
     *             Must not be null.
     * @param effortToPass The number will decrease the stamina of an Character who wants to stand on it.
     *                     Must not be negative.
     */
    public Terrain(String name, int effortToPass, Effect effect) throws IllegalArgumentException {
        checkParams(effortToPass);
        this.name = Objects.requireNonNull(name);
        this.effortToPass = effortToPass;
        this.effect = Objects.requireNonNull(effect);
    }

    private void checkParams (int effortToPass) {
        if (effortToPass < 0) {
            throw new IllegalArgumentException(constants.ExceptionConstants.EFFORT_IS_NEGATIVE);
        }
    }

    public String getName() {
        return name;
    }

    public int getEffortToPass() {
        return effortToPass;
    }
}
