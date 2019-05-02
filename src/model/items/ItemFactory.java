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
 * Abstract class for the different kinds of ItemFactories.
 * Contains ArrayLists for the different rarities of items that are filled with templates on creation.
 * From these templates randomized items are generated.
 * It can be used to drop randomized loot in chests or enemies, or for crafting randomized loot.
 * 
 * @author Frederick Hastedt
 *
 */
public abstract class ItemFactory {
	
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
	
	/**
	 * Returns a random Item of a given Rarity, scaled to a level.
	 * 
	 * @param level The level to scale the item to
	 * @param rare The rarity of the item.
	 * @return A randomly picked Item of the given Rarity, scaled to the given level and randomized with values from model.balancing.Factors
	 */
	public abstract Item generateRandomItem(int level, Rarity rare);
	
}
