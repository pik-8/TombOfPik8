package model.fighting;

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
                    throw new IllegalArgumentException(ATTACK_PATTERN_TO_MANY_NEGATIVE_NUMBERS);
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


    public float[][] getAttackField() {
        return attackField;
    }

    public Effect[][] getEffectField() {
        return effectField;
    }
}
