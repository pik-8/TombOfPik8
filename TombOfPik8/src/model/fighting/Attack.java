package model.fighting;

import model.effects.Effect;

import java.util.Objects;


/**
 * The class to represent attacks.
 * An attack contains the damage, the effect, an name, a short description and the AOE.
 *
 * TODO should the attack, magicAttack, accuracy and effect param have a setter?
 *
 * last change 02.04.19
 * @author Hagen
 */
public class Attack {

    private String name;
    private String description;

    private int damage;
    private int magicDamage;
    private int accuracy;

    private Effect effect;


    /**
     * Creates an Attack-Objects, whitch has the damage, magical damage, name,
     * description, accuracy and the effect of the attack.
     *
     * If one param is null the constructor will throw an Exception.
     * @param name The name of the Attack
     * @param description A short description of the attack, to inform the player
     * @param damage The damage the attack should deal.
     *               Throws an IllegalArgumentException, if damage < 0
     * @param magicDamage The magical damage this attack should deal.
     *                    Throws an IllegalArgumentException, if magicalDamage < 0
     * @param accuracy The probability that an attack hits the enemy.
     *                 Throws an IllegalArgumentException, if accuracy < 0
     * @param effect The effect that will be bestowed on enemys and squares.
     */
    public Attack(String name, String description, int damage, int magicDamage, int accuracy, Effect effect)
            throws Exception
    {
        checkParams(damage, magicDamage, accuracy);
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.damage = Objects.requireNonNull(damage);
        this.magicDamage = Objects.requireNonNull(magicDamage);
        this.accuracy = Objects.requireNonNull(accuracy);
        this.effect = Objects.requireNonNull(effect);
    }


    private void checkParams (int damage, int magicDamage, int accuracy) throws IllegalArgumentException {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage is negativ");
        }
        if (magicDamage < 0) {
            throw new IllegalArgumentException("Magical damage is negativ");
        }
        if (accuracy < 0) {
            throw new IllegalArgumentException("Accuracy is negativ");
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
