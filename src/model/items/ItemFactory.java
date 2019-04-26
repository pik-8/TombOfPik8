package model.items;

import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import constants.balancing.Factors;
import model.characters.SecondaryStats;
import model.json.AdapterFactories;

/**
 * 
 * @author Frederick Hastedt
 *
 * Abstract class for the different kinds of ItemFactories.
 * Contains ArrayLists for the different rarities of items that are filled with templates on creation.
 * From these templates "randomized" items are generated.
 */
public abstract class ItemFactory {

	protected String path;
	
	protected ArrayList<Item> common;
	protected ArrayList<Item> rare;
	protected ArrayList<Item> epic;
	protected ArrayList<Item> legendary;
	
	protected GsonBuilder builder;
	protected Gson gson;
	protected Random rand;
	
	protected void init() {
		common = new ArrayList<Item>();
		rare = new ArrayList<Item>();
		epic = new ArrayList<Item>();
		legendary = new ArrayList<Item>();
		builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		gson = builder.create();
		rand = new Random();
	}
	
	protected Item pickRandomItem(ArrayList<Item> ar) {
		Random rand = new Random();
		return ar.get(rand.nextInt(ar.size()));
	}
	
	protected abstract void readTemplates();
	
	protected abstract void generateItemArray(ArrayList<Item> list, JsonObject jsonObject);
	
	public abstract Item generateRandomItem(int level, Rarity rare);
	
}
