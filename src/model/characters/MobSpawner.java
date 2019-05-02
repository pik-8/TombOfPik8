package model.characters;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import constants.FileConstants;
import model.fighting.Attack;
import model.fighting.Skill;
import model.io.TemplateReader;
import model.items.Weapon;
import model.json.AdapterFactories;
import utility.StatBalancer;

public class MobSpawner {

	private ArrayList<Character> possibleMobs;
	
	private float mobTier;
	private int level;
	
	private GsonBuilder builder;
	private Gson gson;
	private Random rand;

	private void init(int level, float mobTier) {
		this.possibleMobs = new ArrayList<Character>();
		this.builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		this.gson = builder.create();
		this.rand = new Random();
		
		this.level = level;
		this.mobTier = mobTier;
		
		readTemplate(FileConstants.MOB_TEMPLATE_PATH);
	}
	
	public MobSpawner(int level, float difficulty) {
		init(level, difficulty);
	}
	
	private void readTemplate(String path) {
		File dir = new File(path);
		File[] allFiles= dir.listFiles();
		if (allFiles != null) {
			for (File mob : allFiles) {
				addToPossibleMobs(TemplateReader.readTemplateAsJsonObject(mob));
			}
		} else {
			possibleMobs.add(new Character("Giant Rat", 
				new Inventory(5, 50), 
				new Attack[] {gson.fromJson(TemplateReader.readTemplateAsJsonObject(FileConstants.ATTACK_TEMPLATE_PATH + "/BasicAttack.pik"), Attack.class)}, 
				new Skill[1],
				new SecondaryStats(20, 2, 20, 2, 5, 0, 10, 10, 5, 0, 0, 0, 4, 1),
				10));
		}
	}
	
	private void addToPossibleMobs(JsonObject jsonObject) {
		possibleMobs.add(gson.fromJson(jsonObject, Character.class));
	}
	
	public Character spawnMob() {
		Character mob = possibleMobs.get(rand.nextInt(possibleMobs.size()));
		StatBalancer.balanceSecondaryStats(mob.getSecondaryStats(), level, mobTier);
		return mob;
	}

}