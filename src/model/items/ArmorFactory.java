package model.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import constants.FileConstants;
import model.io.TemplateReader;

public class ArmorFactory extends ItemFactory {

	public ArmorFactory() {
		path = FileConstants.ARMOR_TEMPLATE_PATH;
		init();
		readTemplates();
	}

	@Override
	protected void readTemplates() {
		generateItemArray(common, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.ARMOR_COMMON_TEMPLATES));
		generateItemArray(rare, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.ARMOR_RARE_TEMPLATES));
		generateItemArray(epic, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.ARMOR_EPIC_TEMPLATES));
		generateItemArray(legendary, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.ARMOR_LEGENDARY_TEMPLATES));		
	}

	@Override
	protected void generateItemArray(ArrayList<Item> list, JsonObject jsonObject) {
		JsonArray jsonArray = jsonObject.getAsJsonArray("array");
		for(JsonElement jo : jsonArray) {
			list.add(gson.fromJson(jo, Armor.class));
		}		
	}

	public Armor generateRandomArmor(int level, Rarity rare) {
		return (Armor) generateRandomItem(level, rare);
	}
	
	public Armor generateRandomArmor(int level) {
		Rarity r = Rarity.values()[rand.nextInt(Rarity.values().length)];
		return generateRandomArmor(level, r);
	}
	
	@Override
	public Item generateRandomItem(int level, Rarity rare) {
		switch(rare) {
		case COMMON:
			return generateCommonArmor(level);
		case RARE:
			return generateRareArmor(level);
		case EPIC:
			return generateEpicArmor(level);
		case LEGENDARY:
			return generateLegendaryArmor(level);
		default:
			return null;
		}
	}
	
	public Item generateCommonArmor(int level) {
		Armor armor = (Armor) pickRandomItem(common);
		armor.setSecStats(StatBalancer.balanceSecondaryStats(armor.getSecStats(), level));
		return armor;
	}
	
	public Item generateRareArmor(int level) {
		Armor armor = (Armor) pickRandomItem(rare);
		armor.setSecStats(StatBalancer.balanceSecondaryStats(armor.getSecStats(), level));
		return armor;
	}

	public Item generateEpicArmor(int level) {
		Armor armor = (Armor) pickRandomItem(epic);
		armor.setSecStats(StatBalancer.balanceSecondaryStats(armor.getSecStats(), level));
		return armor;
	}
	
	public Item generateLegendaryArmor(int level) {
		Armor armor = (Armor) pickRandomItem(legendary);
		armor.setSecStats(StatBalancer.balanceSecondaryStats(armor.getSecStats(), level));
		return armor;
	}



}
