package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.characters.MobSpawner;
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
//    	WeaponFactory wf = new WeaponFactory();
//		Weapon wp = wf.generateRandomWeapon(50);
//
//
//    	System.out.println("Name: " + wp.getName());
//    	System.out.println("Description: " + wp.getDescription());
//    	System.out.println("Attack: " + wp.getSecStats().getAttackPower());
//    	System.out.println("Magic Attack: " + wp.getSecStats().getMagicAttackPower());
    	
    	MobSpawner mf = new MobSpawner(5, 5);
    	System.out.println(mf.spawnMob().toString());

    	    	
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
