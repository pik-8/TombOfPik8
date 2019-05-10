package control;

import javafx.application.Application;
import javafx.stage.Stage;
import model.characters.Hero;
import model.characters.HeroClass;
import model.dungeon.DifficultyFactory;
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
        GameController controller = GameController.getGameController();
        controller.startGame();
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

	/*
	WorldHandler world = new WorldHandler();

    	DungeonFactory df = new DungeonFactory();

    	Dungeon basicDungeon = df.generateRandomDungeon( 20, 2, 4, new Landscape[] {Landscape.FOREST}, new Position(10, 0));
    	model.characters.Character[][] mobs = df.getMobLayout(new DifficultyFactory().getRandomDifficulty(), basicDungeon, 10);

    	Hero fred = Hero.createHero("Ceebly", HeroClass.WARRIOR);
    	Hero hagen = Hero.createHero("Ter-4-f", HeroClass.MAGE);
    	Hero patrick = Hero.createHero("fachinformatiker", HeroClass.ASSASSIN);

    	DungeonHandler dc = new DungeonHandler(new Hero[]{fred, hagen, patrick}, basicDungeon, mobs);
    	DungeonPrinter.printDungeon(basicDungeon, dc.generateCharacterLayout());
	 */
}
