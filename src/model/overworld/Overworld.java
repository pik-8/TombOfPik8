package model.overworld;

import com.google.gson.Gson;
import constants.ModelProperties;
import constants.view.OverWorldSceneProperties;
import model.dungeon.*;
import model.io.TemplateReader;
import view.events.DungeonSceneKeyEvent;

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
        for (int i = OverWorldSceneProperties.INDEX_OF_FIRST_LEVEL; i <= OverWorldSceneProperties.NUMBER_OF_LEVELS; i++) {
            Difficulty difficulty = new Gson().fromJson(TemplateReader.readTemplateAsJsonObject(OverWorldSceneProperties.PATH_TO_LEVEL_DIFFICULTY[i - OverWorldSceneProperties.INDEX_OF_FIRST_LEVEL]), Difficulty.class);
            Info info = new Info(OverWorldSceneProperties.LANDSCAPES_OF_LEVEL[i - OverWorldSceneProperties.INDEX_OF_FIRST_LEVEL], new Random().nextInt(), difficulty);
            this.currentLevels.put(i, info);
        }
    }



    private void initLastLevels () {
        for (int i = OverWorldSceneProperties.INDEX_OF_FIRST_LEVEL; i <= OverWorldSceneProperties.NUMBER_OF_LEVELS; i++) {
            Info info = new Info(Landscape.values(), ModelProperties.NO_SEED_NUMBER, DifficultyFactory.getDifficultyFactory().getRandomDifficulty());
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
        return this.lastLevels.get(index).getLastDungeon();
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
     * A class that stores every information about a dungeon that is necessary to be viewable on the overworld.
     */
    private class Info {

        private Landscape[] landscapes;
        private int seed;
        private Difficulty difficulty;


        public Info(Landscape[] landscapes, int seed, Difficulty difficulty) {
            this.landscapes = landscapes;
            this.seed = seed;
            this.difficulty = difficulty;
        }


        public int getLastDungeon() {
            return seed;
        }

        public void setLastDungeon(int seed) {
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
}
