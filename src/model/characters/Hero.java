package model.characters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.effects.Effect;
import model.fighting.Attack;
import model.fighting.AttackPattern;
import model.fighting.Skill;
import model.io.TemplateReader;
import model.json.AdapterFactories;
import model.other.Statistics;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


/**
 * The class to create an objects, that the player will control in the game.
 *
 * @author Hagen
 */
public class Hero extends Character {

	private Attack[] availableAttacks;
    private PrimeStats primeStats;
    private Statistics statistics;
    private HeroClass cl;


    /**
     * Throws an IllegalargumentException, if exp < 0 and a NullpointerException when one Object is null.
     *
     * @param name: The name of the hero.
     * @param inventory: The inventory of the hero.
     * @param attacks: The attacks a hero has.
     * @param skills: The skills a hero has.
     * @param exp: The amount a hero has at it's current level.
     * @param primeStats: The stats a hero can level up, determine the secondaryStats.
     * @param statistics: Saves the deeds inside a dungeon.
     * @throws IllegalArgumentException: When a number is below 0.
     * @throws NullPointerException: When an Object is null.
     */
    private Hero(String name, Inventory inventory, Attack[] availableAttacks, Attack[] attacks, Skill[] skills,
                int exp, PrimeStats primeStats, Statistics statistics, HeroClass cl)
            throws IllegalArgumentException, NullPointerException
    {
        super(name, inventory, attacks, skills, new SecondaryStats(), exp);
        this.availableAttacks = availableAttacks;
        this.primeStats = Objects.requireNonNull(primeStats);
        utility.CalculateSecondaryStats.setEveryStat(this);
        getSecondaryStats().fillHp();
        this.statistics = statistics;
        this.cl = cl;
    }
    
    /**
     * Creates a basic Hero from a given class.
     * 
     * @param name The name for the Hero.
     * @param cl The class of the Hero.
     * @return A hero with 0 exp, the classes' basestats, an Inventory with 100 gold and empty statistics.
     */
    public static Hero createHero(String name, HeroClass cl) {
		GsonBuilder builder= new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		Gson gson = builder.create();
		
		Inventory inv = new Inventory(40, 100);
		
		PrimeStats prime = gson.fromJson(TemplateReader.readTemplateAsJsonObject(cl.classPath + "/baseStats.pik"), PrimeStats.class);
		
		Statistics statistics = new Statistics();
		
		Attack[] availableAttacks = readAvailableAttacks(cl.classPath, gson);
	
		return new Hero(name, inv, availableAttacks, new Attack[] {}, new Skill[] {}, 0, prime, statistics, cl);
	}
    
    private static Attack[] readAvailableAttacks(String classPath, Gson gson) {
    	ArrayList<Attack> attackList = new ArrayList<Attack>();
		
		File dir = new File(classPath + "/attacks");
		File[] allFiles= dir.listFiles();
		if (allFiles != null) {
			for (File attack : allFiles) {
				attackList.add(gson.fromJson(TemplateReader.readTemplateAsJsonObject(attack), Attack.class));
			}
		} else {
			// Basic Attack to ensure the list is never empty.
			attackList.add(new Attack("Basic Attack", "Hit them.",
					100, 100, 100,
					1, null,
					new AttackPattern(new float[][]{{0.0f, 1.0f, 0.0f},
							{0.0f, -1.0f, 0.0f}}, 
							new Effect[][]{{null, null, null},
							{null, null, null}}),
					0));
		}
		
		Attack[] attackArray = new Attack[attackList.size()];
		for(int i = 0; i < attackList.size(); i++)
			attackArray[i] = attackList.get(i);
		return attackArray;
	} 

    public PrimeStats getPrimeStats() {
        return primeStats;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) throws NullPointerException {
        this.statistics = Objects.requireNonNull(statistics);
    }

    @Override
    public String toString () {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
