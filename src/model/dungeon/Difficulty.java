package model.dungeon;


/**
 * The difficulty changes thew behaviour of dungeons to make them easy or difficult.
 *
 * @author Hagen
 */
public class Difficulty {

    private int mobSpawnRate; //in mob per tile
    private float mobLevelRate;
    private float mobTier;
    private float mobAI;


    protected Difficulty (int mobSpawnRate, float mobLevelRate, float mobTier, float mobAI)
            throws IllegalArgumentException
    {
        if (mobSpawnRate < 0 || mobLevelRate < 0 || mobTier < 0 || mobAI < 0) {
            throw new IllegalArgumentException(constants.ExceptionConstants.DIFFICULTY_ARUGMENT_BELOW_ZERO);
        }
        this.mobSpawnRate = mobSpawnRate;
        this.mobLevelRate = mobLevelRate;
        this.mobTier = mobTier;
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
