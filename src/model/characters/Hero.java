package model.characters;

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
     * @param name
     * @param inventory
     * @param attacks
     * @param skills
     * @param secondaryStats
     * @param exp
     * @param primeStats
     * @param statistics
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public Hero(String name, Inventory inventory, Attack[] attacks, Skill[] skills, SecondaryStats secondaryStats, int exp, PrimeStats primeStats, Statistics statistics) throws IllegalArgumentException, NullPointerException {
        super(name, inventory, attacks, skills, secondaryStats, exp);
        setPrimeStats(primeStats);
        setStatistics(statistics);
    }


    public PrimeStats getPrimeStats() {
        return primeStats;
    }

    public void setPrimeStats(PrimeStats primeStats) throws NullPointerException {
        this.primeStats = Objects.requireNonNull(primeStats);
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) throws NullPointerException {
        this.statistics = Objects.requireNonNull(statistics);
    }
}
