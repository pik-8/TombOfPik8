package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.effects.DamageEffect;
import model.fighting.Attack;
import model.fighting.AttackPattern;
import model.dungeon.DungeonFactory;
import model.dungeon.Landscape;
import model.dungeon.Position;
import model.items.Trinket;
import model.items.TrinketFactory;
import model.json.AdapterFactories;
import view.DungeonPrinter;

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
    	int i = 0;
    	TrinketFactory wf = new TrinketFactory();
		System.out.println(i++);
		Trinket wp = wf.generateRandomTrinket(50);


//    	System.out.println("Name: " + wp.getName());
//    	System.out.println("Description: " + wp.getDescription());
//    	System.out.println("Magic Defense: " + wp.getSecStats().getMagicDefence());

    	try {
    		Attack attack = new Attack("Basic Attack", "Hit them.", 100, 100, 100, 1, null, 
    				new AttackPattern(new float[][] {{0,1,0},
    					{0,-1,0}
    				}, new DamageEffect[][] {{null, new DamageEffect(), null},{null, null, null}} ));    		
    		generateTemplate(attack);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	
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
