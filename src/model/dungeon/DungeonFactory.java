package model.dungeon;

import com.google.gson.*;
import model.io.TemplateReader;
import model.json.AdapterFactories;
import utility.TileGenerator;

import java.util.Random;

public class DungeonFactory {

    private GsonBuilder builder;
    private Gson gson;
    private Random random;

    private int numberOfLayoutEntraces;

    public DungeonFactory () {
        init();
    }

    protected Dungeon getDungeonFromTemplate(String path) {
        return gson.fromJson(TemplateReader.readTemplateAsJsonObject(path), Dungeon.class);
    }

    public Dungeon generateRandomDungeon (int length, Position startPosition, int tileSize, int numberOfTiles, Landscape[] possibleLandscapes) {
        int[][] layout = new int[length][length];

        this.numberOfLayoutEntraces = numberOfTiles;
        generateLayout(layout, startPosition);

        Tile[][] tiles = new Tile[length][length];
        generateDungeonFromLayout(tileSize, layout, tiles, possibleLandscapes);
        return new Dungeon(tiles);
    }


    public Dungeon generateRandomDungeon (int length, int height, int tileSize, Landscape[] possibleLandscapes) {
        int[][] layout = new int[length][height];

        this.numberOfLayoutEntraces = 30;
        generateLayout(layout, new Position(10,5));
        System.out.println("Layout:");
        printLayout(layout);
        Tile[][] tiles = new Tile[length][height];
        generateDungeonFromLayout(tileSize, layout, tiles, possibleLandscapes);
        return new Dungeon(tiles);
    }


    private void printLayout (int[][] layout) {
        for (int y = 0; y < layout[0].length; y++) {
            for (int x = 0; x < layout[y].length; x++) {
                System.out.print(layout[x][y]);
            }
            System.out.println();
        }
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

        if (this.numberOfLayoutEntraces> 0) {
            // goes one field up
            if (direction == 0    &&      position.getYPosition() - 1 >= 0)
            {
                position.setYPosition(position.getYPosition() - 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] =1;
                    this.numberOfLayoutEntraces--;
                }
                generateLayout(layout, position);
            }

            // goes one field to the right
            if (direction == 1    &&      position.getXPosition() +1 < layout.length)
            {
                position.setXPosition(position.getXPosition() + 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] =1;
                    this.numberOfLayoutEntraces--;
                }
                generateLayout(layout,position);
            }

            // goes one field down
            if (direction == 2    &&      position.getYPosition() + 1 < layout[0].length)
            {
                position.setYPosition(position.getYPosition() + 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] = 1;
                    this.numberOfLayoutEntraces--;
                }
                generateLayout(layout,position);
            }

            // goes one field to the left
            if (direction == 3    &&      position.getXPosition() - 1 >= 0)
            {
                position.setXPosition(position.getXPosition() - 1);
                if (layout[position.getXPosition()][position.getYPosition()] == 0) {
                    layout[position.getXPosition()][position.getYPosition()] = 1;
                    this.numberOfLayoutEntraces--;
                }
                generateLayout(layout,position);
            }

            //initiates another loop, if a direction would be out of bounds
            if (this.numberOfLayoutEntraces > 0) {
                generateLayout(layout,position);
            }

        }

    }

    protected void init() {
        builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
        gson = builder.create();
        this.random = new Random();
        this.numberOfLayoutEntraces = 0;
    }
}
