package tests;

import model.dungeon.*;
import view.DungeonPrinter;


/**
 * A class to test dungeon specific elements in a test-environment.
 *
 * @author Hagen
 */
public class DungeonTesting {

    public static void main (String args[]) {
        //generateAndPrintALotRandomDungeons();   //Success
        //printMobLayout(); // Success
        printMobAndTerrainsLayout(); //
        //generateAndPrintALotRandomDungeonsWithSeed();   //Success
        //testPrintLandscapes();   //Success
        //loadDungeonFromTemplate("Level1.pik");//Success

        //testAllDungeons(); //failure
    }

    private static void testAllDungeons () {
        DungeonFactory dungeonFactory = new DungeonFactory();
        DungeonPrinter dungeonPrinter = new DungeonPrinter();

        dungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon(10, 10, 10, 7, new Landscape[] {Landscape.FOREST}, new Position()));
        System.out.println();
        dungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon(10, 10, 10, 7, new Landscape[] {Landscape.FOREST}, new Position(), 1));
    }


    private static void printMobAndTerrainsLayout () {
        System.out.println("The mob and Terrains layout.");

        DungeonPrinter dungeonPrinter = new DungeonPrinter();
        DungeonFactory dungeonFactory = new DungeonFactory();

        dungeonPrinter.printMobAndTerrainLayout(dungeonFactory.generateRandomDungeon(1));
    }


    private static void printMobLayout () {
        System.out.println("The mob layout.");

        DungeonPrinter dungeonPrinter = new DungeonPrinter();
        DungeonFactory dungeonFactory = new DungeonFactory();

        dungeonPrinter.printMobLayout(dungeonFactory.generateRandomDungeon(1));
    }


    /**
     * A test that creates a dungeon from a Template and prints it in the console.
     */
    private static void loadDungeonFromTemplate(String name) {
        System.out.println("Generate a dungeon from a template.\n");

        DungeonFactory df = new DungeonFactory();
        DungeonPrinter dp = new DungeonPrinter();

        dp.printDungeon(df.getDungeonFromTemplate(name));
    }


    /**
     * A test to see how randomly generated dungeons will lock like.
     */
    private static void generateAndPrintALotRandomDungeons () {
        System.out.println("Generate just a lot dungeons.");

        DungeonFactory df = new DungeonFactory();
        DungeonPrinter dp = new DungeonPrinter();

        dp.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df.generateRandomDungeon(100));
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

        dp.printDungeon(df_1.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df_2.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df_3.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df_4.generateRandomDungeon(100));
        System.out.println("\n");
        dp.printDungeon(df_5.generateRandomDungeon(100));
        System.out.println("\n");
    }


    /**
     * A test that generates dungeons and prints an overview of the landscapes in the dungeon.
     */
    private static void testPrintLandscapes () {
        System.out.println("Generate some dungeons and prints the layout of their landscapes.");

        DungeonFactory df = new DungeonFactory();
        DungeonPrinter dp = new DungeonPrinter();

        dp.printLandscapes(df.generateRandomDungeon(100));
        System.out.println();
        dp.printLandscapes(df.generateRandomDungeon(100));
        System.out.println();
        dp.printLandscapes(df.generateRandomDungeon(100));
    }
}