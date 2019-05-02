package model.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import constants.FileConstants;
import model.io.TemplateReader;
import utility.StatBalancer;

public class TrinketFactory extends ItemFactory {

	public TrinketFactory() {
		init();
		readTemplates();
	}

	@Override
	protected void readTemplates() {
		generateItemArray(common, TemplateReader.readTemplateAsJsonObject(FileConstants.TRINKET_COMMON_TEMPLATES));
		generateItemArray(rare, TemplateReader.readTemplateAsJsonObject(FileConstants.TRINKET_RARE_TEMPLATES));
		generateItemArray(epic, TemplateReader.readTemplateAsJsonObject(FileConstants.TRINKET_EPIC_TEMPLATES));
		generateItemArray(legendary, TemplateReader.readTemplateAsJsonObject(FileConstants.TRINKET_LEGENDARY_TEMPLATES));		
	}

	@Override
	protected void generateItemArray(ArrayList<Item> list, JsonObject jsonObject) {
		JsonArray jsonArray = jsonObject.getAsJsonArray("array");
		for(JsonElement jo : jsonArray) {
			list.add(gson.fromJson(jo, Trinket.class));
		}		
	}

	public Trinket generateRandomTrinket(int level, Rarity rare) {
		return (Trinket) generateRandomItem(level, rare);
	}
	
	public Trinket generateRandomTrinket(int level) {
		Rarity rarity = Rarity.values()[rand.nextInt(Rarity.values().length)];
		return generateRandomTrinket(level, rarity);
	}
	
	@Override
	public Item generateRandomItem(int level, Rarity rare) {
		switch(rare) {
		case COMMON:
			return generateCommonTrinket(level);
		case RARE:
			return generateRareTrinket(level);
		case EPIC:
			return generateEpicTrinket(level);
		case LEGENDARY:
			return generateLegendaryTrinket(level);
		default:
			return null;
		}
	}
	
	private Item generateCommonTrinket(int level) {
		Trinket tr = (Trinket) pickRandomItem(common);
		StatBalancer.balanceSecondaryStats(tr.getSecondaryStats(), level);
		StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level);
		return tr;
	}
	
	private Item generateRareTrinket(int level) {
		Trinket tr = (Trinket) pickRandomItem(rare);
		StatBalancer.balanceSecondaryStats(tr.getSecondaryStats(), level);
		StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level);
		return tr;
	}
	
	private Item generateEpicTrinket(int level) {
		Trinket tr = (Trinket) pickRandomItem(epic);
		StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level);
		StatBalancer.balanceSecondaryStats(tr.getSecondaryStats(), level);
		return tr;
	}
	
	private Item generateLegendaryTrinket(int level) {
		Trinket tr = (Trinket) pickRandomItem(legendary);
		StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level);
		StatBalancer.balanceSecondaryStats(tr.getSecondaryStats(), level);
		return tr;
	}
}
