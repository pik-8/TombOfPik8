package constants.view;

import constants.FileConstants;
import model.dungeon.Landscape;

public interface OverWorldSceneProperties {



    public static final double[][] POSITION_OF_LEVELS = {
            {130 ,0},
            {130 ,200},
            {130 ,400},
            {130 ,600},
            {130 ,800},
            {130 ,1000},
            {130 ,1200},
            {130 ,1400},
            {130 ,1600},
            {130 ,1800}
    };


    public static final String STANDARD_TEXT_DIALOG_ENTER_DUNGEON = "Enter Dungeon";
    public static final String STANDARD_TEXT_DONT_ENTER_DUNGEON = "Cancel";
    public static final String STANDARD_DIALOG_TEXT_1 = "Level";
    public static final String STANDARD_DIALOG_TEXT_2 = "This level contains the following landscapes:\n";
    public static final String STANDARD_DIALOG_TEXT_3 = "\nwith the difficulty:\n";
    public static final String STANDARD_DIALOG_TEXT_4 = "\nAnd the seed:";
    public static final String STANDARD_DIALOG_TEXT_5 = "\nDo you want to play the level?";
}
