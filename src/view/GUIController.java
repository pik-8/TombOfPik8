package view;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ModelProperties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.options.Options;
import view.scenes.TitleScene;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * This class has the Window in it and therefore the whole GUI.
 *
 * @author Hagen
 */
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
        Scene scene = new TitleScene(this.stage.getWidth(), this.stage.getHeight());

        this.setScene(scene);
        this.stage.setScene(scene);
        this.stage.setTitle(ModelProperties.WINDOW_TITLE);

        try {
            Properties configs = new Properties();
            configs.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
            primaryStage.setWidth(Double.valueOf(configs.getProperty(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW)));
            primaryStage.setHeight(Double.valueOf(configs.getProperty(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW)));
        } catch (IOException ioException) {
            System.out.println(ioException);
            primaryStage.setWidth(ModelProperties.STANDARD_WINDOW_WIDTH);
            primaryStage.setHeight(ModelProperties.STANDARD_WINDOW_HEIGHT);
        }
        this.stage.show();
    }
    
    public void checkOptions() {
    	if(Options.getActiveOptions().hasRecentlyChanged()) {
			this.stage.setHeight(Options.getActiveOptions().getWindowHeight());
			this.stage.setWidth(Options.getActiveOptions().getWindowWidth());
			Options.getActiveOptions().changeApplied();
		}
    }

    public Stage getStage() {
        return stage;
    }


    public void update () {
        this.stage.setTitle("Changed");
        checkOptions();
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
