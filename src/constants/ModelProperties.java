package constants;


/**
 * Contains every value that that has a role when an object gets initialised.
 */
public interface ModelProperties {

    public static final int MAX_SIZE_FOR_SKILLS = 5;



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

}
