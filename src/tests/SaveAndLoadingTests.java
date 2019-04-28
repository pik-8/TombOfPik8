package tests;

import model.characters.Hero;
import model.options.Difficulty;
import model.other.GameLoaderSaver;
import model.other.SaveState;
import model.overworld.Overworld;


/**
 * A class to test the loading and saving of game components.
 */
public class SaveAndLoadingTests {

    public static void main (String[] args) throws Exception {
        String testFileName = "TEST.pik";

        saveATestState(testFileName); //Success
        deleteSaveState(testFileName); //Success
    }


    private static void saveATestState (String fileName) throws Exception{
        GameLoaderSaver saver = new GameLoaderSaver();
        Hero[] party = {Getter.getAHero(), Getter.getAHero()};
        Overworld overworld = new Overworld();
        Difficulty diffi = new Difficulty();
        SaveState state = new SaveState(Getter.getAHero(), party, 1, overworld, diffi);
        saver.saveSaveState(state, fileName);
    }

    private static void deleteSaveState (String fileName) {
        GameLoaderSaver gSave = new GameLoaderSaver();
        gSave.deleteSaveState(fileName);
    }

    private static void testLoadingAllSaveStates () {

    }
}
