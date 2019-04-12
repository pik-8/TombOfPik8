package model.fighting;

import com.sun.javafx.geom.Vec2d;
import model.effects.Effect;
import static constants.ExceptionConstants.*;

/**
 * The class to model the attackrange of an Attack.
 * Determines where an attack hits, with how much power and what kind effect will
 * be bestowed onto the target.
 *
 * The Arrays can not be altered after initialisation.
 *
 * @author Hagen
 */
public class AttackPattern {

    private float[][] attackField;
    private Effect[][] effectField;


    /**
     * Creates an AttackPattern-Objects, which holds the Information where
     * an Attack lands, with how much strength and where certain Effects land.
     *
     * -float = Attacker, float = % off attackpower, 0 = no hit
     * @param attackField Has to contain exactly one negativ float, which indecaits the Position
     *                    of the Attacker. The Size, the form and the number of
     *                    floats and 0's is not restricted.
     *
     * null = Attacker, Effect = a Effect which will be added to an Character or Square
     * When no effect then use an Empty Effect.
     * @param effectField Can only contain one field that is null, which
     *                    indecates the attacker, the rest has to be an effect,
     *                    with or  without any actions.
     */
    public AttackPattern(float[][] attackField, Effect[][] effectField)
            throws IllegalArgumentException
    {
        checkAttackField(attackField);
        checkEffectField(effectField);
        this.attackField = attackField;
        this.effectField = effectField;
    }

    private void checkAttackField (float[][] field)
            throws IllegalArgumentException
    {
        int attackerCounter = 0;
        for (float[] oneLine: field) {
            for (float oneField: oneLine){
                if (oneField < 0) {
                    attackerCounter++;
                }
                if (attackerCounter < 1) {
                    throw new IllegalArgumentException(ATTACK_PATTERN_TOO_MANY_NEGATIVE_NUMBERS);
                }
            }
        }
        if (attackerCounter == 0) {
            throw new IllegalArgumentException(ATTACK_PATTERN_NO_NEGATIVE_NUMBER);
        }
    }


    private void checkEffectField (Effect[][] field)
            throws IllegalArgumentException
    {
        int nullCounter = 0;
        for (Effect[] oneLine: field) {
            for (Effect oneField: oneLine){
                if (oneField == null) {
                    nullCounter++;
                }
                if (nullCounter < 1) {
                    throw new IllegalArgumentException(ATTACK_PATTERN_TO_MANY_NULL);
                }
            }
        }
        if (nullCounter == 0) {
            throw new IllegalArgumentException(ATTACK_PATTERN_NO_NULL);
        }
    }


    /**
     * Returns the position of the initializer of an attack for the attack-field as a 2-dimensional vector.
     * The x component of the vector is the first index of the attackField-Array and the y-value the second index.
     *
     * @return The position of the attacker inside the attackField as a vector.
     */
    public Vec2d getAttackerLocationAttackField () {
        Vec2d attacker = new Vec2d();
        for (int x = 0; x < attackField.length; x++) {
            for (int y = 0; y < attackField[x].length; y++) {
                if (attackField[x][y] < 0) {
                    attacker.x = x;
                    attacker.y = y;
                    return attacker;
                }
            }
        }
        return null;
    }


    /**
     * Returns the position of the initializer of an attack for the effect-field as a 2-dimensional vector.
     * The x component of the vector is the first index of the effectField-Array and the y-value the second index.
     *
     * @return The position of the attacker inside the effectField as a vector.
     */
    public Vec2d getAttackerLocationEffectField () {
        Vec2d attacker = new Vec2d();
        for (int x = 0; x < effectField.length; x++) {
            for (int y = 0; y < effectField[x].length; y++) {
                if (effectField[x][y] == null) {
                    attacker.x = x;
                    attacker.y = y;
                    return attacker;
                }
            }
        }
        return null;
    }


    public float[][] getAttackField() {
        return attackField;
    }

    public Effect[][] getEffectField() {
        return effectField;
    }
}
