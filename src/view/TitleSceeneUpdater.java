package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TitleSceeneUpdater implements EventHandler<Event> {

    @Override
    public void handle(Event event) {
        System.out.println("Clicked");
        Stage currentWindow = GUIController.getActiveGuiController().getStage();
        try {
            currentWindow.setScene(new Scene(SceneLoader.getLayoutFromFXML()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
