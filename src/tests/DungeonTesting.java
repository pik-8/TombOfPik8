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
        //generateAnDungeonPrinterrintALotRandomDungeons();   //Success
        printMobLayout(); // Success
        printMobAndTerrainsLayout(); //
        //generateAnDungeonPrinterrintALotRandomDungeonsWithSeed();   //Success
        //testPrintLandscapes();   //Success
        //loadDungeonFromTemplate("Level1.pik");//Success

        //testAllDungeons(); //failure
    }

    private static void testAllDungeons () {
        DungeonFactory dungeonFactory = new DungeonFactory();

        DungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon(10, 10, 10, 7, new Landscape[] {Landscape.FOREST}, new Position()));
        System.out.println();
        DungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon(10, 10, 10, 7, new Landscape[] {Landscape.FOREST}, new Position(), 1));
    }


    private static void printMobAndTerrainsLayout () {
        System.out.println("The mob and Terrains layout.");

        DungeonFactory dungeonFactory = new DungeonFactory();

        DungeonPrinter.printMobAndTerrainLayout(dungeonFactory.generateRandomDungeon(1));
    }


    private static void printMobLayout () {
        System.out.println("The mob layout.");

        DungeonFactory dungeonFactory = new DungeonFactory();

        DungeonPrinter.printMobLayout(dungeonFactory.generateRandomDungeon(1));
    }


    /**
     * A test that creates a dungeon from a Template and prints it in the console.
     */
    private static void loadDungeonFromTemplate(String name) {
        System.out.println("Generate a dungeon from a template.\n");

        DungeonFactory df = new DungeonFactory();

        DungeonPrinter.printDungeon(df.getDungeonFromTemplate(name));
    }


    /**
     * A test to see how randomly generated dungeons will lock like.
     */
    private static void generateAnDungeonPrinterrintALotRandomDungeons () {
        System.out.println("Generate just a lot dungeons.");

        DungeonFactory df = new DungeonFactory();

        DungeonPrinter.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon(100));
        System.out.println("\n");
    }


    /**
     * A test to see how multiple dungeons with the same seed behave.
     */
    private static void generateAnDungeonPrinterrintALotRandomDungeonsWithSeed () {
        System.out.println("Generate just a lot dungeons with same seed.");

        int seed = 1;
        DungeonFactory df_1 = new DungeonFactory(seed);
        DungeonFactory df_2 = new DungeonFactory(seed);
        DungeonFactory df_3= new DungeonFactory(seed);
        DungeonFactory df_4 = new DungeonFactory(seed);
        DungeonFactory df_5 = new DungeonFactory(seed);

        DungeonPrinter.printDungeon(df_1.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_2.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_3.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_4.generateRandomDungeon(100));
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_5.generateRandomDungeon(100));
        System.out.println("\n");
    }


    /**
     * A test that generates dungeons and prints an overview of the landscapes in the dungeon.
     */
    private static void testPrintLandscapes () {
        System.out.println("Generate some dungeons and prints the layout of their landscapes.");

        DungeonFactory df = new DungeonFactory();

        DungeonPrinter.printLandscapes(df.generateRandomDungeon(100));
        System.out.println();
        DungeonPrinter.printLandscapes(df.generateRandomDungeon(100));
        System.out.println();
        DungeonPrinter.printLandscapes(df.generateRandomDungeon(100));
    }
}