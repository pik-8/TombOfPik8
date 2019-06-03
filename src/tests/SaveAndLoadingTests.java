package tests;

import model.options.Options;
import model.options.Volume;
import model.other.GameLoaderSaver;
import model.other.SaveState;


/**
 * A class to test the loading and saving of game components.
 *
 * @author Hagen
 */
public class SaveAndLoadingTests {

    public static void main (String[] args) throws Exception {
        String testFileName = "TEST.pik";

        //saveATestState(testFileName); //Success
        //deleteSaveState(testFileName); //Success
        //testLoadingAllSaveStates(); //Success

        //getAllFileNames(); //Success
        //getAOption(); //Failure
        //saveTheOptions(); //Failure, maybe because Option and Volume are not object-orientated.
    }


    /**
     * A test to see if the method can give every name of files in an folder.
     */
    private static void getAllFileNames () {
        System.out.println("Printing every file name saveState folder:\n");

        GameLoaderSaver gameLoaderSaver = new GameLoaderSaver();
        String[] names = gameLoaderSaver.getNameOfAllSaveStates();
        for (String name : names) {
            System.out.println(name);
        }
    }


    /**
     * A test that will generate (or overwrite) a file, in which a SaveState-Object is saved as a JSon-String.
     */
    private static void saveATestState (String fileName) throws Exception{
        System.out.println("To see if the test was successful, look into the file.");

        GameLoaderSaver gameLoaderSaver = new GameLoaderSaver();
        gameLoaderSaver.saveSaveState(Getter.getASaveState("Test"), fileName);
    }


    /**
     * A test to see if an Option-Object can be saved in a file
     */
    private static void saveTheOptions () throws Exception {
        //TODO
        /*
        System.out.println("To see if the test was successful, look into the file.");

        Options option = new Options();
        Volume volume = new Volume();
        volume.setEffectVolumeValue(12);
        option.setVolume(volume);
        GameLoaderSaver gameLoaderSaver = new GameLoaderSaver();
        gameLoaderSaver.saveOptions(option);

         */
    }


    /**
     * A test to see if it is possible to delete a file containing a save-state.
     */
    private static void deleteSaveState (String fileName) {
        System.out.println("To see if the test was successful, look into the folder.");
        GameLoaderSaver gameLoaderSaver = new GameLoaderSaver();
        gameLoaderSaver.deleteSaveState(fileName);
    }


    /**
     * A test to get every save-state for the game.
     */
    private static void testLoadingAllSaveStates () {
        System.out.println("All saveStates:\n");

        GameLoaderSaver gameLoaderSaver = new GameLoaderSaver();
        SaveState[] allSaveStates = gameLoaderSaver.getAllSaveStates();

        for (SaveState state : allSaveStates) {
            System.out.println(state.getPlayer().getName());
        }

    }


    /**
     * A test to get the Option-Object for the game.
     */
    private static void getAOption () {
        System.out.println("the options of the game:\n");

        GameLoaderSaver gameLoaderSaver = new GameLoaderSaver();
        System.out.println(gameLoaderSaver.getOption());
    }
}
