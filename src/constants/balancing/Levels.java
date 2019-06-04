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


    public static final int[] LEVEL_WIDTHS = {
            10, //Level 1
            10, //Level 2
            15, //Level 3
            15, //Level 4
            15, //Level 5
            15, //Level 6
            15, //Level 7
            20, //Level 8
            20, //Level 9
            20, //Level 10
    };


    public static final int[] LEVEL_HEIGHTS = {
            10, //Level 1
            15, //Level 2
            15, //Level 3
            15, //Level 4
            10, //Level 5
            15, //Level 6
            15, //Level 7
            20, //Level 8
            15, //Level 9
            20, //Level 10
    };


    public static final int[] LEVEL_TILE_NUMBER = {
            10, //Level 1
            10, //Level 2
            15, //Level 3
            15, //Level 4
            20, //Level 5
            20, //Level 6
            25, //Level 7
            25, //Level 8
            30, //Level 9
            15, //Level 10
    };


    public static final int[] LEVEL_TILE_SIZE = {
            5, //Level 1
            5, //Level 2
            5, //Level 3
            5, //Level 4
            5, //Level 5
            5, //Level 6
            5, //Level 7
            5, //Level 8
            5, //Level 9
            5, //Level 10
    };
}
