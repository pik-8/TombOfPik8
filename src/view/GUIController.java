package view;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ModelProperties;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.scenes.TitleScene;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * This class has the Window in it and therefore the whole GUI.
 *
 * @author Hagen
 */
public class GUIController extends Application {

    private static GUIController guiController;

    private Stage stage;
    private Scene scene;

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
            }
        };
        animationTimer.start();

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

        //AnimationHandler.getAnimationHandler().start();
    }





    public void update (long deltaT) {
        for (Animation animation : allAnimations) {
            animation.nextImage(deltaT);
        }
    }


    public void removeAnimation (Animation animation) {
        this.allAnimations.remove(animation);
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


    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        this.stage.setScene(this.scene);
    }
}
