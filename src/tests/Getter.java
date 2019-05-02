package tests;

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


/**
 * A class that can give objects for test purposes.
 */
public class Getter {

    public static Hero getAHero (String name) throws Exception {
        return Hero.createHero("Bernhard", HeroClass.WARRIOR);
    }


    public static SaveState getASaveState () throws Exception {
        Hero[] party = {getAHero("naofumi"), getAHero("Saitama")};
        Overworld overworld = new Overworld();
        DifficultyFactory difficultyFactory = new DifficultyFactory();
        Difficulty difficulty = difficultyFactory.getRandomDifficulty();
        return new SaveState(Getter.getAHero("Deku"), party, 1, overworld, difficulty);
    }
}
