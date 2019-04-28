package model.other;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.io.TemplateReader;

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
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveSaveState (SaveState saveState, String saveSlot) throws IOException {
        this.gson.toJson(saveState, new FileWriter(constants.FileConstants.PATH_TO_SAVE_STATES + saveSlot));
    }

    public SaveState[] getAllSaveStates () {
        File[] listOfFiles = new File(constants.FileConstants.PATH_TO_SAVE_STATES).listFiles();

        SaveState[] saveStates = new SaveState[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++) {
            try {
                saveStates[i] = this.gson.fromJson(
                        TemplateReader.readTemplateAsJsonObject(listOfFiles[i]), SaveState.class);
            } catch (Exception e) {
                saveStates[i] = null;
            }
        }

        return saveStates;
    }
}
