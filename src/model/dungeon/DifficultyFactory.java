package model.dungeon;

import com.google.gson.Gson;
import model.io.TemplateReader;
import constants.balancing.Factors;
import java.util.Random;

import static constants.FileConstants.*;


/**
 * A Singelton-Class, that creates Difficulty-Objects.
 * It creates them either from templates, randomly or with custom params.
 *
 * @author Hagen
 */
public class DifficultyFactory {


    public static DifficultyFactory difficultyFactory;
    private Gson gson;


    public static DifficultyFactory getDifficultyFactory () {
        if (difficultyFactory == null){
            return new DifficultyFactory();
        }
        return difficultyFactory;
    }


    private DifficultyFactory() {
        this.gson = new Gson();
    }


    /**
     * Returns a Difficulty-Object with the given params.
     *
     * @param mobSpawnRate: The maximum density of mobs that a tile can have in mob per tile.
     * @param mobLevelRate: Adjusts the level of the mobs that will be spawned.
     * @param mobTier: Determines the types of mobs that will be spawned.
     * @param mobAI: Determines the intelligence of the mobs.
     * @return A new Difficulty-Object with the given parameters.
     */
    public Difficulty getDifficulty (int mobSpawnRate, float mobLevelRate, float mobTier, float mobAI) {
        return new Difficulty(mobSpawnRate, mobLevelRate, mobTier, mobAI);
    }


    public Difficulty getEasyDifficulty () {
        return this.gson.fromJson(TemplateReader.readTemplateAsJsonObject(PATH_TO_EASY_DIFFICULTY), Difficulty.class);
    }


    public Difficulty getMiddleDifficulty () {
        return this.gson.fromJson(TemplateReader.readTemplateAsJsonObject(PATH_TO_MIDDLE_DIFFICULTY), Difficulty.class);
    }


    public Difficulty getHardDifficulty () {
        return this.gson.fromJson(TemplateReader.readTemplateAsJsonObject(PATH_TO_HIGH_DIFFICULTY), Difficulty.class);
    }


    public Difficulty getRandomDifficulty () {
        Random random = new Random();
        float levelFactor;
        for (levelFactor = 0; (levelFactor < Factors.MIN_MOB_LEVEL_FACTOR || levelFactor > Factors.MAX_MOB_LEVEL_FACTOR);) {
            levelFactor = random.nextFloat()+ random.nextInt(Math.round(Factors.MAX_MOB_LEVEL_FACTOR));
        }
        return new Difficulty(random.nextInt(constants.ModelProperties.MAX_MOB_SPAWN_RATE_FOR_RANDOM), levelFactor, random.nextFloat(), random.nextFloat());
    }
}
