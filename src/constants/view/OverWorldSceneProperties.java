package constants.view;

import constants.FileConstants;
import model.dungeon.Landscape;

public interface OverWorldSceneProperties {



    public static final double[][] POSITION_OF_LEVELS = {
            {1157 ,3150}, //Level 1
            {1468 ,3378}, //Level 2
            {1825 ,3477}, //Level 3
            {2171 ,3393}, //Level 4
            {2442 ,3145}, //Level 5
            {2620 ,2767}, //Level 6
            {1600 ,1950}, //Level 7
            {2000 ,1600}, //Level 8
            {1750 ,1150}, //Level 9
            {1800 ,600} //Level 10
    };


    public static final String STANDARD_TEXT_DIALOG_ENTER_DUNGEON = "Enter Dungeon";
    public static final String STANDARD_TEXT_DONT_ENTER_DUNGEON = "Cancel";
    public static final String STANDARD_DIALOG_TEXT_1 = "Level";
    public static final String STANDARD_DIALOG_TEXT_2 = "This level contains the following landscapes:\n";
    public static final String STANDARD_DIALOG_TEXT_3 = "\nwith the difficulty:\n";
    public static final String STANDARD_DIALOG_TEXT_4 = "\nAnd the seed:";
    public static final String STANDARD_DIALOG_TEXT_5 = "\nDo you want to play the level?";
}
