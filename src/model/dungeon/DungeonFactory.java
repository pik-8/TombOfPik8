package model.dungeon;

import com.google.gson.*;
import static constants.ModelProperties.*;

import constants.FileConstants;
import model.characters.Character;
import model.characters.MobSpawner;
import model.io.TemplateReader;
import model.json.AdapterFactories;

import java.util.Random;


/**
 * This class can generate Dungeons in many different ways.
 *
 * It can load dungeons from templates, when it gets the path to the template.
 * It can generate new dungeons with various start conditions.
 * And, when created with a seed, one can replicate a dungeon.
 *
 * It can also generate mobs inside the dungeon, however, not while creating a dungeon.
 *
 * @author Hagen
 */
public class DungeonFactory {


    private Gson gson;
    private Random random;

    private int numberOfLayoutEntrances;


    /**
     * Generates a DungeonFactory, which can be used to generate dungeons from template, to templates (saving) and
     * generate them randomly or with some parameters.
     *
     * @param seed: The seed to influence ther random parameters.
     */
    public DungeonFactory (int seed) {
        init(seed);
    }


    /**
     * Generates a DungeonFactory, which can be used to generate dungeons from template, to templates (saving) and
     * generate them randomly or with some parameters.
     */
    public DungeonFactory () {
        init();
    }


    private void init(int seed) {
        this.gson = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory()).create();
        this.random = new Random(seed);
        this.numberOfLayoutEntrances = 0;
    }

    private void init() {
        this.gson = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory()).create();
        this.random = new Random();
        this.numberOfLayoutEntrances = 0;
    }


    /**
     * Returns an Dungeon-Object from an Json-String, that can be found by following the path.
     *
     * @param name: The name of the dungeon-template file.
     * @return: A dungeon that was created from the template.
     */
    public Dungeon getDungeonFromTemplate(String name) {
        return gson.fromJson(TemplateReader.readTemplateAsJsonObject(FileConstants.DUNGEON_TEMPLATE_PATH + "/" + name), Dungeon.class);
    }


    /**
     * Generates a dungeon with a fixed difficulty.
     * Has some hard-boundary's to ensure quality.
     *
     * @return: A randomly generated Dungeon.
     */
    public Dungeon generateRandomDungeon () {

        // Generates a layout for the dungeon and determines the size off it by predefined values.
        // Has to be calculated so complicated, because the boundary from nextInt always starts with 0.
        int heightOfLayout = this.random.nextInt(MAX_SIZE_RANDOM_DUNGEON - MIN_SIZE_RANDOM_DUNGEON +1)
                + MIN_SIZE_RANDOM_DUNGEON;
        int lengthOfLayout = this.random.nextInt(MAX_SIZE_RANDOM_DUNGEON - MIN_SIZE_RANDOM_DUNGEON +1)
                + MIN_SIZE_RANDOM_DUNGEON;

        Position startPosition = new Position(this.random.nextInt(lengthOfLayout), this.random.nextInt(heightOfLayout));
        int[][] intLayout = new int[lengthOfLayout][heightOfLayout];
        intLayout[startPosition.getxTile()][startPosition.getyTile()] = 1;

        // generates a ratio, that determines the number of tiles in this dungeon.
        float ratio = 0f;
        for (float i = 0f; !((i <= DUNGEON_TILE_DENSITY + DUNGEON_TILE_DENSITY_VARIANCE ) &&
                (i >= DUNGEON_TILE_DENSITY - DUNGEON_TILE_DENSITY_VARIANCE)); )
        {
            i = this.random.nextFloat();
            ratio = i;
        }
        this.numberOfLayoutEntrances = Math.round(lengthOfLayout * heightOfLayout * ratio) -1; //Minus one, because the start-point was already set.

        Position currentPositionInLayout = new Position(startPosition.getxTile(), startPosition.getyTile());
        generateLayout(intLayout, currentPositionInLayout);

        Tile[][] tileLayout = new Tile[lengthOfLayout][heightOfLayout];
        int tileSize = RANDOM_TILE_SIZES[this.random.nextInt(RANDOM_TILE_SIZES.length)];
        generateDungeonFromLayout(tileSize, intLayout, tileLayout, Landscape.values());
        setStartPoint(startPosition, tileLayout, tileSize);
        return new Dungeon(tileLayout);
    }


    /**
     * Generates a random dungeon with fixed size.
     * Has some hard-boundary's to ensure quality.
     *
     * @return: A randomly generated Dungeon.
     */
    public Dungeon generateRandomDungeon (int length, int heigth) {
        Position startPosition = new Position(this.random.nextInt(length), this.random.nextInt(heigth));
        int[][] intLayout = new int[length][heigth];
        intLayout[startPosition.getxTile()][startPosition.getyTile()] = 1;
        // generates a ratio, that determines the number of tiles in this dungeon.
        float ratio = 0f;
        for (float i = 0f; !((i <= DUNGEON_TILE_DENSITY + DUNGEON_TILE_DENSITY_VARIANCE ) &&
                (i >= DUNGEON_TILE_DENSITY - DUNGEON_TILE_DENSITY_VARIANCE)); )
        {
            i = this.random.nextFloat();
            ratio = i;
        }
        this.numberOfLayoutEntrances = Math.round(length * heigth * ratio) -1; //Minus one, because the start-point was already set.

        Position currentPositionInLayout = new Position(startPosition.getxTile(), startPosition.getyTile());
        generateLayout(intLayout, currentPositionInLayout);

        Tile[][] tileLayout = new Tile[length][heigth];
        int tileSize = RANDOM_TILE_SIZES[this.random.nextInt(RANDOM_TILE_SIZES.length)];
        generateDungeonFromLayout(tileSize, intLayout, tileLayout, Landscape.values());
        setStartPoint(startPosition, tileLayout, tileSize);
        return new Dungeon(tileLayout);
    }


    /**
     * Generates a random dungeon with fixed size.
     * Has some hard-boundary's to ensure quality.
     *
     * @return: A randomly generated Dungeon.
     */
    public Dungeon generateRandomDungeon (int length, int height, int tileSize,
                                          Landscape[] possibleLandscapes, Position startPosition)
    {
        int[][] layout = new int[length][height];
        layout[startPosition.getxTile()][startPosition.getyTile()] = 1;

        float ratio = 0f;
        for (float i = 0f; !((i <= DUNGEON_TILE_DENSITY + DUNGEON_TILE_DENSITY_VARIANCE ) &&
                (i >= DUNGEON_TILE_DENSITY - DUNGEON_TILE_DENSITY_VARIANCE)); )
        {
            i = this.random.nextFloat();
            ratio = i;
        }

        this.numberOfLayoutEntrances = Math.round(length * height * ratio) -1; //Minus one, because the start-point was already set.
        Position currentPositionInLayout = new Position(startPosition.getxTile(), startPosition.getyTile());
        generateLayout(layout, currentPositionInLayout);

        Tile[][] tiles = new Tile[length][height];
        generateDungeonFromLayout(tileSize, layout, tiles, possibleLandscapes);
        setStartPoint(startPosition, tiles, tileSize);
        return new Dungeon(tiles);
    }


    /**
     * Generates a random dungeon with fixed size.
     * Has some hard-boundary's to ensure quality.
     *
     * @return: A randomly generated Dungeon.
     */
    public Dungeon generateRandomDungeon (int length, int height, int tileSize, Landscape[] possibleLandscapes,
                                          Position startPosition, int numberOfTiles)
    {
        Difficulty difficulty = DifficultyFactory.getDifficultyFactory().getRandomDifficulty();
        int[][] layout = new int[length][height];
        layout[startPosition.getxTile()][startPosition.getyTile()] = 1;

        this.numberOfLayoutEntrances = numberOfTiles -1; //Minus one, because the start-point was already set.
        Position currentPositionInLayout = new Position(startPosition.getxTile(), startPosition.getyTile());
        generateLayout(layout, currentPositionInLayout);

        Tile[][] tiles = new Tile[length][height];
        generateDungeonFromLayout(tileSize, layout, tiles, possibleLandscapes);
        setStartPoint(startPosition, tiles,tileSize);
        return new Dungeon(tiles);
    }


    /**
     * Creates an array of character that represents an overview, on which square a character is.
     *
     * @param difficulty: Determines the quality and quantity of mobs.
     * @param dungeon: The dungeon, to which a mob-layout should be created.
     * @param level: The level the mobs inside the dungeon should have. (Without difficulty adjustment.)
     * @return: A map that shows where a mob is.
     */
    public Character[][] getMobLayout (Difficulty difficulty, Dungeon dungeon, int level) {
        MobSpawner mobSpawner = new MobSpawner(level, difficulty.getMobTier());

        int tileSize = 0;
        for (int i = 0; i < dungeon.getLayout().length; i++) {
            for (int j = 0; j < dungeon.getLayout()[i].length; j++) {
                if (dungeon.getLayout()[i][j] != null) {
                    tileSize = dungeon.getLayout()[i][j].getSize();
                    break;
                }
            }
            if (tileSize != 0) {
                break;
            }
        }

        Character[][] mobLayout = new Character[dungeon.getLayout().length * tileSize][dungeon.getLayout()[0].length * tileSize];

        int numberOfMobs = difficulty.getMobSpawnRate();
        if (numberOfMobs == 0) {
            numberOfMobs = 1;
        }

        for (int y = 0; y < dungeon.getLayout()[0].length; y++) {
            for (int x = 0; x < dungeon.getLayout().length; x++) {
                if (dungeon.getLayout()[x][y] != null) {
                    setMobsInTile(mobLayout, dungeon.getLayout()[x][y], this.random.nextInt(numberOfMobs + 1), tileSize * x, tileSize * y,mobSpawner);
                }
            }
        }
        return mobLayout;
    }



    /**
     * Places the startPoint-Terrain at the middle of the tile that should be the starting tile.
     * If the startint tile is null, a new tile will be created.
     *
     * @param startPosition: The tile that should be the beginning of the dungeon.
     * @param dungeonLayout: The dungeon, in which a starting point should be set.
     */
    private void setStartPoint(Position startPosition, Tile[][] dungeonLayout, int tileSize) {

        // the starting tile in squares
        dungeonLayout[startPosition.getxTile()][startPosition.getyTile()].getLayout()
                // determines the middle of the square-array
                [Math.round(dungeonLayout[startPosition.getxTile()][startPosition.getyTile()].getSize() / 2)]
                [Math.round(dungeonLayout[startPosition.getxTile()][startPosition.getyTile()].getSize() / 2)]
                    = new Square(Terrain.START_POINT, null);
    }

    private void generateDungeonFromLayout (int tileSize, int[][] layout, Tile[][] dungeon, Landscape[] landscapes) {

        for (int y = 0; y < layout[0].length; y++) {
                for (int x = 0; x < layout.length; x++) {
                    if (layout[x][y] == 1) {
                        boolean hasLeft = false;
                        boolean hasRight = false;
                        boolean hasUp = false;
                        boolean hasDown = false;

                        //checks if the tile has neighbours, does not cause an out of bounds exception.
                        if (x > 0) {
                            hasLeft = (layout[x - 1][y] == 1);
                        }
                        if (x < layout.length -1) {
                            hasRight = (layout[x + 1][y] == 1);
                        }
                        if (y > 0) {
                            hasUp = (layout[x][y - 1] == 1);
                        }
                        if (y < layout[x].length - 1) {
                            hasDown = (layout[x][y + 1] == 1);
                        }

                        dungeon[x][y] = TileGenerator.getTileGenerator().getTile(tileSize,
                                Landscape.values()[this.random.nextInt(landscapes.length)],
                                hasRight, hasLeft, hasUp, hasDown);
                    }
                }
            }
    }

    private void generateLayout (int[][] layout, Position position) {
        int direction = this.random.nextInt(4); //because there are 4 directions.

        if (this.numberOfLayoutEntrances > 0) {
            // goes one field up
            if (direction == 0    &&      position.getySquare() - 1 >= 0)
            {
                position.setySquare(position.getySquare() - 1);
                if (layout[position.getxSquare()][position.getySquare()] == 0) {
                    layout[position.getxSquare()][position.getySquare()] =1;
                    this.numberOfLayoutEntrances--;
                }
                generateLayout(layout, position);
            }

            // goes one field to the right
            if (direction == 1    &&      position.getxSquare() +1 < layout.length)
            {
                position.setxSquare(position.getxSquare() + 1);
                if (layout[position.getxSquare()][position.getySquare()] == 0) {
                    layout[position.getxSquare()][position.getySquare()] =1;
                    this.numberOfLayoutEntrances--;
                }
                generateLayout(layout,position);
            }

            // goes one field down
            if (direction == 2    &&      position.getySquare() + 1 < layout[0].length)
            {
                position.setySquare(position.getySquare() + 1);
                if (layout[position.getxSquare()][position.getySquare()] == 0) {
                    layout[position.getxSquare()][position.getySquare()] = 1;
                    this.numberOfLayoutEntrances--;
                }
                generateLayout(layout,position);
            }

            // goes one field to the left
            if (direction == 3    &&      position.getxSquare() - 1 >= 0)
            {
                position.setxSquare(position.getxSquare() - 1);
                if (layout[position.getxSquare()][position.getySquare()] == 0) {
                    layout[position.getxSquare()][position.getySquare()] = 1;
                    this.numberOfLayoutEntrances--;
                }
                generateLayout(layout,position);
            }

            //initiates another loop, if a direction would be out of bounds
            if (this.numberOfLayoutEntrances > 0) {
                generateLayout(layout,position);
            }
        }
    }

    private void setMobsInTile (Character[][] mobLayout, Tile tile, int numberOfMobs, int xWorldKoordinate, int yWorldKoordinate, MobSpawner mobSpawner) {
        int endlessCounter = 0;
        for (numberOfMobs = numberOfMobs; numberOfMobs > 0; ) {
            int x = this.random.nextInt(tile.getSize());
            int y = this.random.nextInt(tile.getSize());

            if (tile.getLayout()[x][y].getTerrain() == Terrain.NONE) {
                mobLayout[xWorldKoordinate + x][yWorldKoordinate + y] = mobSpawner.spawnMob();
                numberOfMobs--;
            }
            endlessCounter++;
            //A big number but nit to big so that if there is not enough space on the tile, that it does not
            // try to place mobs endlessly.
            // Or in other words, an emergency break.
            if (endlessCounter > 500) {
                break;
            }
        }
    }
}
