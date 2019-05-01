package constants.balancing;

public interface Factors {
	static final double SECSTAT_INCREASE_MULTIPLIER = 0.1;
	// This constant defines how lucky or unlucky a stat roll on a weapon can be.
	// The roll is from [100% - STAT_ROLL_DEVIATION * 100%] to [100% + STAT_ROLL_DEVIATION * 100%]
	static final double SECSTAT_ROLL_DEVIATION = 0.2;
	
	static final double MOB_SECSTAT_INCREASE_MULTIPLIER = 0.1;
	
	static final double PRIMESTAT_INCREASE_MULTIPLIER = 0.1;
	static final double PRIMESTAT_ROLL_DEVIATION = 0.1;
	

	public static final int NUMBER_TO_MAKE_EFFECT_LAST_INFINITLY = -1;

	public static final float PROBABILITY_TO_SPAWN_A_TERRAIN = 0.1f;


}
