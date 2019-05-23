package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.Scenes.OptionScene;

public class TitleSceneUpdater implements EventHandler<Event> {

    @Override
    public void handle(Event event) {
        Stage currentWindow = GUIController.getActiveGuiController().getStage();
        try {
            currentWindow.setScene(new OptionScene());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*
    Stage currentWindow = GUIController.getActiveGuiController().getStage();
        try {
            currentWindow.setScene(new Scene(SceneLoader.getLayoutFromFXML()));
        } catch (Exception e) {
            System.out.println(e);
        }
     */
}
