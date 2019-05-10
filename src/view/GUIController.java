package view;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ModelProperties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIController extends Application {

    private static GUIController GUIController;

    private Stage stage;
    private Scene scene;

    public GUIController() {
        if (GUIController != null) {
            try {
                GUIController.stop();
            } catch (Exception e) {

            }
        }
        GUIController = this;
    }


    public static GUIController getActiveGameWindow () {
        return GUIController;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.scene = primaryStage.getScene();

        this.stage.setTitle(ModelProperties.WINDOW_TITLE);

        try {
            ConfigReader configReader = new ConfigReader(FileConstants.PATH_TO_GAME_CONFIG);
            primaryStage.setWidth(configReader.getNumberFromConfigFile(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW));
            primaryStage.setHeight(configReader.getNumberFromConfigFile(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW));
            primaryStage.setX(0);
            primaryStage.setY(0);
        } catch (IOException ioException) {
            System.out.println(ioException);
            primaryStage.setWidth(ModelProperties.STANDARD_WINDOW_WIDTH);
            primaryStage.setHeight(ModelProperties.STANDARD_WINDOW_HEIGHT);
            primaryStage.setX(0);
        }
        primaryStage.show();
    }


    public Stage getStage() {
        return stage;
    }


    public void update () {
        this.stage.setTitle("Changed");
    }



    public void setStage(Stage stage) {
        this.stage = stage;
        //this.stage.show();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        this.stage.setScene(this.scene);
    }
}
