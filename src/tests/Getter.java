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
import model.effects.Effect;
import model.effects.HealingEffect;
import model.fighting.Attack;
import model.fighting.AttackPattern;
import model.fighting.Skill;
import model.dungeon.Difficulty;
import model.other.SaveState;
import model.other.Statistics;
import model.overworld.Overworld;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Objects;


/**
 * A class that can give objects for test purposes.
 */
public class Getter {

    public static void main (String[] args) throws Exception {
        fileWriter(getASaveState("Deku"));
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
}
