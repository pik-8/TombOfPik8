package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static Pane getLayoutFromFXML () throws Exception{
        SplitPane spliiti = new SplitPane();
        //Pane pane = spliiti;
        return FXMLLoader.load(GUIController.class.getResource("/view/OptionLayout.fxml"));
    }
}
