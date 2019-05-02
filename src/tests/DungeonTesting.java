package tests;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import control.DungeonController;
import model.characters.Character;
import model.characters.Hero;
import model.characters.HeroClass;
import model.dungeon.*;
import model.json.AdapterFactories;
import view.DungeonPrinter;

import java.io.FileWriter;


/**
 * A class to test dungeon specific elements in a test-environment.
 *
 * @author Hagen
 */
public class DungeonTesting {

    public static void main (String args[]) throws Exception{
        //generateALotDungeons();   //Success
        //printCharacterLayout(); // Success
        //printMobAndTerrainsLayout(); //Success
        //generateALotDungeonsWithSeed();   //Success
        //testPrintLandscapes();  //Success
        createDungeonString();//Failure
        //loadDungeonFromTemplate("TestDungeon.pik");//Success

        printVisibleMapWithCharacters();

        //testAllDungeonGenerators(); //Success
    }


    /**
     * Is not a stable test.
     */
    private static void printVisibleMapWithCharacters() {
        System.out.println("Test to see if visible dungeon works.");
        DungeonFactory df = new DungeonFactory();
        Dungeon dungeon = df.generateRandomDungeon(2,2, 4, new Landscape[]{Landscape.FOREST}, new Position());
        Character[][] layout = df.getMobLayout(DifficultyFactory.getDifficultyFactory().getRandomDifficulty(), dungeon, 100);
        layout[3][0] = Hero.createHero("Deku", HeroClass.WARRIOR);
        System.out.println("\nNormal dungeon:");
        DungeonPrinter.printDungeon(dungeon, layout);
        boolean[][] visible = new boolean[][]{
                {true, true},
                {true, true}
        };
        System.out.println("\nVisible dungeon:");
        DungeonPrinter.printDungeon(dungeon, layout, visible);
    }


    private static void createDungeonString() throws Exception{
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory()).create();
        DungeonFactory dungeonFactory = new DungeonFactory();
        System.out.println(gson.toJson(dungeonFactory.generateRandomDungeon( 3, 3, 5, new Landscape[]{Landscape.FOREST}, new Position())));
        FileWriter bw = new FileWriter("test.pik");
        Dungeon dungeon = dungeonFactory.generateRandomDungeon( 10, 10, 5, new Landscape[]{Landscape.FOREST}, new Position());
        gson.toJson(dungeon, bw);
    }



    private static void testAllDungeonGenerators () {
        System.out.println("Generate all types of dungeons.");
        DungeonFactory dungeonFactory = new DungeonFactory();

        System.out.println("Dungeon 1:");
        DungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon());
        System.out.println();
        System.out.println("Dungeon 2:");
        DungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon( 10, 10));
        System.out.println();
        System.out.println("Dungeon 3:");
        DungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon( 10, 10, 5, new Landscape[]{Landscape.FOREST}, new Position()));
        System.out.println();
        System.out.println("Dungeon 4:");
        DungeonPrinter.printDungeon(dungeonFactory.generateRandomDungeon(10, 10, 7, new Landscape[] {Landscape.FOREST}, new Position(), 10));
        System.out.println();
    }


    private static void printMobAndTerrainsLayout () {
        System.out.println("The mob and Terrains layout.");

        DungeonFactory dungeonFactory = new DungeonFactory();

        Dungeon dungeon = dungeonFactory.generateRandomDungeon();
        Character[][] mob = dungeonFactory.getMobLayout(DifficultyFactory.getDifficultyFactory().getRandomDifficulty(), dungeon, 100);
        DungeonPrinter.printDungeon(dungeon, mob);
    }


    private static void printMobLayout () {
        System.out.println("The mob layout.");

        DungeonFactory dungeonFactory = new DungeonFactory();

        DungeonPrinter.printCharacterLayout(dungeonFactory.getMobLayout(DifficultyFactory.getDifficultyFactory().getRandomDifficulty(), dungeonFactory.generateRandomDungeon(), 100));
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
    private static void generateALotDungeons () {
        System.out.println("Generate just a lot dungeons.");

        DungeonFactory df = new DungeonFactory();

        DungeonPrinter.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df.generateRandomDungeon());
        System.out.println("\n");
    }


    /**
     * A test to see how multiple dungeons with the same seed behave.
     */
    private static void generateALotDungeonsWithSeed () {
        System.out.println("Generate just a lot dungeons with same seed.");

        int seed = 1;
        DungeonFactory df_1 = new DungeonFactory(seed);
        DungeonFactory df_2 = new DungeonFactory(seed);
        DungeonFactory df_3= new DungeonFactory(seed);
        DungeonFactory df_4 = new DungeonFactory(seed);
        DungeonFactory df_5 = new DungeonFactory(seed);

        DungeonPrinter.printDungeon(df_1.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_2.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_3.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_4.generateRandomDungeon());
        System.out.println("\n");
        DungeonPrinter.printDungeon(df_5.generateRandomDungeon());
        System.out.println("\n");
    }


    /**
     * A test that generates dungeons and prints an overview of the landscapes in the dungeon.
     */
    private static void testPrintLandscapes () {
        System.out.println("Generate some dungeons and prints the layout of their landscapes.");

        DungeonFactory df = new DungeonFactory();

        DungeonPrinter.printLandscapes(df.generateRandomDungeon());
        System.out.println();
        DungeonPrinter.printLandscapes(df.generateRandomDungeon());
        System.out.println();
        DungeonPrinter.printLandscapes(df.generateRandomDungeon());
    }
}