package model.dungeon;

import com.google.gson.*;
import static constants.ModelProperties.*;

import constants.FileConstants;
import model.io.TemplateReader;
import model.json.AdapterFactories;
import utility.TileGenerator;

import java.util.Random;


/**
 * This class can generate Dungeons in many different ways.
 */
public class DungeonFactory {

    private GsonBuilder builder;
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
        builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
        gson = builder.create();
        this.random = new Random(seed);
        this.numberOfLayoutEntrances = 0;
    }

    private void init() {
        builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
        gson = builder.create();
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
        return gson.fromJson(TemplateReader.readTemplateAsJsonObject(FileConstants.DUNGEON_TEMPLATE_PATH + name), Dungeon.class);
    }


    /**
     * Generates a dungeon with out any parameters.
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

        int[][] intLayout = new int[lengthOfLayout][heightOfLayout];

        // generates a ratio, that determines the number of tiles in this dungeon.
        float ratio = 0f;
        for (float i = 0f; !((i <= DUNGEON_TILE_DENSITY + DUNGEON_TILE_DENSITY_VARIANCE ) &&
                (i >= DUNGEON_TILE_DENSITY - DUNGEON_TILE_DENSITY_VARIANCE)); )
        {
            i = this.random.nextFloat();
            ratio = i;
        }
        this.numberOfLayoutEntrances = Math.round(lengthOfLayout * heightOfLayout * ratio);

        Position startPosition = new Position(this.random.nextInt(lengthOfLayout), this.random.nextInt(heightOfLayout));
        generateLayout(intLayout, startPosition);

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
        int[][] intLayout = new int[length][heigth];

        // generates a ratio, that determines the number of tiles in this dungeon.
        float ratio = 0f;
        for (float i = 0f; !((i <= DUNGEON_TILE_DENSITY + DUNGEON_TILE_DENSITY_VARIANCE ) &&
                (i >= DUNGEON_TILE_DENSITY - DUNGEON_TILE_DENSITY_VARIANCE)); )
        {
            i = this.random.nextFloat();
            ratio = i;
        }
        this.numberOfLayoutEntrances = Math.round(length * heigth * ratio);

        Position startPosition = new Position(this.random.nextInt(length), this.random.nextInt(heigth));
        generateLayout(intLayout, startPosition);

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
    public Dungeon generateRandomDungeon (int length, int height, int tileSize, Landscape[] possibleLandscapes,
                                          Position startPosition)
    {
        int[][] layout = new int[length][height];

        this.numberOfLayoutEntrances = 30;
        generateLayout(layout, startPosition);

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
        int[][] layout = new int[length][height];

        this.numberOfLayoutEntrances = numberOfTiles;
        generateLayout(layout, new Position(10,5));

        Tile[][] tiles = new Tile[length][height];
        generateDungeonFromLayout(tileSize, layout, tiles, possibleLandscapes);
        setStartPoint(startPosition, tiles,tileSize);
        return new Dungeon(tiles);
    }


    /**
     * Places the startPoint-Terrain at the middle of the tile that should be the starting tile.
     * If the startint tile is null, a new tile will be created.
     *
     * @param startPosition: The tile that should be the beginning of the dungeon.
     * @param dungeonLayout: The dungeon, in which a starting point should be set.
     */
    private void setStartPoint(Position startPosition, Tile[][] dungeonLayout, int tileSize) {
        if (dungeonLayout[startPosition.getXPosition()][startPosition.getYPosition()] == null) {
            boolean hasLeft = false;
            boolean hasRight = false;
            boolean hasUp = false;
            boolean hasDown = false;

            //checks if the tile has neighbours, does not cause an out of bounds exception.
            if (startPosition.getXPosition() > 0) {
                hasLeft = (dungeonLayout[startPosition.getXPosition() - 1][startPosition.getYPosition()] == null);
            }
            if (startPosition.getXPosition() < dungeonLayout.length -1) {
                hasRight = (dungeonLayout[startPosition.getXPosition() + 1][startPosition.getYPosition()] == null);
            }
            if (startPosition.getYPosition() > 0) {
                hasUp = (dungeonLayout[startPosition.getXPosition()][startPosition.getYPosition() - 1] == null);
            }
            if (startPosition.getYPosition() < dungeonLayout[0].length - 1) {
                hasDown = (dungeonLayout[startPosition.getXPosition()][startPosition.getYPosition() + 1] == null);
            }

            dungeonLayout[startPosition.getXPosition()][startPosition.getXPosition()]
                    = TileGenerator.getTile(tileSize,
                        Landscape.values()[this.random.nextInt(Landscape.values().length)],
                        hasRight, hasLeft, hasUp, hasDown);

        }
        // the starting tile in squares
        dungeonLayout[startPosition.getXPosition()][startPosition.getYPosition()].getlayout()
                // determines the middle of the square-array
                [Math.round(dungeonLayout[startPosition.getXPosition()][startPosition.getYPosition()].getSize() / 2)]
                [Math.round(dungeonLayout[startPosition.getXPosition()][startPosition.getYPosition()].getSize() / 2)]
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

                        dungeon[x][y] = TileGenerator.getTile(tileSize,
                                Landscape.values()[this.random.nextInt(Landscape.values().length)],
                                hasRight, hasLeft, hasUp, hasDown);
                    }
                }
            }
    }

    private void generateLayout (int[][] layout, Position position) {
        int direction = this.random.nextInt(4); //because there are 4 directions.

        if (this.numberOfLayoutEntrances > 0) {
            // goes one field up
            if (direction == 0    &&      position.getYPosition() - 1 >= 0)
            {
                position.setYPosition(position.getYPosition() - 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] =1;
                    this.numberOfLayoutEntrances--;
                }
                generateLayout(layout, position);
            }

            // goes one field to the right
            if (direction == 1    &&      position.getXPosition() +1 < layout.length)
            {
                position.setXPosition(position.getXPosition() + 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] =1;
                    this.numberOfLayoutEntrances--;
                }
                generateLayout(layout,position);
            }

            // goes one field down
            if (direction == 2    &&      position.getYPosition() + 1 < layout[0].length)
            {
                position.setYPosition(position.getYPosition() + 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] = 1;
                    this.numberOfLayoutEntrances--;
                }
                generateLayout(layout,position);
            }

            // goes one field to the left
            if (direction == 3    &&      position.getXPosition() - 1 >= 0)
            {
                position.setXPosition(position.getXPosition() - 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] = 1;
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
}
