package model.other;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.FileConstants;
import model.io.TemplateReader;
import model.json.AdapterFactories;
import model.options.Options;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A class that can load and save save-states from and to a file in json format.
 *
 * @author Hagen
 */
public class GameLoaderSaver {

    private Gson gson;

    public GameLoaderSaver () {
        this.gson = new GsonBuilder().registerTypeAdapterFactory(AdapterFactories.getEffectAdapterFactory()).setPrettyPrinting().create();
    }


    /**
     * Saves the given SaveState-Object in a file with the given name.
     * If the file does not exist, it willl be generated, if it does exist, it will be overwritten.
     *
     * To see where it will be saved, look in constants.FileConstants.PATH_TO_SAVE_STATES
     *
     * @param saveState
     * @param saveSlot: The file name, the path is predefined.
     * @throws IOException
     */
    public void saveSaveState (SaveState saveState, String saveSlot) throws IOException {
        String object = this.gson.toJson(saveState);
        FileWriter fileWriter = new FileWriter(constants.FileConstants.PATH_TO_SAVE_STATES + saveSlot);
        fileWriter.write(object);
        fileWriter.close();
    }


    public Options getOption () {
        return this.gson.fromJson(TemplateReader.readTemplateAsJsonObject(FileConstants.PATH_TO_SAVING_OPTION),
                Options.class);
    }

    public void saveOptions (Options options) throws IOException{
        this.gson.toJson(options, new FileWriter(FileConstants.PATH_TO_SAVING_OPTION));
    }


    public SaveState[] getAllSaveStates () {
        File[] listOfFiles = new File(constants.FileConstants.PATH_TO_SAVE_STATES).listFiles();

        SaveState[] saveStates = new SaveState[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++) {
            try {
                saveStates[i] = this.gson.fromJson(
                        TemplateReader.readTemplateAsJsonObject(listOfFiles[i]), SaveState.class);
            } catch (Exception e) {
                System.out.println(e);
                saveStates[i] = null;
            }
        }

        return saveStates;
    }


    /**
     *
     * @return The SaveState inside the file or null if a SaveState could not be created.
     */
    public SaveState getSaveState (String fileName) {
        File saveFile = new File(FileConstants.PATH_TO_SAVE_STATES + "/" +  fileName);
        try {
            return this.gson.fromJson(
                    TemplateReader.readTemplateAsJsonObject(saveFile), SaveState.class);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public String[] getNameOfAllSaveStates () {
        File[] allFiles = new File(FileConstants.PATH_TO_SAVE_STATES).listFiles();
        String[] allNames = new String[allFiles.length];
        for (int i = 0; i < allFiles.length; i++) {
            allNames[i] = allFiles[i].getName();
        }
        return allNames;
    }

    public void deleteSaveState (String fileName) {
        new File(constants.FileConstants.PATH_TO_SAVE_STATES + fileName).delete();
    }
}
