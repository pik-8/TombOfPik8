package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.effects.DamageEffect;
import model.fighting.Attack;
import model.fighting.AttackPattern;
import model.items.Rarity;
import model.items.Weapon;
import model.items.WeaponFactory;
import model.json.AdapterFactories;

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
    	WeaponFactory wf = new WeaponFactory();
		Weapon wp = wf.generateRandomWeapon(50, Rarity.EPIC);


    	System.out.println("Name: " + wp.getName());
    	System.out.println("Description: " + wp.getDescription());
    	System.out.println("Attack: " + wp.getSecStats().getAttack());
    	System.out.println("Magic Attack: " + wp.getSecStats().getMagicAttack());

//    	try {
//    		Attack attack = new Attack("Basic Attack", "Hit them.", 100, 100, 100, 1, null, 
//    				new AttackPattern(new float[][] {{0,1,0},
//    					{0,-1,0}
//    				}, new DamageEffect[][] {{null, new DamageEffect(), null},{null, null, null}} ));    		
//    		generateTemplate(attack);
//    	} catch (Exception e) {
//    		System.out.println(e.getMessage());
//    	}
    	
//    	DungeonPrinter printer = new DungeonPrinter();
//    	Dungeon dungeon = new DungeonFactory().generateRandomDungeon();
//    	printer.printDungeon(dungeon);
    	
    }


	public static void generateTemplate(Object object) {
    	GsonBuilder builder = new GsonBuilder()
    			.registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		String jsonString = gson.toJson(object);
		System.out.println(jsonString);
    }

}
