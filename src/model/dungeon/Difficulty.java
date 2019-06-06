package model.dungeon;


import constants.ExceptionConstants;
import constants.balancing.Factors;

/**
 * The difficulty changes the behaviour of dungeons to make them easy or difficult.
 * Changes the quantity and quality of the mobs inside the dungeon.
 *
 * @author Hagen
 */
public class Difficulty {

    private int mobSpawnRate; //in mob per tile
    private double mobLevelRate;//A factor that determines the level of the mobs.
    private double mobTier; //Between 1 and 0, 1 = highest tier.
    private double mobAI; //Between 0 and 1, 1 = the most intelligent.


    public Difficulty (int mobSpawnRate, double mobLevelRate, double mobTier, double mobAI)
            throws IllegalArgumentException
    {
        if (mobSpawnRate < 0 || mobLevelRate < 0 || mobTier < 0 || mobAI < 0) {
            throw new IllegalArgumentException(constants.ExceptionConstants.DIFFICULTY_ARUGMENT_BELOW_ZERO);
        }
        if (mobLevelRate < Factors.MIN_MOB_LEVEL_FACTOR || mobLevelRate > Factors.MAX_MOB_LEVEL_FACTOR) {
            throw new IllegalArgumentException(ExceptionConstants.MOB_LEVEL_FACTOR_NOT_IN_RANGE);
        }
        this.mobSpawnRate = mobSpawnRate;
        this.mobLevelRate = mobLevelRate;
        this.mobTier = mobTier;
        this.mobAI = mobAI;
    }


    public void setMobSpawnRate(int mobSpawnRate) {
		this.mobSpawnRate = mobSpawnRate;
	}


	public void setMobLevelRate(double mobLevel) {
		this.mobLevelRate = mobLevel;
	}


	public void setMobTier(double mobTier) {
		this.mobTier = mobTier;
	}


	public void setMobAI(double mobAI) {
		this.mobAI = mobAI;
	}


	public int getMobSpawnRate() {
        return mobSpawnRate;
    }

    public double getMobLevelRate() {
        return mobLevelRate;
    }

    public double getMobTier() {
        return mobTier;
    }

    public double getMobAI() {
        return mobAI;
    }
}
