package view.events;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import view.scenes.SceneManager;
import view.scenes.Scenes;

public class OptionSceneKeyEvent implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case ESCAPE:
                SceneManager.getSceneManager().loadScene(Scenes.TITLE_SCENE, (Scene) event.getSource());
        }
        event.consume();
    }
}
