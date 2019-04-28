package model.characters;

import constants.ExceptionConstants;
import constants.ModelProperties;
import model.effects.Effect;
import model.fighting.Attack;
import model.fighting.Skill;

import java.util.Objects;


/**
 * The class to create every "living" thing in the game.
 *
 * The exp has different meaning, depending if it is a character or hero.
 * In Hero it represents the current exp.
 * In an character it represents the base amount of exp a hero will get after defeating the character.
 *
 * @author Hagen
 */
public class Character {

    private String name;

    private Inventory inventory;

    private Attack[] attacks;
    private Skill[] skills;

    private SecondaryStats secondaryStats;
    private int exp;


    /**
     * Throws an IllegalargumentException, if exp < 0 and a NullpointerException when one Object is null.
     *
     * @param name
     * @param inventory
     * @param attacks
     * @param skills
     * @param secondaryStats
     * @param exp
     */
    public Character(String name, Inventory inventory, Attack[] attacks, Skill[] skills,
                     SecondaryStats secondaryStats, int exp) throws IllegalArgumentException, NullPointerException
    {
        setName(name);
        setInventory(inventory);
        setAttacks(attacks);
        setSkills(skills);
        setSecondaryStats(secondaryStats);
        setExp(exp);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = Objects.requireNonNull(inventory);
    }


    public Attack[] getAttacks() {
        return attacks;
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = Objects.requireNonNull(attacks);
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) throws IllegalArgumentException, NullPointerException{
        checkSkills(skills);
        this.skills = skills;
    }

    private void checkSkills (Skill[] skills) throws IllegalArgumentException{
        if (skills.length > ModelProperties.MAX_SIZE_FOR_SKILLS) {
            throw new IllegalArgumentException(ExceptionConstants.TOO_MANY_SKILLS);
        }
    }

    public SecondaryStats getSecondaryStats() {
        return secondaryStats;
    }

    public void setSecondaryStats(SecondaryStats secondaryStats) {
        this.secondaryStats = Objects.requireNonNull(secondaryStats);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) throws IllegalArgumentException {
        if (exp < 0) {
            throw new IllegalArgumentException();
        }
        this.exp = exp;
    }

    public void addExp (int add) throws IllegalArgumentException {
        setExp(this.exp + add);
    }
}
