package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ModelProperties;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.options.Options;
import view.scenes.SceneManager;


/**
 * This class has the Window in it and therefore the whole GUI.
 *
 * @author Hagen
 */
public class GUIController extends Application {

    private static GUIController guiController;

    private Stage stage;

    private List<Animation> allAnimations;
    private long lastNow;


    public GUIController() {
        if (guiController != null) {
            try {
                guiController.stop();
            } catch (Exception e) {

            }
        }
        guiController = this;
    }


    public static GUIController getActiveGuiController () {
        return guiController;
    }

    @Override
    public void start(Stage primaryStage) {
        this.lastNow = 0;
        this.allAnimations = new ArrayList<>();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long deltaT = lastNow - now;
                lastNow = now;
                guiController.update(deltaT);
                guiController.update();
            }
        };
        animationTimer.start();

        double width;
        double height;
        try {
            Properties configs = new Properties();
            configs.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
            width = (Double.valueOf(configs.getProperty(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW)));
            height = (Double.valueOf(configs.getProperty(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW)));
            this.stage = new Window(width, height);
        } catch (IOException ioException) {
            System.out.println(ioException);
            width = (ModelProperties.STANDARD_WINDOW_WIDTH);
            height = (ModelProperties.STANDARD_WINDOW_HEIGHT);
            this.stage = new Window(width, height);
        }
        this.stage.setTitle(ModelProperties.WINDOW_TITLE);
        SceneManager.getSceneManager().startGame(this.stage.getWidth(), this.stage.getHeight());
    }
    
    public void checkOptions() {
    	if(Options.getActiveOptions().hasRecentlyChanged()) {
			this.stage.setHeight(Options.getActiveOptions().getWindowHeight());
			this.stage.setWidth(Options.getActiveOptions().getWindowWidth());
			Options.getActiveOptions().changeApplied();
		}
    }




    public void update (long deltaT) {
        for (Animation animation : allAnimations) {
            animation.nextImage(deltaT);
        }
    }


    public void removeAnimation (Animation animation) {
        this.allAnimations.remove(animation);
    }


    public void update () {
        //this.stage.setTitle("Changed");
        checkOptions();
    }


    public void setStage(Stage stage) {
        this.stage = stage;
        //this.stage.show();
    }
        
    public void addAnimation (Animation animation) {
        this.allAnimations.add(animation);
    }


    public void stopAllAnimations () {
        for (Animation animation : this.allAnimations) {
            animation.stop();
        }
    }

    public void removeAllAnimations () {
        stopAllAnimations();
        this.allAnimations.clear();
    }



    public Stage getStage() {
        return stage;
    }


    public void setScene(Scene scene) {
        this.getStage().setScene(scene);
    }

}
