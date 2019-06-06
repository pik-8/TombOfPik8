package view.events;

import constants.view.DungeonSceneProperties;
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
        double movingValue;
        switch (event.getCode()){
            case LEFT:
                movingValue = DungeonSceneProperties.NORMAL_MOVING_DISTANCE_X / scene.getDungeonLayout().getScaleX();
                scene.getDungeonLayout().setTranslateX(scene.getDungeonLayout().getTranslateX() + movingValue);
                break;
            case RIGHT:
                movingValue = DungeonSceneProperties.NORMAL_MOVING_DISTANCE_X / scene.getDungeonLayout().getScaleX();
                scene.getDungeonLayout().setTranslateX(scene.getDungeonLayout().getTranslateX() - movingValue);
                break;
            case DOWN:
                movingValue = DungeonSceneProperties.NORMAL_MOVING_DISTANCE_Y / scene.getDungeonLayout().getScaleY();
                scene.getDungeonLayout().setTranslateY(scene.getDungeonLayout().getTranslateY() -movingValue);
                break;
            case UP:
                movingValue = DungeonSceneProperties.NORMAL_MOVING_DISTANCE_Y / scene.getDungeonLayout().getScaleY();
                scene.getDungeonLayout().setTranslateY(scene.getDungeonLayout().getTranslateY() + movingValue);
                break;
            case ESCAPE:
                SceneManager.getSceneManager().loadScene(Scenes.TITLE_SCENE, scene);
        }
        event.consume();
    }
}
