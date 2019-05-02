package model.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import constants.FileConstants;
import model.io.TemplateReader;
import utility.StatBalancer;

/**
 * ArmorFactory is a class to generate random armor from templates.
 * It randomizes the armor with the constants from model.balancing.factors
 * It is a singleton because only one ArmorFactory is needed at any given time and creating a new one would result
 * in unnessecary IO actions.
 * 
 * @author Frederick Hastedt
 *
 */
public class ArmorFactory extends ItemFactory {

	private static ArmorFactory armorFactory;
	
	public static ArmorFactory getArmorFactory() {
		if(armorFactory != null)
			return armorFactory;
		return new ArmorFactory();
	}
	
	private ArmorFactory() {
		init();
		readTemplates();
	}

	@Override
	protected void readTemplates() {
		generateItemArray(common, TemplateReader.readTemplateAsJsonObject(FileConstants.ARMOR_COMMON_TEMPLATES));
		generateItemArray(rare, TemplateReader.readTemplateAsJsonObject(FileConstants.ARMOR_RARE_TEMPLATES));
		generateItemArray(epic, TemplateReader.readTemplateAsJsonObject(FileConstants.ARMOR_EPIC_TEMPLATES));
		generateItemArray(legendary, TemplateReader.readTemplateAsJsonObject(FileConstants.ARMOR_LEGENDARY_TEMPLATES));		
	}

	@Override
	protected void generateItemArray(ArrayList<Item> list, JsonObject jsonObject) {
		JsonArray jsonArray = jsonObject.getAsJsonArray("array");
		for(JsonElement jsonElement : jsonArray) {
			list.add(gson.fromJson(jsonElement, Armor.class));
		}		
	}

	public Armor generateRandomArmor(int level, Rarity rare) {
		return (Armor) generateRandomItem(level, rare);
	}
	
	public Armor generateRandomArmor(int level) {
		Rarity rarity = Rarity.values()[rand.nextInt(Rarity.values().length)];
		return generateRandomArmor(level, rarity);
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
		StatBalancer.balanceSecondaryStats(armor.getSecondaryStats(), level);
		return armor;
	}
	
	public Item generateRareArmor(int level) {
		Armor armor = (Armor) pickRandomItem(rare);
		StatBalancer.balanceSecondaryStats(armor.getSecondaryStats(), level);
		return armor;
	}

	public Item generateEpicArmor(int level) {
		Armor armor = (Armor) pickRandomItem(epic);
		StatBalancer.balanceSecondaryStats(armor.getSecondaryStats(), level);
		return armor;
	}
	
	public Item generateLegendaryArmor(int level) {
		Armor armor = (Armor) pickRandomItem(legendary);
		StatBalancer.balanceSecondaryStats(armor.getSecondaryStats(), level);
		return armor;
	}



}
