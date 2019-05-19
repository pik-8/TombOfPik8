package view;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ModelProperties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Scenes.TitleScene;

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


    public static GUIController getActiveGuiController () {
        return GUIController;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.stage = new Window(scene);
        TitleScene scene = new TitleScene(this.stage.getWidth(), this.stage.getHeight());
        Thread thread = new Thread(scene);
        thread.start();

        this.stage.setScene(scene);
        this.stage.setTitle(ModelProperties.WINDOW_TITLE);

        try {
            ConfigStream configStream = new ConfigStream(FileConstants.PATH_TO_GAME_CONFIG);
            primaryStage.setWidth(configStream.getNumberFromConfigFile(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW));
            primaryStage.setHeight(configStream.getNumberFromConfigFile(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW));
        } catch (IOException ioException) {
            System.out.println(ioException);
            primaryStage.setWidth(ModelProperties.STANDARD_WINDOW_WIDTH);
            primaryStage.setHeight(ModelProperties.STANDARD_WINDOW_HEIGHT);
        }
        this.stage.show();
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
