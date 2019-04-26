package model.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import constants.FileConstants;
import model.io.TemplateReader;

public class TrinketFactory extends ItemFactory {

	public TrinketFactory() {
		path = FileConstants.TRINKET_TEMPLATE_PATH;
		init();
		readTemplates();
	}

	@Override
	protected void readTemplates() {
		generateItemArray(common, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.TRINKET_COMMON_TEMPLATES));
		generateItemArray(rare, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.TRINKET_RARE_TEMPLATES));
		generateItemArray(epic, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.TRINKET_EPIC_TEMPLATES));
		generateItemArray(legendary, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.TRINKET_LEGENDARY_TEMPLATES));		
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
		Rarity r = Rarity.values()[rand.nextInt(Rarity.values().length)];
		return generateRandomTrinket(level, r);
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
		tr.setSecStats(StatBalancer.balanceSecondaryStats(tr.getSecStats(), level));
		tr.setPrimeStats(StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level));
		return tr;
	}
	
	private Item generateRareTrinket(int level) {
		Trinket tr = (Trinket) pickRandomItem(rare);
		tr.setSecStats(StatBalancer.balanceSecondaryStats(tr.getSecStats(), level));
		tr.setPrimeStats(StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level));
		return tr;
	}
	
	private Item generateEpicTrinket(int level) {
		Trinket tr = (Trinket) pickRandomItem(epic);
		tr.setPrimeStats(StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level));
		tr.setSecStats(StatBalancer.balanceSecondaryStats(tr.getSecStats(), level));
		return tr;
	}
	
	private Item generateLegendaryTrinket(int level) {
		Trinket tr = (Trinket) pickRandomItem(legendary);
		tr.setPrimeStats(StatBalancer.balancePrimaryStats(tr.getPrimeStats(), level));
		tr.setSecStats(StatBalancer.balanceSecondaryStats(tr.getSecStats(), level));
		return tr;
	}
}
