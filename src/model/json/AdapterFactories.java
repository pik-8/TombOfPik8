package model.json;

import model.effects.DamageEffect;
import model.effects.Effect;
import model.effects.HealingEffect;
import model.effects.ParalysisEffect;
import model.effects.RootEffect;

/**
 * 
 * @author Frederick Hastedt
 * 
 * A collection of RuntimeAdapterFactory generators. 
 * Has to be maintained whenever a new subclass is added for an Object that needs to be saved with gson.
 * 
 * Usage:
 * Create a method like this
 * public static RuntimeTypeAdapterFactory get[RootClass]AdapterFactory(){
 * 		RuntimeTypeAdapterFactory<[RootClass]> aF = RuntimeTypeAdapterFactory.of([RootClass].class, "type")
 * 				.registerSubtype([ChildClass].class, "[ChildClass]")
 * 				// Add as many of these as you need
 * }
 *
 */
public class AdapterFactories {
	
	public static RuntimeTypeAdapterFactory getEffectAdapterFactory() {
		RuntimeTypeAdapterFactory<Effect> aF = RuntimeTypeAdapterFactory.of(Effect.class, "type")
				.registerSubtype(HealingEffect.class, "HealingEffect")
				.registerSubtype(DamageEffect.class, "DamageEffect")
				.registerSubtype(RootEffect.class, "RootEffect");
		return aF;
	}
	
}
