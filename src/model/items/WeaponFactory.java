package model.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import constants.FileConstants;
import model.io.TemplateReader;
import utility.StatBalancer;

/**
 * 
 * @author Frederick Hastedt
 * 
 * This factory can generate random weapons from a given rarity.
 * It takes templates to do this which can be added by hand.
 *
 */
public class WeaponFactory extends ItemFactory {
		
	protected void readTemplates() {
		generateItemArray(common, TemplateReader.readTemplateAsJsonObject(FileConstants.WEAPON_COMMON_TEMPLATES));
		generateItemArray(rare, TemplateReader.readTemplateAsJsonObject(FileConstants.WEAPON_RARE_TEMPLATES));
		generateItemArray(epic, TemplateReader.readTemplateAsJsonObject(FileConstants.WEAPON_EPIC_TEMPLATES));
		generateItemArray(legendary, TemplateReader.readTemplateAsJsonObject(FileConstants.WEAPON_LEGENDARY_TEMPLATES));
	}
	
	protected void generateItemArray(ArrayList<Item> list, JsonObject jsonObject) {
		JsonArray jsonArray = jsonObject.getAsJsonArray("array");
		for(JsonElement jsonObject : jsonArray) {
			list.add(gson.fromJson(jsonObject, Weapon.class));
		}
	}
	
	public WeaponFactory() {
		init();
		readTemplates();
	}
	
	public Weapon generateRandomWeapon(int level, Rarity rare) {
		return (Weapon) generateRandomItem(level, rare);
	}
	
	public Weapon generateRandomWeapon(int level) {
		Rarity rarity = Rarity.values()[rand.nextInt(Rarity.values().length)];
		return generateRandomWeapon(level, rarity);
	}
	
	public Item generateRandomItem(int level, Rarity rare) {
		switch(rare) {
		case COMMON:
			return generateCommonWeapon(level);
		case RARE:
			return generateRareWeapon(level);
		case EPIC:
			return generateEpicWeapon(level);
		case LEGENDARY:
			return generateLegendaryWeapon(level);
		default:
			return null;
		}
	}
	
	public Weapon generateCommonWeapon(int level) {
		Weapon weapon = (Weapon) pickRandomItem(common);
		StatBalancer.balanceSecondaryStats(weapon.getSecondaryStats(), level);
		return weapon;
	}
	
	public Weapon generateRareWeapon(int level) {
		Weapon weapon = (Weapon) pickRandomItem(rare);
		StatBalancer.balanceSecondaryStats(weapon.getSecondaryStats(), level);
		return weapon;
	}

	public Weapon generateEpicWeapon(int level) {
		Weapon weapon = (Weapon) pickRandomItem(epic);
		StatBalancer.balanceSecondaryStats(weapon.getSecondaryStats(), level);
		return weapon;	}

	public Weapon generateLegendaryWeapon(int level) {
		Weapon weapon = (Weapon) pickRandomItem(legendary);
		StatBalancer.balanceSecondaryStats(weapon.getSecondaryStats(), level);
		return weapon;
	}
	
}
