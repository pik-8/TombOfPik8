package control;

import model.dungeon.Dungeon;
import model.dungeon.DungeonFactory;
import model.dungeon.Landscape;
import model.dungeon.Position;
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
    	
    	
    	WorldController world = new WorldController();
    	
    	DungeonFactory df = new DungeonFactory();
    	
    	Dungeon basicDungeon = df.generateRandomDungeon(5, 5, 4, new Landscape[] {Landscape.FOREST}, new Position(0, 0));
    	
    	DungeonPrinter.printDungeon(basicDungeon);
    	
    }

//	public static void generateTemplate(Object object) {
//    	GsonBuilder builder = new GsonBuilder()
//    			.registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory());
//		builder.setPrettyPrinting();
//		Gson gson = builder.create();
//		
//		String jsonString = gson.toJson(object);
//		System.out.println(jsonString);
//    }

}
