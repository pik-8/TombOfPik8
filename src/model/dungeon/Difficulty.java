package model.dungeon;


/**
 * The difficulty changes thew behaviour of dungeons to make them easy or difficult.
 *
 * @author Hagen
 */
public class Difficulty {

    private float mobSpawnRate;
    private float mobLevelRate;
    private float mobTier;
    private float mobAI;


    protected Difficulty(float mobSpawnRate, float mobLevelRate, float mobTier, float mobAI) {
        this.mobSpawnRate = mobSpawnRate;
        this.mobLevelRate = mobLevelRate;
        this.mobTier = mobTier;
        this.mobAI = mobAI;
    }


    public float getMobSpawnRate() {
        return mobSpawnRate;
    }

    public void setMobSpawnRate(float monSpawnRate) {
        this.mobSpawnRate = monSpawnRate;
    }

    public float getMobLevelRate() {
        return mobLevelRate;
    }

    public void setMobLevelRate(float mobLevelRate) {
        this.mobLevelRate = mobLevelRate;
    }

    public float getMobTier() {
        return mobTier;
    }

    public void setMobTier(float mobTier) {
        this.mobTier = mobTier;
    }

    public float getMobAI() {
        return mobAI;
    }

    public void setMobAI(float mobAI) {
        this.mobAI = mobAI;
    }


}
