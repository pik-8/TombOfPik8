package model.items;

import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import constants.balancing.Factors;
import model.json.AdapterFactories;
import model.other.SecondaryStats;

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
	
	/**
	 * Randomises Attack and Magic Attack of a Weapon. Magic numbers here still need to be worked out.
	 * @param stats
	 * @param level
	 * @return
	 */
	protected SecondaryStats randomiseSecStats(SecondaryStats stats, int level) {
		double levelMultiplicator = Math.pow(1 + Factors.ITEM_STAT_INCREASE_MULTIPLIER, level);
		double deviation = 1 + (rand.nextDouble() - 0.5) * Factors.WEAPON_DAMAGE_DEVIATION * 2;
		
		stats.setAttack((int)(stats.getAttack() * levelMultiplicator * deviation));
		stats.setMagicAttack((int)(stats.getMagicAttack() * levelMultiplicator * deviation));
		return stats;
	}
	
	protected void init() {
		
		common = new ArrayList<Item>();
		rare = new ArrayList<Item>();
		epic = new ArrayList<Item>();
		legendary = new ArrayList<Item>();
		builder = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		gson = builder.create();
		rand = new Random();
	}
	
	protected abstract void readTemplates();
	
	protected abstract void generateItemArray(ArrayList<Item> list, JsonObject jsonObject);
	
	public abstract Item generateRandomItem(Rarity rare, int level);
	
}
