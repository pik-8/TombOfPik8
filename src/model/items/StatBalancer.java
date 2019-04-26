package model.items;

import java.util.Random;

import constants.balancing.Factors;
import model.characters.PrimeStats;
import model.characters.SecondaryStats;

/**
 * 
 * @author Frederick Hastedt
 * 
 * This class balances the SecondaryStats and PrimeStats of Items that are dropped randomly or crafted.
 * It first scales them to the level of the hero/player, then rolls the stats to get some randomness in the
 * item's strength.
 *
 */
public class StatBalancer {

	protected static SecondaryStats balanceSecondaryStats(SecondaryStats stats, int level) {
		stats = scaleStatsToLevel(stats, level);
		stats = rollStats(stats);
		return stats;
	}

	public static PrimeStats balancePrimaryStats(PrimeStats primeStats, int level) {
		primeStats = scaleStatsToLevel(primeStats, level);
		primeStats = rollStats(primeStats);
		return primeStats;
	}

	private static SecondaryStats scaleStatsToLevel(SecondaryStats stats, int level) {
		/*
		 *  ITEM_STAT_INCREASE_MULTIPLIER implies by how much percent an Item's stats
		 *  should increase per level.
		 */
		double levelMultiplicator = Math.pow(1 + Factors.ITEM_SECSTAT_INCREASE_MULTIPLIER, (level - 1));

		stats.setMax_Hp((int)Math.round(stats.getMax_Hp() * levelMultiplicator));
		stats.setLuck((int)Math.round(stats.getLuck() * levelMultiplicator));
		stats.setDefence((int)Math.round(stats.getDefence() * levelMultiplicator));
		stats.setMagicDefence((int)Math.round(stats.getMagicDefence() * levelMultiplicator));
		stats.setSpeed((int)Math.round(stats.getSpeed() * levelMultiplicator));
		stats.setAttack((int)Math.round(stats.getAttack() * levelMultiplicator));
		stats.setMagicAttack((int)Math.round(stats.getMagicAttack() * levelMultiplicator));
		return stats;
	}
	
	private static SecondaryStats rollStats(SecondaryStats stats) {
		Random rand = new Random();
		/*
		 * The deviation is a number between 1-X and 1+X, where X is defined by how much an Item's stats should be
		 * away from the average.
		 * A random double between 0 and 1 is created, then 0.5 is subtracted from it so it is between -0.5 and +0.5.
		 * Then it is multiplied by two, to get a number between -1 and 1. This number is then multiplied with
		 * the STAT_ROLL_DEVIATION (X), and finally 1 is added to get the required multiplier.
		 */
		double deviation =(rand.nextDouble() - 0.5) * 2 * Factors.SECSTAT_ROLL_DEVIATION + 1;

		stats.setMax_Hp((int)Math.round(stats.getMax_Hp() * deviation));
		stats.setLuck((int)Math.round(stats.getLuck() * deviation));
		stats.setDefence((int)Math.round(stats.getDefence() * deviation));
		stats.setMagicDefence((int)Math.round(stats.getMagicDefence() * deviation));
		stats.setSpeed((int)Math.round(stats.getSpeed() * deviation));
		stats.setAttack((int)Math.round(stats.getAttack() * deviation));
		stats.setMagicAttack((int)Math.round(stats.getMagicAttack() * deviation));
		
		return stats;
	}
	
	private static PrimeStats scaleStatsToLevel(PrimeStats stats, int level) {
		/*
		 *  ITEM_STAT_INCREASE_MULTIPLIER implies by how much percent an Item's stats
		 *  should increase per level.
		 */
		double levelMultiplicator = Math.pow(1 + Factors.ITEM_SECSTAT_INCREASE_MULTIPLIER, (level - 1));

		stats.setHealthLevel((int)Math.round(stats.getHealthLevel() * levelMultiplicator));
		stats.setIntelligenceLevel((int)Math.round(stats.getIntelligenceLevel() * levelMultiplicator));
		stats.setLuckLevel((int)Math.round(stats.getLuckLevel() * levelMultiplicator));
		stats.setMagicLevel((int)Math.round(stats.getMagicLevel() * levelMultiplicator));
		stats.setResistanceLevel((int)Math.round(stats.getResistanceLevel() * levelMultiplicator));
		stats.setSpeedLevel((int)Math.round(stats.getSpeedLevel() * levelMultiplicator));
		stats.setStaminaLevel((int)Math.round(stats.getStaminaLevel() * levelMultiplicator));
		stats.setStrengthLevel((int)Math.round(stats.getStrengthLevel() * levelMultiplicator));
		stats.setToughnessLevel((int)Math.round(stats.getToughnessLevel() * levelMultiplicator));
		return stats;
	}
	
	private static PrimeStats rollStats(PrimeStats stats) {
		Random rand = new Random();
		/*
		 * The deviation is a number between 1-X and 1+X, where X is defined by how much an Item's stats should be
		 * away from the average.
		 * A random double between 0 and 1 is created, then 0.5 is subtracted from it so it is between -0.5 and +0.5.
		 * Then it is multiplied by two, to get a number between -1 and 1. This number is then multiplied with
		 * the STAT_ROLL_DEVIATION (X), and finally 1 is added to get the required multiplier.
		 */
		double deviation =(rand.nextDouble() - 0.5) * 2 * Factors.SECSTAT_ROLL_DEVIATION + 1;

		stats.setHealthLevel((int)Math.round(stats.getHealthLevel() * deviation));
		stats.setIntelligenceLevel((int)Math.round(stats.getIntelligenceLevel() * deviation));
		stats.setLuckLevel((int)Math.round(stats.getLuckLevel() * deviation));
		stats.setMagicLevel((int)Math.round(stats.getMagicLevel() * deviation));
		stats.setResistanceLevel((int)Math.round(stats.getResistanceLevel() * deviation));
		stats.setSpeedLevel((int)Math.round(stats.getSpeedLevel() * deviation));
		stats.setStaminaLevel((int)Math.round(stats.getStaminaLevel() * deviation));
		stats.setStrengthLevel((int)Math.round(stats.getStrengthLevel() * deviation));
		stats.setToughnessLevel((int)Math.round(stats.getToughnessLevel() * deviation));
		
		return stats;
	}


}
