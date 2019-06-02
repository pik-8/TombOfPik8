package view.events;

import constants.view.SaveStateSelectionSceneProperties;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import view.scenes.DungeonScene;
import view.scenes.OverWorldScene;
import view.scenes.SceneManager;
import view.scenes.Scenes;

public class OverworldKeyEvent implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        OverWorldScene scene = (OverWorldScene) event.getSource();
        switch (event.getCode()){
            case LEFT:
                scene.getMapAndLevel().setTranslateX(scene.getMapAndLevel().getTranslateX() + (scene.getWidth() / SaveStateSelectionSceneProperties.STEPS_TO_MOVE_MAP));
                break;
            case RIGHT:
                scene.getMapAndLevel().setTranslateX(scene.getMapAndLevel().getTranslateX() - (scene.getWidth() / SaveStateSelectionSceneProperties.STEPS_TO_MOVE_MAP));
                break;
            case DOWN:
                scene.getMapAndLevel().setTranslateY(scene.getMapAndLevel().getTranslateY() - (scene.getHeight() / SaveStateSelectionSceneProperties.STEPS_TO_MOVE_MAP));
                break;
            case UP:
                scene.getMapAndLevel().setTranslateY(scene.getMapAndLevel().getTranslateY() + (scene.getHeight() / SaveStateSelectionSceneProperties.STEPS_TO_MOVE_MAP));
                break;
            case ESCAPE:
                new SceneManager().loadScene(Scenes.TITLE_SCENE, scene);
        }
        event.consume();
    }
}
