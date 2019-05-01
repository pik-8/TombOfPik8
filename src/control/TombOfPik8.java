package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import constants.FileConstants;
import model.characters.Character;
import model.characters.Inventory;
import model.characters.SecondaryStats;
import model.fighting.Attack;
import model.fighting.Skill;
import model.io.TemplateReader;
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

    	GsonBuilder b = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
    	Gson gson = b.create();
    	Attack attack = gson.fromJson(TemplateReader.readTemplateAsJsonObject(FileConstants.ATTACK_TEMPLATE_PATH + "/BasicAttack.pik"), Attack.class);
    	
		Character chara = new Character("Giant Rat", 
				new Inventory(0, 50), 
				new Attack[] {attack}, 
				new Skill[1],
				new SecondaryStats(20, 2, 20, 2, 5, 0, 10, 0, 5, 0, 0, 0, 0, 4, 1),
				10);    		
		generateTemplate(chara);
    	    	
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
