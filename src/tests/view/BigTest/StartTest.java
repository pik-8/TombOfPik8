package tests.view.BigTest;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;

public class StartTest extends Application implements EventHandler<WindowEvent> {

    public static void main (String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        //createSceneWithAnimations(primaryStage);
        StartScreen startScreen = new StartScreen(1920, 1080);
        startScreen.show();

    }

    @Override
    public void handle(WindowEvent event) {
        System.exit(69);
    }

    private void createSceneWithAnimations (Stage primaryStage) {
        Stage window = primaryStage;
        window.setTitle("StartScreen");


        HBox hbox = new HBox();
        Pane layout = new Pane();

        window.setOnCloseRequest(this);

        File[] alFlamesFile = new File("resources/images/test/flames/").listFiles();
        Image[] flames = new Image[alFlamesFile.length];
        for (int i = 0; i < flames.length; i++) {
            flames[i] = new Image("file:" + alFlamesFile[i].getPath());
        }

        Animation flameAnimation = new Animation(flames, 6);
        Animation secondFlame = new Animation(flames, 4);

        flameAnimation.setPreserveRatio(true);
        secondFlame.setPreserveRatio(true);

        flameAnimation.setFitHeight(flameAnimation.getHeight() / 2);
        secondFlame.setFitHeight(flameAnimation.getHeight() / 2);
        secondFlame.setTranslateX(0);

        Thread flameThread1 = new Thread(flameAnimation);
        flameThread1.start();
        Thread flameThread2 = new Thread(secondFlame);
        flameThread2.start();

        hbox.getChildren().addAll(flameAnimation, secondFlame);
        layout.getChildren().addAll(flameAnimation, secondFlame);

        Scene scene = new Scene(layout, 1500, 1000);


        window.setScene(scene);
        window.show();
    }
}
