package model.characters;

import constants.ExceptionConstants;

import java.util.Objects;


/**
 * Contains every stat that a Hero (the player) can level up.
 * They determine the level of secondary stats.
 *
 * The isSpecialised-boolean determines if a character improves at the beginning faster or later.
 *
 * @author Hagen
 */
public class PrimeStats {


	private boolean isSpecialist;
	private int level;

	private int healthLevel;
	private int strengthLevel;
	private int resistanceLevel;
	private int intelligenceLevel;
	private int magicLevel;
	private int staminaLevel;
	private int speedLevel;
	private int toughnessLevel;
	private int luckLevel;
	
	/**
	 * Throws an Exception, if one param is null, or below 0.
	 */
	public PrimeStats(boolean isSpecialist, int level, int healthLevel, int strengthLevel, int resistanceLevel,
					  int intelligenceLevel, int magicLevel, int staminaLevel, int speedLevel, int toughnessLevel,
					  int luckLevel) throws Exception
	{
		this.isSpecialist = isSpecialist;
		primeStatsBuilder(new int[] {level, healthLevel, strengthLevel,
				resistanceLevel, intelligenceLevel, magicLevel, staminaLevel, speedLevel, toughnessLevel, luckLevel});
	}

	
	private void primeStatsBuilder (int[] params) throws Exception{
		int[] stats = {this.level, this.healthLevel, this.strengthLevel, this.resistanceLevel, this.intelligenceLevel,
				this.magicLevel, this.staminaLevel, this.speedLevel, this.toughnessLevel, this.luckLevel};
		for (int i = 0; i < params.length; i++) {
			stats[i] = Objects.requireNonNull(params[i]);
			checkLevel(stats[i]);
		}
	}
	
	private void checkLevel (int level) throws Exception {
		if (level < 0) {
			throw new Exception(ExceptionConstants.LEVEL_IS_NEGATIVE);
		}
	}



	public void addLevel(int add) throws Exception {
		this.level += add;
		checkLevel(this.level);
	}

	public void addHealthLevel(int add) throws Exception {
		this.healthLevel += add;
		checkLevel(this.healthLevel);
	}

	public void addStrenghtLevel(int add) throws Exception {
		this.strengthLevel += add;
		checkLevel(this.strengthLevel);
	}

	public void addResistanceLevel(int add) throws Exception {
		this.resistanceLevel += add;
		checkLevel(this.resistanceLevel);
	}

	public void addIntelligenceLevel(int add) throws Exception {
		this.intelligenceLevel += add;
		checkLevel(this.intelligenceLevel);
	}

	public void addMagicLevel(int add) throws Exception {
		this.magicLevel += add;
		checkLevel(this.magicLevel);
	}

	public void addStaminaLevel(int add) throws Exception {
		this.staminaLevel += add;
		checkLevel(this.staminaLevel);
	}

	public void addSpeedLevel(int add) throws Exception {
		this.speedLevel += add;
		checkLevel(this.speedLevel);
	}

	public void addToughnessLevel(int add) throws Exception {
		this.toughnessLevel += add;
		checkLevel(this.toughnessLevel);
	}

	public void addLuckLevel(int add) throws Exception {
		this.luckLevel += add;
		checkLevel(this.luckLevel);
	}
	
	
	public boolean isSpecialist() {
		return isSpecialist;
	}
	public void setSpecialist(boolean isSpecialist) {
		this.isSpecialist = isSpecialist;
	}
	public int getHealthLevel() {
		return healthLevel;
	}
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}
	public int getStrengthLevel() {
		return strengthLevel;
	}
	public void setStrengthLevel(int strengthLevel) {
		this.strengthLevel = strengthLevel;
	}
	public int getResistanceLevel() {
		return resistanceLevel;
	}
	public void setResistanceLevel(int resistanceLevel) {
		this.resistanceLevel = resistanceLevel;
	}
	public int getIntelligenceLevel() {
		return intelligenceLevel;
	}
	public void setIntelligenceLevel(int intelligenceLevel) {
		this.intelligenceLevel = intelligenceLevel;
	}
	public int getMagicLevel() {
		return magicLevel;
	}
	public void setMagicLevel(int magicLevel) {
		this.magicLevel = magicLevel;
	}
	public int getStaminaLevel() {
		return staminaLevel;
	}
	public void setStaminaLevel(int staminaLevel) {
		this.staminaLevel = staminaLevel;
	}
	public int getSpeedLevel() {
		return speedLevel;
	}
	public void setSpeedLevel(int speedLevel) {
		this.speedLevel = speedLevel;
	}
	public int getToughnessLevel() {
		return toughnessLevel;
	}
	public void setToughnessLevel(int toughnessLevel) {
		this.toughnessLevel = toughnessLevel;
	}
	public int getLuckLevel() {
		return luckLevel;
	}
	public void setLuckLevel(int luckLevel) {
		this.luckLevel = luckLevel;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "PrimeStats [isSpecialist: " + isSpecialist + 
				"\nlevel: " + level + 
				"\nhealthLevel: " + healthLevel
				+ "\nstrengthLevel: " + strengthLevel + 
				"\nresistanceLevel: " + resistanceLevel + 
				"\nintelligenceLevel: " + intelligenceLevel + 
				"\nmagicLevel: " + magicLevel + 
				"\nstaminaLevel: " + staminaLevel + 
				"\nspeedLevel: " + speedLevel + 
				"\ntoughnessLevel: " + toughnessLevel + 
				"\nluckLevel: " + luckLevel + "]";
	}
}
