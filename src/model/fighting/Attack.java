package model.fighting;

import model.effects.Effect;
import java.util.Objects;

import static constants.ExceptionConstants.*;


/**
 * The class to represent attacks.
 * An attack contains the damage, the effect, an name, a short description and the AOE.
 *
 * @author Hagen
 */
public class Attack {

    private String name;
    private String description;

    private int damage;
    private int magicDamage;
    private int accuracy;
    private int requiredSlots;

    private Effect effect;


    /**
     * Creates an Attack-Objects, which has the damage, magical damage, name,
     * description, accuracy and the effect of the attack.
     *
     * Only the String-params can be altered after initialisation.
     *
     * If one param is null the constructor will throw an NullPointerException.
     * The numbers can be 0 however, bur not negative, than it throws a IllegalArgumentExceptions.
     * @param name The name of the Attack
     * @param description A short description of the attack, to inform the player
     * @param damage The damage the attack should deal.
     *               Throws an IllegalArgumentException, if damage < 0
     * @param magicDamage The magical damage this attack should deal.
     *                    Throws an IllegalArgumentException, if magicalDamage < 0
     * @param accuracy The probability that an attack hits the enemy.
     *                 Throws an IllegalArgumentException, if accuracy < 0
     * @param requiredSlots How many slots this attack will be using.
     *                      Throws an IllegalArgumentException, if requiredSlots < 0
     * @param effect The effect that will be bestowed on enemys and squares.
     */
    public Attack(String name, String description, int damage, int magicDamage, int accuracy, int requiredSlots, Effect effect)
            throws Exception
    {
        checkParams(damage, magicDamage, accuracy, requiredSlots);
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.damage = damage;
        this.magicDamage = magicDamage;
        this.accuracy = accuracy;
        this.effect = Objects.requireNonNull(effect);
    }


    private void checkParams (int damage, int magicDamage, int accuracy, int requiredSlots) throws IllegalArgumentException {
        if (damage < 0) {
            throw new IllegalArgumentException(ATTACK_DAMAGE_IS_NEGATIVE);
        }
        if (magicDamage < 0) {
            throw new IllegalArgumentException(ATTACK_MAGICAL_DAMAGE_IS_NEGATIVE);
        }
        if (accuracy < 0) {
            throw new IllegalArgumentException(ATTACK_ACCURACY_IS_NEGATIVE);
        }
        if (requiredSlots < 0) {
            throw new IllegalArgumentException(ATTACK_REQUIREDSLOTS_IS_NEGATIVE);
        }
    }

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

    public int getDamage() {
        return damage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getRequiredSlots() {
        return requiredSlots;
    }
}