package model.overworld;

import model.dungeon.Dungeon;
import model.dungeon.Landscape;
import model.dungeon.Difficulty;

import java.util.HashMap;


/**
 * The overworld has collections for every level and saves the current possible dungeons and the last played ones.
 *
 * @author Hagen
 */
public class Overworld {

    private HashMap<Integer, Info> currentLevels;
    private HashMap<Integer, Info> lastLevels;


    public Overworld () {  }


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
     * @return: The last played on dungeon.
     */
    public Dungeon getDungeonOfLastLevel (int index) {
        return lastLevels.get(index).getLastDungeon();
    }

    /**
     * Gives the landscapes of the dungeon, that was lastly played on a specific level.
     *
     * @param index: The specific level-number.
     *               E.g.: For level 1, index = 1.
     * @return: The landscapes for the last used dungeon.
     */
    public Landscape[] getLandscapesOfLastLevel (int index) {
        return lastLevels.get(index).getLandscapes();
    }

    /**
     * Gives the difficulty of the dungeon, that was lastly played on a specific level.
     *
     * @param index: The specific level-number.
     *               E.g.: For level 1, index = 1.
     * @return: The difficulty for the last used dungeon.
     */
    public Difficulty getDifficultyOfLastLevel (int index) {
        return lastLevels.get(index).getDifficulty();
    }







    /**
     * A class that stores every information about a dungeon that is necessary to be viewable on the overworld.
     */
    private class Info {

        private Landscape[] landscapes;
        private Dungeon lastDungeon;
        private Difficulty difficulty;


        public Info(Landscape[] landscapes, Dungeon lastDungeon, Difficulty difficulty) {
            this.landscapes = landscapes;
            this.lastDungeon = lastDungeon;
            this.difficulty = difficulty;
        }


        public Dungeon getLastDungeon() {
            return lastDungeon;
        }

        public void setLastDungeon(Dungeon lastDungeon) {
            this.lastDungeon = lastDungeon;
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
