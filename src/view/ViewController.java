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
 * This class controls the whole GUI, has the stage in it and a list of every animation.
 * Periodically calls every animation in its list, to change the image.
 *
 * @author Hagen
 */
public class ViewController extends Application {

    private static ViewController viewController;

    private Stage stage;

    private List<Animation> allAnimations;
    private long lastNow;


    public ViewController() {
        if (viewController != null) {
            try {
                viewController.stop();
            } catch (Exception e) {

            }
        }
        viewController = this;
    }


    public static ViewController getViewController() {
        return viewController;
    }

    @Override
    public void start(Stage primaryStage) {
        this.lastNow = 0;
        this.allAnimations = new ArrayList<>();

         new AnimationTimer() {
            @Override
            public void handle(long now) {
                long deltaT = lastNow - now;
                lastNow = now;
                viewController.update(deltaT);
                viewController.update();
            }
        }.start();

        setSize();

        this.stage.setTitle(ModelProperties.WINDOW_TITLE);
        this.stage.setOnCloseRequest(e -> {
            new ExitDialog();
            e.consume();
        });

        SceneManager.getSceneManager().startGame(this.stage.getWidth(), this.stage.getHeight());
    }
    
    public void checkOptions() {
    	if(Options.getActiveOptions().hasRecentlyChanged()) {
    		
    		switch(Options.getActiveOptions().getWindowMode()) {
    		case Windowed:
    			this.stage.setFullScreen(false);
    			this.stage.setMaximized(false);
    			this.stage.setHeight(Options.getActiveOptions().getWindowHeight());
    			this.stage.setWidth(Options.getActiveOptions().getWindowWidth());				
    			break;
    		case Fullscreen:
    			this.stage.setMaximized(false);
    			this.stage.setFullScreen(true);
    			break;
    		case Maximized:
    			this.stage.setFullScreen(false);
    			this.stage.setMaximized(true);
    			break;
    		}
			Options.getActiveOptions().changeApplied();
		}
    }


    private void setSize () {
        double width = 0;
        double height = 0;
        try {
            Properties configs = new Properties();
            configs.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
            width = (Double.valueOf(configs.getProperty(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW,
                    String.valueOf(ModelProperties.STANDARD_WINDOW_WIDTH))));
            height = (Double.valueOf(configs.getProperty(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW,
                    String.valueOf(ModelProperties.STANDARD_WINDOW_HEIGHT))));
        } catch (IOException ioException) {
            System.out.println(ioException);
        }
        this.stage = new Window(width, height);
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
