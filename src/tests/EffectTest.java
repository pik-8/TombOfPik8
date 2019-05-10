package tests;

import control.EffectHandler;
import model.characters.Hero;
import model.effects.DamageEffect;
import model.effects.SlowDownEffect;

public class EffectTest {

	public static void main(String[] args) {
//		testDamageEffect();
		testSlowDownEffectRemoval();
	}

	private static void testSlowDownEffectRemoval() {
		try {
			Hero myHero = Getter.getAHero("Slowed Hero");
			EffectHandler eh = new EffectHandler();
			System.out.println("Original Speed: " + myHero.getSecondaryStats().getSpeed());
			eh.addEffect(myHero, new SlowDownEffect("Slow", "Slow down", 2, 10, 20));
			eh.addEffect(myHero, new SlowDownEffect("Slow 2", "Slow down less", 4, 7, 10));
			System.out.println("Before slowing for a round: " + myHero.getSecondaryStats().getSpeed());
			eh.applyAllEffects();
			System.out.println("After slowing for a rounds: " + myHero.getSecondaryStats().getSpeed());
			eh.applyAllEffects();
			eh.addEffect(myHero, new SlowDownEffect("Slow 3", "Slow down more", 1, 15, 9));
			System.out.println("After slowing for two rounds and adding another effect: " + myHero.getSecondaryStats().getSpeed());
			eh.applyAllEffects();
			System.out.println("After slowing for three rounds: " + myHero.getSecondaryStats().getSpeed());
			eh.applyAllEffects();
			System.out.println("After slowing for four rounds: " + myHero.getSecondaryStats().getSpeed());
			eh.applyAllEffects();
			System.out.println("After slowing for five rounds: " + myHero.getSecondaryStats().getSpeed());
			eh.applyAllEffects();
			System.out.println("After slowing for six rounds: " + myHero.getSecondaryStats().getSpeed());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static void testDamageEffect() {
		try {
			Hero myHero = Getter.getAHero("Damaged Hero");
			EffectHandler eh = new EffectHandler();
			System.out.println("Original: " + myHero.getSecondaryStats().getHp());
			eh.addEffect(myHero, new DamageEffect("Damage", "Do damage", 0, true, 10, 0, 0, 0));
			System.out.println("After one instantApply: " + myHero.getSecondaryStats().getHp());
			eh.addEffect(myHero, new DamageEffect("Damage", "Do damage", 3, 0, 10, 0, 0));
			eh.addEffect(myHero, new DamageEffect("FlatDamageTicks", "Do damage", 4, 10, 0, 0, 0));
			System.out.println("After adding two dots: " + myHero.getSecondaryStats().getHp());
			eh.applyAllEffects();
			System.out.println("After applying dots once: " + myHero.getSecondaryStats().getHp());
			eh.applyAllEffects();
			System.out.println("After applying dots twice: " + myHero.getSecondaryStats().getHp());
			eh.applyAllEffects();
			System.out.println("After applying dots thrice: " + myHero.getSecondaryStats().getHp());
			eh.applyAllEffects();
			System.out.println("After first dot has been removed: " + myHero.getSecondaryStats().getHp());
			eh.applyAllEffects();
			System.out.println("After second dot has been removed: " + myHero.getSecondaryStats().getHp());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
