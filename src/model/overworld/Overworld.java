package model.overworld;

import com.google.gson.Gson;
import constants.ModelProperties;
import constants.balancing.Levels;
import constants.view.OverWorldSceneProperties;
import model.dungeon.*;
import model.io.TemplateReader;

import java.util.HashMap;
import java.util.Random;


/**
 * The overworld has collections for every level and saves the current possible dungeons and the last played ones.
 *
 * @author Hagen
 */
public class Overworld {

    private HashMap<Integer, Info> currentLevels;
    private HashMap<Integer, Info> lastLevels;


    public Overworld () {
        this.currentLevels = new HashMap<>();
        this.lastLevels = new HashMap<>();
        initCurrentLevels();
        initLastLevels();
    }



    private void initCurrentLevels () {
        for (int i = Levels.INDEX_OF_FIRST_LEVEL; i <= Levels.NUMBER_OF_LEVELS; i++) {
            Difficulty difficulty = new Gson().fromJson(TemplateReader.readTemplateAsJsonObject(Levels.PATH_TO_LEVEL_DIFFICULTY[i - Levels.INDEX_OF_FIRST_LEVEL]), Difficulty.class);
            //Difficulty difficulty = DifficultyFactory.getDifficultyFactory().getRandomDifficulty();
            Info info = new Info(Levels.LANDSCAPES_OF_LEVEL[i - Levels.INDEX_OF_FIRST_LEVEL], new Random().nextInt(), difficulty);
            this.currentLevels.put(i, info);
        }
    }



    private void initLastLevels () {
        for (int i = Levels.INDEX_OF_FIRST_LEVEL; i <= Levels.NUMBER_OF_LEVELS; i++) {
            //Info info = new Info(Landscape.values(), ModelProperties.NO_SEED_NUMBER, DifficultyFactory.getDifficultyFactory().getRandomDifficulty());
            Info info = new Info(null, ModelProperties.NO_SEED_NUMBER, null);
            this.lastLevels.put(i, info);
        }
    }


    /**
     * Gives the landscapes of a specific level.
     *
     * @param index: The specific level-number.
     *               E.g.: For level 1, index = 1.
     * @return: The landscapes of this level.
     */
    public Landscape[] getLandscapesOfCurrentLevel (int index) {
        return currentLevels.get(index).getLandscapes();
    }

    /**
     * Gives the difficulty of a specific level.
     *
     * @param index: The specific level-number.
     *               E.g.: For level 1, index = 1.
     * @return: The difficulty of this level.
     */
    public Difficulty getDifficultyOfCurrentLevel (int index) {
        return currentLevels.get(index).getDifficulty();
    }


    /**
     * Gives the dungeon from the last time playing the specific level
     *
     * @param index: The specific level-number.
     *               E.g.: For level 1, index = 1.
     * @return: The last dungeon played on. Or null.
     */
    public int getSeedOfLastLevel (int index) {
        return this.lastLevels.get(index).getSeedOfLastDungeon();
    }

    /**
     * Gives the landscapes of the dungeon, that was lastly played on a specific level.
     *
     * @param index: The specific level-number.
     *               E.g.: For level 1, index = 1.
     * @return: The landscapes for the last used dungeon. Or null.
     */
    public Landscape[] getLandscapesOfLastLevel (int index) {
        return lastLevels.get(index).getLandscapes();
    }

    /**
     * Gives the difficulty of the dungeon, that was lastly played on a specific level.
     *
     * @param index: The specific level-number.
     *               E.g.: For level 1, index = 1.
     * @return: The difficulty for the last used dungeon. Or null.
     */
    public Difficulty getDifficultyOfLastLevel (int index) {
        return lastLevels.get(index).getDifficulty();
    }


    /**
     * Puts a Info Object inside the container for every last dungeon.
     *
     * @param info The informations that should be saved.
     * @param index The level, which informations should be saved.
     */
    public void setLastDungeon (Info info, int index) {
        this.lastLevels.put(index, info);
    }
}
