package view.options;


import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * options view
 *
 * ToDo:
 * - create FXML file(s) and add it to the view
 * - get window size from model.options.Resolution
 *
 * Done:
 * - add multiple Scenes (main options, volume, resolution, etc)
 *
 * @author Patrick Szalewicz
 */

public class Options extends Application {

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("exited");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainBorderPane = FXMLLoader.load(Options.class.getResource("options.fxml"));
        primaryStage.setScene(new Scene(mainBorderPane));
        primaryStage.show();

    }

}
