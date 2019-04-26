package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.effects.HealingEffect;
import model.items.Rarity;
import model.items.Trinket;
import model.items.TrinketFactory;
import model.json.AdapterFactories;
import model.other.PrimeStats;
import model.other.SecondaryStats;

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
        //tests.DungeonTests.testGoThrough();
    	int i = 0;
    	TrinketFactory wf = new TrinketFactory();
		System.out.println(i++);
		Trinket wp = wf.generateRandomTrinket(50);
    	
//    	System.out.println("Name: " + wp.getName());
//    	System.out.println("Description: " + wp.getDescription());
//    	System.out.println("Magic Defense: " + wp.getSecStats().getMagicDefence());

//    	try {
//    		Trinket trinket = new Trinket("Plain Necklace", 
//    				"You found this just laying around. Seems to be mostly worthless.", 
//    				new SecondaryStats(0,0,0,0,0,0,10,10,5,0,0,10,0,0,0), 
//    				Rarity.COMMON,
//    				new HealingEffect(),
//    				new PrimeStats(false, 0, 10, 0,0,0,0,0,0,0,0));    		
////    		generateTemplate(trinket);
//    	} catch (Exception e) {
//    		System.out.println(e.getMessage());
//    	}
    	
    	
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
