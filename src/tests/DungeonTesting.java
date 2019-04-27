package tests;

import model.dungeon.DungeonFactory;
import model.dungeon.Position;
import model.dungeon.Terrain;
import model.dungeon.Tile;
import view.DungeonPrinter;


/**
 * A class to test dungeon specific elements in an test-environment.
 *
 * @author Hagen
 */
public class DungeonTesting {

    public static void main (String args[]) {
        generateAndPrintALotRandomDungeons();   //Failure
        //generateAndPrintALotRandomDungeonsWithSeed();   //Failure
        //testPrintLandscapes();   //Failure
    }


    /**
     * A test to see how randomly generated dungeons will lock like.
     */
    private static void generateAndPrintALotRandomDungeons () {
        System.out.println("Generate just a lot dungeons.");

        DungeonFactory df = new DungeonFactory();
        DungeonPrinter dp = new DungeonPrinter();
        dp.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
    }


    /**
     * A test to see how multiple dungeons with the same seed behave.
     */
    private static void generateAndPrintALotRandomDungeonsWithSeed () {
        System.out.println("Generate just a lot dungeons with same seed.");

        int seed = 1;
        DungeonFactory df_1 = new DungeonFactory(seed);
        DungeonFactory df_2 = new DungeonFactory(seed);
        DungeonFactory df_3= new DungeonFactory(seed);
        DungeonFactory df_4 = new DungeonFactory(seed);
        DungeonFactory df_5 = new DungeonFactory(seed);
        DungeonPrinter dp = new DungeonPrinter();

        dp.printDungeon(df_1.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df_2.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df_3.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df_4.generateRandomDungeon());
        System.out.println("\n");
        dp.printDungeon(df_5.generateRandomDungeon());
        System.out.println("\n");
    }


    /**
     * A test that generates dungeons and prints an overview of the landscapes in the dungeon.
     */
    private static void testPrintLandscapes () {
        System.out.println("Generate some dungeons and prints the layout of their landscapes.");
        DungeonFactory df = new DungeonFactory();
        DungeonPrinter dp = new DungeonPrinter();

        dp.printLandscapes(df.generateRandomDungeon());
        dp.printLandscapes(df.generateRandomDungeon());
        dp.printLandscapes(df.generateRandomDungeon());
    }

    public static void testTileBorders () {
        /*
        System.out.println("Tile with no borders:");
        Tile test = TileFactory.getTile7x7(Landscape.FOREST, true, true, true, true);
        printTile(test);
        System.out.println("Tile with borders");
        Tile test2 = TileFactory.getTile7x7(Landscape.FOREST, false, false, false, false);
        printTile(test2);

         */
    }

    public static void testTileBordersUpAndDown () {
        /*
        System.out.println("Tile with no bottom borders:");
        Tile test = TileFactory.getTile7x7(Landscape.FOREST, false, false, false, true);
        printTile(test);
        System.out.println("Tile with no upper borders");
        Tile test2 = TileFactory.getTile7x7(Landscape.FOREST, false, false, true, false);
        printTile(test2);

         */
    }

    public static void testGoThrough () {
        boolean foundBossRoom = false;
        int[][] layout = new int[5][5];
        layout[0][0] = 1;
        layout[1][0] = 1;
        layout[2][0] = 1;
        layout[3][0] = 1;
        layout[3][1] = 1;
        layout[4][1] = 2;
        goThroughArray(layout,new Position());
        System.out.println("Ergebnis: \n\t" + foundBoss);
    }

    private static boolean foundBoss = false;


    /**
     * Can go through an array on a path.
     * Just a test.
     *
     * @param array
     * @param currentPosition
     */
    private static void goThroughArray (int[][] array, Position currentPosition) {

        if (array[currentPosition.getXPosition()][currentPosition.getYPosition()] == 2) {
            foundBoss = true;
        }

        //To mark already visited places.
        array[currentPosition.getXPosition()][currentPosition.getYPosition()] = -1;

        //Going one filed up
        if (currentPosition.getYPosition() -1 >= 0 && array[currentPosition.getXPosition()][currentPosition.getYPosition() - 1] > 0) {
            currentPosition.setYPosition(currentPosition.getYPosition() -1);
            goThroughArray(array,currentPosition);
        }

        //Going one filed down
        if (currentPosition.getYPosition() + 1 < array.length && array[currentPosition.getXPosition()][currentPosition.getYPosition() + 1] > 0 ) {
            currentPosition.setYPosition(currentPosition.getYPosition() +1);
            goThroughArray(array,currentPosition);
        }

        //Going one filed left
        if (currentPosition.getXPosition() -1 >= 0 && array[currentPosition.getXPosition() -1][currentPosition.getYPosition()] > 0) {
            currentPosition.setXPosition(currentPosition.getXPosition() -1);
            goThroughArray(array,currentPosition);
        }

        //Going one filed right
        if (currentPosition.getXPosition() +1 < array.length && array[currentPosition.getXPosition() +1][currentPosition.getYPosition()] > 0) {
            currentPosition.setXPosition(currentPosition.getXPosition() + 1);
            goThroughArray(array,currentPosition);
        }
    }


    private static void printTile (Tile tile) {
        for (int y = 0; y < tile.getlayout().length; y++) {
            for (int x = 0; x < tile.getlayout().length; x++) {
                if (tile.getlayout()[x][y].getTerrain() == Terrain.NONE) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" T ");
                }
            }
            System.out.println();
        }
    }
}
