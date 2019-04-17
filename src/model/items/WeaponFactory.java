package model.items;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import constants.FileConstants;
import model.io.TemplateReader;
import model.json.AdapterFactories;

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
		generateItemArray(common, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.WEAPON_COMMON_TEMPLATES));
		generateItemArray(rare, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.WEAPON_RARE_TEMPLATES));
		generateItemArray(epic, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.WEAPON_EPIC_TEMPLATES));
		generateItemArray(legendary, TemplateReader.readTemplateAsJsonObject(this.path + FileConstants.WEAPON_LEGENDARY_TEMPLATES));
	}
	
	protected void generateItemArray(ArrayList<Item> list, JsonObject jsonObject) {
		JsonArray jsonArray = jsonObject.getAsJsonArray("array");
		for(JsonElement jo : jsonArray) {
			list.add(gson.fromJson(jo, Weapon.class));
		}
	}
	
	public WeaponFactory() {
		path = FileConstants.WEAPON_TEMPLATE_PATH;
		init();
		readTemplates();
	}
	
	public Weapon generateRandomWeapon(Rarity rare, int level) {
		return (Weapon) generateRandomItem(rare, level);
	}
	
	public Weapon generateRandomWeapon(int level) {
		Rarity r = Rarity.values()[rand.nextInt(Rarity.values().length)];
		return generateRandomWeapon(r, level);
	}
	
	public Item generateRandomItem(Rarity rare, int level) {
		switch(rare) {
		case COMMON:
			return generateCommonWeapon(level);
		case RARE:
			return generateRareWeapon(level);
		case EPIC:
			return generateEpicWeapon(level);
		case LEGENDARY:
			return generateLegendaryWeapon(level);
		}
		return null;
	}
	
	public Weapon generateCommonWeapon(int level) {
		Weapon wp = (Weapon) common.get(rand.nextInt(common.size()));
		wp.setSecStats(randomiseSecStats(wp.getSecStats(), level));
		return wp;
	}
	
	public Weapon generateRareWeapon(int level) {
		Weapon wp = (Weapon) rare.get(rand.nextInt(rare.size()));
		wp.setSecStats(randomiseSecStats(wp.getSecStats(), level));
		return wp;
	}

	public Weapon generateEpicWeapon(int level) {
		Weapon wp = (Weapon) epic.get(rand.nextInt(epic.size()));
		wp.setSecStats(randomiseSecStats(wp.getSecStats(), level));
		return wp;	}

	public Weapon generateLegendaryWeapon(int level) {
//		Weapon wp = (Weapon) legendary.get(rand.nextInt(legendary.size()));
		Weapon wp = (Weapon) legendary.get(1);
		wp.setSecStats(randomiseSecStats(wp.getSecStats(), level));
		return wp;
	}
}
