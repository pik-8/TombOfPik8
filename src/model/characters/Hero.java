package model.characters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.effects.Effect;
import model.fighting.Attack;
import model.fighting.Skill;
import model.other.Statistics;

import java.util.Objects;


/**
 * The class to create an objects, that the player will control in the game.
 *
 * @author Hagen
 */
public class Hero extends Character {


    private PrimeStats primeStats;
    private Statistics statistics;


    /**
     * Throws an IllegalargumentException, if exp < 0 and a NullpointerException when one Object is null.
     *
     * @param name: The name of the hero.
     * @param inventory: The inventory of the hero.
     * @param attacks: The attacks a hero has.
     * @param skills: The skills a hero has.
     * @param exp: The amount a hero has at it's current level.
     * @param primeStats: The stats a hero can level up, determine the secondaryStats.
     * @param statistics: Saves the deeds inside a dungeon.
     * @throws IllegalArgumentException: When a number is below 0.
     * @throws NullPointerException: When an Object is null.
     */
    public Hero(String name, Inventory inventory, Attack[] attacks, Skill[] skills,
                int exp, PrimeStats primeStats, Statistics statistics)
            throws IllegalArgumentException, NullPointerException
    {
        super(name, inventory, attacks, skills, new SecondaryStats(), exp);
        this.primeStats = Objects.requireNonNull(primeStats);
        utility.CalculateSecondaryStats.setEveryStat(this);
        setStatistics(statistics);
    }


    public PrimeStats getPrimeStats() {
        return primeStats;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) throws NullPointerException {
        this.statistics = Objects.requireNonNull(statistics);
    }

    @Override
    public String toString () {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
