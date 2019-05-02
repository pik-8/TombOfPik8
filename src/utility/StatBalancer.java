package utility;

import java.util.Random;

import constants.balancing.Factors;
import model.characters.PrimeStats;
import model.characters.SecondaryStats;

/**
 * 
 * @author Frederick Hastedt
 * 
 * This class can balance SecondaryStats and PrimeStats to a given level and difficulty.
 * It first scales them to the level of the hero/player, then rolls the stats to get some randomness in the
 * item's strength.
 *
 */
public class StatBalancer {
	
	/**
	 *  
	 * 
	 * @param stats The stats that should be balanced to the given level and difficulty
	 * @param level The level the SecondaryStats should be balanced to.
	 * @param mobTier The tier of mob the SecondaryStats should be balanced to.
	 */
	public static void balanceSecondaryStats(SecondaryStats stats, int level, float mobTier) {
		// TODO STILL NEEDS TO BE IMPLEMENTED: Idea is to have the stats scaled to level and then scaled to 100% - 300% depending on difficulty.
	}
	
	public static void balanceSecondaryStats(SecondaryStats stats, int level) {
		scaleStatsToLevel(stats, level);
		rollStats(stats);
	}

	public static void balancePrimaryStats(PrimeStats primeStats, int level) {
		scaleStatsToLevel(primeStats, level);
		rollStats(primeStats);
	}

	private static void scaleStatsToLevel(SecondaryStats stats, int level) {
		/*
		 *  ITEM_SECSTAT_INCREASE_MULTIPLIER defines by how much percent an Item's stats
		 *  should increase per level.
		 */
		double levelMultiplicator = Math.pow(1 + Factors.SECSTAT_INCREASE_MULTIPLIER, (level - 1));
		
		stats.setMaxHP((int)Math.round(stats.getMaxHP() * levelMultiplicator));
		stats.setLuck((int)Math.round(stats.getLuck() * levelMultiplicator));
		stats.setDefence((int)Math.round(stats.getDefence() * levelMultiplicator));
		stats.setMagicDefence((int)Math.round(stats.getMagicDefence() * levelMultiplicator));
		stats.setSpeed((int)Math.round(stats.getSpeed() * levelMultiplicator));
		stats.setAttackPower((int)Math.round(stats.getAttackPower() * levelMultiplicator));
		stats.setMagicAttackPower((int)Math.round(stats.getMagicAttackPower() * levelMultiplicator));
	}
	
	private static void rollStats(SecondaryStats stats) {
		Random rand = new Random();
		/*
		 * The deviation is a number between 1-X and 1+X, where X is defined by how much an Item's stats should be
		 * away from the average.
		 * A random double between 0 and 1 is created, then 0.5 is subtracted from it so it is between -0.5 and +0.5.
		 * Then it is multiplied by two, to get a number between -1 and 1. This number is then multiplied with
		 * the STAT_ROLL_DEVIATION (X), and finally 1 is added to get the required multiplier.
		 */
		double deviation =(rand.nextDouble() - 0.5) * 2 * Factors.SECSTAT_ROLL_DEVIATION + 1;

		stats.setMaxHP((int)Math.round(stats.getMaxHP() * deviation));
		stats.setLuck((int)Math.round(stats.getLuck() * deviation));
		stats.setDefence((int)Math.round(stats.getDefence() * deviation));
		stats.setMagicDefence((int)Math.round(stats.getMagicDefence() * deviation));
		stats.setSpeed((int)Math.round(stats.getSpeed() * deviation));
		stats.setAttackPower((int)Math.round(stats.getAttackPower() * deviation));
		stats.setMagicAttackPower((int)Math.round(stats.getMagicAttackPower() * deviation));
	}
	
	private static void scaleStatsToLevel(PrimeStats stats, int level) {
		/*
		 *  ITEM_PRIMESTAT_INCREASE_MULTIPLIER implies by how much percent an Item's stats
		 *  should increase per level.
		 */
		double levelMultiplicator = Math.pow(1 + Factors.PRIMESTAT_INCREASE_MULTIPLIER, (level - 1));

		stats.setHealthLevel((int)Math.round(stats.getHealthLevel() * levelMultiplicator));
		stats.setIntelligenceLevel((int)Math.round(stats.getIntelligenceLevel() * levelMultiplicator));
		stats.setLuckLevel((int)Math.round(stats.getLuckLevel() * levelMultiplicator));
		stats.setMagicLevel((int)Math.round(stats.getMagicLevel() * levelMultiplicator));
		stats.setResistanceLevel((int)Math.round(stats.getResistanceLevel() * levelMultiplicator));
		stats.setSpeedLevel((int)Math.round(stats.getSpeedLevel() * levelMultiplicator));
		stats.setStaminaLevel((int)Math.round(stats.getStaminaLevel() * levelMultiplicator));
		stats.setStrengthLevel((int)Math.round(stats.getStrengthLevel() * levelMultiplicator));
		stats.setToughnessLevel((int)Math.round(stats.getToughnessLevel() * levelMultiplicator));
	}
	
	private static void rollStats(PrimeStats stats) {
		Random rand = new Random();
		/*
		 * The deviation is a number between 1-X and 1+X, where X is defined by how much an Item's stats should be
		 * away from the average.
		 * A random double between 0 and 1 is created, then 0.5 is subtracted from it so it is between -0.5 and +0.5.
		 * Then it is multiplied by two, to get a number between -1 and 1. This number is then multiplied with
		 * the PRIMESTAT_ROLL_DEVIATION (X), and finally 1 is added to get the required multiplier.
		 */
		double deviation =(rand.nextDouble() - 0.5) * 2 * Factors.PRIMESTAT_ROLL_DEVIATION + 1;

		stats.setHealthLevel((int)Math.round(stats.getHealthLevel() * deviation));
		stats.setIntelligenceLevel((int)Math.round(stats.getIntelligenceLevel() * deviation));
		stats.setLuckLevel((int)Math.round(stats.getLuckLevel() * deviation));
		stats.setMagicLevel((int)Math.round(stats.getMagicLevel() * deviation));
		stats.setResistanceLevel((int)Math.round(stats.getResistanceLevel() * deviation));
		stats.setSpeedLevel((int)Math.round(stats.getSpeedLevel() * deviation));
		stats.setStaminaLevel((int)Math.round(stats.getStaminaLevel() * deviation));
		stats.setStrengthLevel((int)Math.round(stats.getStrengthLevel() * deviation));
		stats.setToughnessLevel((int)Math.round(stats.getToughnessLevel() * deviation));
	}


}
