package tests;

import model.characters.MobSpawner;

public class CharacterTests {

    public static void main (String args[]) throws Exception {
        //createAHero();
        createAMob();
    }


	public static void createAHero () throws Exception {
        System.out.println(Getter.getAHero("Deku"));
    }

	private static void createAMob() {
		MobSpawner ms = new MobSpawner(5, 10);
		model.characters.Character mob = ms.spawnMob();
		System.out.println("Mob: " + 
				"\nName: " + mob.getName() +
				"\nExp: " + mob.getExp() +
				"\nAttacks: " + mob.getAttacks()[0].toString());
	}
}
