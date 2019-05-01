package model.characters;

import java.io.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import constants.FileConstants;
import model.fighting.Attack;
import model.fighting.Skill;
import model.io.TemplateReader;
import model.json.AdapterFactories;

public enum HeroClass {
	WARRIOR(FileConstants.WARRIOR_PATH),
	ARCHER(FileConstants.ARCHER_PATH),
	MAGE(FileConstants.MAGE_PATH),
	ASSASSIN(FileConstants.ASSASSIN_PATH);
	
	String classPath;
	
	PrimeStats baseStats;
	Attack[] availableAttacks;
	
	
	HeroClass(String classPath) {	
		this.classPath = classPath;	
	}
	
	
}
