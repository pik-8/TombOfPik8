package constants.balancing;

import constants.FileConstants;
import model.dungeon.Landscape;
import model.dungeon.Position;

public interface Levels {
    //All levels----------All levels----------All levels----------All levels----------All levels----------All levels
    public static final int NUMBER_OF_LEVELS = 10;

    public static final int INDEX_OF_FIRST_LEVEL = 1;

    public static final Landscape[][] LANDSCAPES_OF_LEVEL = {
            {Landscape.FOREST},
            {Landscape.FOREST},
            {Landscape.FOREST, Landscape.DESERT},
            {Landscape.DESERT},
            {Landscape.DESERT},
            {Landscape.DESERT, Landscape.SPACE},
            {Landscape.SPACE},
            {Landscape.SPACE},
            {Landscape.FOREST},
            {Landscape.FOREST},
    };


    public static final String[] PATH_TO_LEVEL_DIFFICULTY = {
            FileConstants.PATH_TO_EASY_DIFFICULTY,
            FileConstants.PATH_TO_EASY_DIFFICULTY,
            FileConstants.PATH_TO_EASY_DIFFICULTY,
            FileConstants.PATH_TO_MIDDLE_DIFFICULTY,
            FileConstants.PATH_TO_MIDDLE_DIFFICULTY,
            FileConstants.PATH_TO_MIDDLE_DIFFICULTY,
            FileConstants.PATH_TO_MIDDLE_DIFFICULTY,
            FileConstants.PATH_TO_HIGH_DIFFICULTY,
            FileConstants.PATH_TO_HIGH_DIFFICULTY,
            FileConstants.PATH_TO_HIGH_DIFFICULTY,
    };

    //Level 1----------Level 1----------Level 1----------Level 1----------Level 1----------Level 1----------Level 1
    public static final int LEVEL_1_WIDTH = 5;
    public static final int LEVEL_1_HEIGHT = 5;
    public static final int LEVEL_1_TILES = 10;
    public static final Position START_POSITION = new Position(0, 0, 0, 0);


}
