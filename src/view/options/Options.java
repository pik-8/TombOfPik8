package view.options;


import constants.FileConstants;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * options view
 *
 * @author Patrick Szalewicz
 */

public class Options extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        Font.loadFont(getClass().getResourceAsStream(FileConstants.OPTIONS_PATH + "/resources/options/Seattle_Avenue.ttf"), 14);
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("exited");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainBorderPane = FXMLLoader.load(Options.class.getResource("main.fxml"));
        primaryStage.setScene(new Scene(mainBorderPane));
        primaryStage.show();

    }

}