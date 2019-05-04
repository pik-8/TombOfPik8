package tests.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.File;

public class Experiment extends Application implements EventHandler<ActionEvent> {

    private static Image[] flames;
    private static ImageView flameView;
    private static int index;

    private static Stage window;
    private static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Test stuff");


        HBox hbox = new HBox();



        File[] alFlamesFile = new File("resources/images/test/flames/").listFiles();
        flames = new Image[alFlamesFile.length];
        for (int i = 0; i < flames.length; i++) {
            flames[i] = new Image("file:" + alFlamesFile[i].getPath());
        }

        flameView = new ImageView();
        index = 0;
        flameView.setImage(flames[index]);

        Button button = new Button();
        button.setTranslateX(100);
        button.setGraphic(flameView);

        hbox.getChildren().addAll(button, flameView);


        scene = new Scene(hbox, 1500, 1000);


        window.setScene(scene);
        window.show();


        button.setOnAction(this);
    }


    @Override
    public void handle(ActionEvent event) {
        if (index < flames.length -1) {
            index++;
                flameView.setImage(flames[index]);
        } else {
            index =0;
            flameView.setImage(flames[index]);
        }
        System.out.println("Changed image");
        updateScene();
    }

    private static void updateScene () {
        //scene.setRoot(new HBox(flameView));
        //window.setScene(scene);
        //window.show();
    }
}
