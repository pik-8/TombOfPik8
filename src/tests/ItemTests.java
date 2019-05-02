package tests;

import model.effects.Effect;
import model.items.Armor;
import model.items.ArmorFactory;
import model.items.Rarity;
import model.items.Trinket;
import model.items.TrinketFactory;
import model.items.Weapon;
import model.items.WeaponFactory;

public class ItemTests {

	public static void main(String[] args) {
		generateRandomWeapon();
		generateRandomArmor();
		generateRandomTrinket();
	}

	private static void generateRandomWeapon() {
		WeaponFactory wf = new WeaponFactory();
		Weapon weapon = wf.generateRandomWeapon(5);
		System.out.println("Weapon:"
				+ "\nName: " + weapon.getName()
				+ "\nDescription: " + weapon.getDescription()
				+ "\nAttack: " + weapon.getSecStats().getAttackPower()
				+ "\nMagicAttack: " + weapon.getSecStats().getMagicAttackPower());
		if(!weapon.getOnHitEffects().isEmpty())
			System.out.println("On Hit Effect: " + weapon.getOnHitEffects().get(0).toString());
		System.out.println();
	}

	private static void generateRandomArmor() {
		ArmorFactory af = new ArmorFactory();
		Armor armor = af.generateRandomArmor(5);
		System.out.println("Armor: " +
		"\nName: " + armor.getName() +
		"\nDescription: " + armor.getDescription() +
		"\nSlot: " + armor.getSlot() +
		"\nStats: "+ armor.getSecStats().toString());
		System.out.println();		
	}

	private static void generateRandomTrinket() {
		TrinketFactory tf = new TrinketFactory();
		Trinket trinket = tf.generateRandomTrinket(5);
		System.out.println("Trinket: " + 
		"\nName: " + trinket.getName() +
		"\nDescription: " + trinket.getDescription() +
		"\nStats: " + trinket.getPrimeStats().toString() + "\n" + trinket.getSecStats().toString());
		if(!trinket.getEffects().isEmpty()) {
			for(Effect e : trinket.getEffects())
				System.out.println("Effect: " + e.toString());
		}
	}

}
