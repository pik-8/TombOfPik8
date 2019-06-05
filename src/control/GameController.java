package control;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ModelProperties;
import view.GUIController;

import java.io.FileReader;
import java.util.Properties;

public class GameController extends Thread{

    private static GameController gameController;

    private GUIController guiController;
    private String language;

    public static GameController getGameController() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }


    private GameController () {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(FileConstants.PATH_TO_GAME_CONFIG));
            this.language = properties.getProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE);
        } catch (Exception e) {
            System.out.println(e);
            this.language = ModelProperties.STANDARD_LANGUAGE;
        }
    }


    public void startGame () {
        GUIController.launch(GUIController.class);
    }

    public String getLanguage() {
        return language;
    }
}
