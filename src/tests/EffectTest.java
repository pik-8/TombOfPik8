package tests;

import control.EffectHandler;
import model.characters.Hero;
import model.effects.DamageEffect;

public class EffectTest {

	public static void main(String[] args) {
		testDamageEffect();
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
			eh.applyCharacterEffects();
			System.out.println("After applying dots once: " + myHero.getSecondaryStats().getHp());
			eh.applyCharacterEffects();
			System.out.println("After applying dots twice: " + myHero.getSecondaryStats().getHp());
			eh.applyCharacterEffects();
			System.out.println("After applying dots thrice: " + myHero.getSecondaryStats().getHp());
			eh.applyCharacterEffects();
			System.out.println("After first dot has been removed: " + myHero.getSecondaryStats().getHp());
			eh.applyCharacterEffects();
			System.out.println("After second dot has been removed: " + myHero.getSecondaryStats().getHp());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
