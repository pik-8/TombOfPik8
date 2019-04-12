package model.fighting;

import model.effects.Effect;

public class DivineHealSkill extends Skill {

    /**
     * Creates an Skill-Objects, which heals all nearby Heros.
     * <p>
     * Only the String-params can be altered after initialisation.
     * <p>
     * If one param is null the constructor will throw an NullPointerException.
     * The numbers can be 0 however, bur not negative, than it throws a IllegalArgumentExceptions.
     *
     * @param name          The name of the Attack
     * @param description   A short description of the attack, to inform the player
     * @param damage        The damage the attack should deal.
     *                      Throws an IllegalArgumentException, if damage < 0
     * @param magicDamage   The magical damage this attack should deal.
     *                      Throws an IllegalArgumentException, if magicalDamage < 0
     * @param accuracy      The probability that an attack hits the enemy.
     *                      Throws an IllegalArgumentException, if accuracy < 0
     * @param requiredSlots How many slots this attack will be using.
     *                      Throws an IllegalArgumentException, if requiredSlots < 0
     * @param effect        The effect that will be bestowed on enemys and squares.
     * @param isReady       If true, then the skill can be used.
     */
    protected DivineHealSkill(String name, String description, int damage, int magicDamage, int accuracy, int requiredSlots, Effect effect, boolean isReady) throws Exception {
        super(name, description, damage, magicDamage, accuracy, requiredSlots, effect, isReady);
    }


    @Override
    public boolean checIfReady() {
        //TODO implement a conditin.
        return true;
    }
}
