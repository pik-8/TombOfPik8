package tests;

import model.dungeon.DungeonFactory;
import model.dungeon.Position;
import model.dungeon.Terrain;
import model.dungeon.Tile;
import view.DungeonPrinter;


/**
 * A class to test dungeon specific elements in a test-environment.
 *
 * @author Hagen
 */
public class DungeonTesting {

    public static void main (String args[]) {
        generateAndPrintALotRandomDungeons();   //Success
        //generateAndPrintALotRandomDungeonsWithSeed();   //Success
        //testPrintLandscapes();   //Success
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
        System.out.println();
        dp.printLandscapes(df.generateRandomDungeon());
        System.out.println();
        dp.printLandscapes(df.generateRandomDungeon());
    }
}
