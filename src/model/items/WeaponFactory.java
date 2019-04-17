package model.items;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import constants.FileConstants;

/**
 * 
 * @author Frederick Hastedt
 * 
 * This factory can generate random weapons from a given rarity.
 * It takes templates to do this which can be added by hand.
 *
 */
public class WeaponFactory {
	

	public WeaponFactory() {
		
	}
	
	public Weapon generateRandomWeapon(Rarity rare) {
		
		switch(rare) {
		case COMMON:
			return generateCommonWeapon();
		case RARE:
			return generateRareWeapon();
		case EPIC:
			return generateEpicWeapon();
		case LEGENDARY:
			return generateLegendaryWeapon();		
		}
		
		return null;
	}
	
	public Weapon generateCommonWeapon() {
		
		return null;
	}
	
	public Weapon generateRareWeapon() {
		
		return null;
	}

	public Weapon generateEpicWeapon() {
	
		return null;
	}

	public Weapon generateLegendaryWeapon() {
		
		return null;
	}
	
}
