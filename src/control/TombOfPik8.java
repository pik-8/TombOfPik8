package control;

import model.items.Rarity;
import model.items.Weapon;
import model.items.WeaponFactory;

/**
 * The project for the Prog2 module, in which we are supposed to create an dungeon-crawler
 * game like the tomb of annihilation.
 *
 * The development progress is splitted into model, view and control.
 *
     * @author Hagen Stoever, Frederick Hastedt, Patrick Szalewicz
 */
public class TombOfPik8 {


    public static void main (String args[]) {
        tests.DungeonTests.testGoThrough();
    	WeaponFactory wf = new WeaponFactory();
    	Weapon wp = wf.generateRandomWeapon(5);
    	System.out.println("Name: " + wp.getName());
    	System.out.println("Description: " + wp.getDescription());
    	System.out.println("Attack: " + wp.getSecStats().getAttack());
    	System.out.println("MagicAttack: " + wp.getSecStats().getMagicAttack());

    }


}
