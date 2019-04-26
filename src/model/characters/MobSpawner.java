package model.characters;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import constants.FileConstants;
import model.io.TemplateReader;
import model.items.Weapon;
import model.json.AdapterFactories;

public class MobSpawner {

	private ArrayList<Character> possibleMobs;
	
	private int difficulty;
	private int level;
	
	private GsonBuilder builder;
	private Gson gson;
	private Random rand;

	private void init(int level, int difficulty) {
		possibleMobs = new ArrayList<Character>();
		readTemplate(FileConstants.MOB_TEMPLATE_PATH);
		builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		gson = builder.create();
		rand = new Random();
		
		this.level = level;
		this.difficulty = difficulty;
	}
	
	public MobSpawner(int level, int difficulty) {
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
			
		}
	}
	
	private void addToPossibleMobs(JsonObject jo) {
		possibleMobs.add(gson.fromJson(jo, Character.class));
	}

}