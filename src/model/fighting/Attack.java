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
    private AttackPattern attackPattern;
    
    private int cooldown;


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
     * @param effect The effect that will be bestowed on enemies and squares.
     * @param attackPattern
     * @param cooldown
     */
    public Attack(String name, String description, int damage, int magicDamage, int accuracy,
                  int requiredSlots, Effect effect, AttackPattern attackPattern, int cooldown)
    {
        checkParams(damage, magicDamage, accuracy, requiredSlots);
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.damage = damage;
        this.magicDamage = magicDamage;
        this.accuracy = accuracy;
        this.requiredSlots = requiredSlots;
        this.effect = effect;
        this.attackPattern = attackPattern;
        this.cooldown = cooldown;
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

    public AttackPattern getAttackPattern() {
        return attackPattern;
    }
    
    @Override
	public String toString() {
		return "name: " + name + 
				"\ndescription: " + description + 
				"\ndamage: " + damage + 
				"\nmagicDamage: " + magicDamage + 
				"\naccuracy: " + accuracy + 
				"\nrequiredSlots: " + requiredSlots + 
				(effect != null ? ", effect=" + effect.toString() : "") + 
				(attackPattern != null ? ", attackPattern: " + attackPattern.toString() : "") + 
				"]";
	}
}
