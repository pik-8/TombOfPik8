package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.FileConstants;
import model.characters.HeroClass;
import model.characters.Hero;
import model.characters.Inventory;
import model.characters.PrimeStats;
import model.characters.SecondaryStats;
import model.dungeon.DifficultyFactory;
import model.dungeon.DungeonFactory;
import model.dungeon.Landscape;
import model.effects.Effect;
import model.effects.HealingEffect;
import model.fighting.Attack;
import model.fighting.AttackPattern;
import model.fighting.Skill;
import model.dungeon.Difficulty;
import model.io.TemplateReader;
import model.other.SaveState;
import model.other.Statistics;
import model.overworld.Info;
import model.overworld.Overworld;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Objects;


/**
 * A class that can give objects for test purposes.
 */
public class Getter {

    public static void main (String[] args) throws Exception {
        fileWriter(getASaveState("Deku"));
        //fileWriter(DifficultyFactory.getDifficultyFactory().getRandomDifficulty());
        //test();
    }

    public static Hero getAHero (String name) throws Exception {
        return Hero.createHero(name, HeroClass.WARRIOR);
    }


    public static SaveState getASaveState (String name) throws Exception {
        Hero[] party = {getAHero("naofumi"), getAHero("Saitama")};
        Overworld overworld = new Overworld();
        Difficulty difficulty = DifficultyFactory.getDifficultyFactory().getRandomDifficulty();
        return new SaveState(Getter.getAHero(name), party, 1, overworld, difficulty);
    }


    public static void fileWriter (Object object) throws Exception {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        System.out.println(gson.toJson(object));
    }

    public static void test()  {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        File file = new File(FileConstants.PATH_TO_MIDDLE_DIFFICULTY);
        System.out.println(file.getName());
        System.out.println(gson.fromJson(TemplateReader.readTemplateAsJsonObject(FileConstants.PATH_TO_MIDDLE_DIFFICULTY), Difficulty.class));
    }
}
