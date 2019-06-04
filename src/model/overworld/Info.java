package model.overworld;

import model.dungeon.Difficulty;
import model.dungeon.Landscape;

/**
 * A class that stores every information about a dungeon that is necessary to be viewable on the overworld.
 */
public class Info {

    private Landscape[] landscapes;
    private int seed;
    private Difficulty difficulty;


    public Info (Landscape[] landscapes, int seed, Difficulty difficulty) {
        this.landscapes = landscapes;
        this.seed = seed;
        this.difficulty = difficulty;
    }


    public int getSeedOfLastDungeon() {
        return seed;
    }

    public void setSeedOfLastDungeon(int seed) {
        this.seed = seed;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Landscape[] getLandscapes() {
        return landscapes;
    }

    public void setLandscapes(Landscape[] landscapes) {
        this.landscapes = landscapes;
    }
}
