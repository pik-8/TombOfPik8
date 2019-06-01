package view.events;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import view.scenes.DungeonScene;
import view.scenes.SceneManager;
import view.scenes.Scenes;


/**
 * This class controls every input from a keyboard while a DungeonScene is inside a Window.
 *
 * @author Hagen
 */
public class DungeonSceneKeyEvent implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        DungeonScene scene = (DungeonScene) event.getSource();
        switch (event.getCode()){
            case LEFT:
                scene.getDungeonLayout().setTranslateX(scene.getDungeonLayout().getTranslateX() +100);
                break;
            case RIGHT:
                scene.getDungeonLayout().setTranslateX(scene.getDungeonLayout().getTranslateX() - 100);
                break;
            case DOWN:
                scene.getDungeonLayout().setTranslateY(scene.getDungeonLayout().getTranslateY() -100);
                break;
            case UP:
                scene.getDungeonLayout().setTranslateY(scene.getDungeonLayout().getTranslateY() + 100);
                break;
            case ESCAPE:
                new SceneManager().loadScene(Scenes.TITLE_SCENE, scene);
        }
        event.consume();
    }
}
