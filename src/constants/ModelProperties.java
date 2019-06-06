package constants;


/**
 * Contains every value that that has a role when an object gets initialised.
 */
public interface ModelProperties {

    public static final String STANDARD_LANGUAGE = "german";

    public static final int DURATION_LABEL_VISIBlE = 3000;
    public static final int LABEL_OFFSET_X = 50;
    public static final int LABEL_OFFSET_Y = -50;

    public static final int MAX_SIZE_FOR_SKILLS = 5;
    public static final String FILE_KEY = "file:";


    public static final double HOVER_BRIGHTNESS = 0.3;
    public static final double STANDARD_BRIGHTNESS = 0;


    //DungeonFactory-----------DungeonFactory-----------DungeonFactory-----------DungeonFactory----------DungeonFactory

    public static final float DUNGEON_TILE_DENSITY = 0.5f;
    public static final float DUNGEON_TILE_DENSITY_VARIANCE = 0.1f;
    public static final int[] RANDOM_TILE_SIZES = {4 ,5 ,6 , 7, 8, 9, 10};
    public static final int MIN_SIZE_RANDOM_DUNGEON = 10;
    public static final int MAX_SIZE_RANDOM_DUNGEON = 20;



    //DifficultyFactory

    public static final int MAX_MOB_SPAWN_RATE_FOR_RANDOM = 4;


    //Inventory

    final int INVENTORY_IS_INFINITE = -1;

    //ViewController

    public static final int STANDARD_WINDOW_HEIGHT = 720;
    public static final int STANDARD_WINDOW_WIDTH = 1080;

    public static final String WINDOW_TITLE = "Tomb of Pik 8";






    //Options

    public static final double VOLUME_MIN_VALUE = 0;
    public static final double VOLUME_MAX_VAlUE = 100;


    public static final int NO_SEED_NUMBER = 0;

}
