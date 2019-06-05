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
    private float mobLevelRate;//A factor that determines the level of the mobs.
    private float mobTier; //Between 1 and 0, 1 = highest tier.
    private float mobAI; //Between 0 and 1, 1 = the most intelligent.


    protected Difficulty (int mobSpawnRate, float mobLevelRate, float mobTier, float mobAI)
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


	public void setMobLevelRate(float mobLevelRate) {
		this.mobLevelRate = mobLevelRate;
	}


	public void setMobTier(float mobTier) {
		this.mobTier = mobTier;
	}


	public void setMobAI(float mobAI) {
		this.mobAI = mobAI;
	}


	public int getMobSpawnRate() {
        return mobSpawnRate;
    }

    public float getMobLevelRate() {
        return mobLevelRate;
    }

    public float getMobTier() {
        return mobTier;
    }

    public float getMobAI() {
        return mobAI;
    }
}
