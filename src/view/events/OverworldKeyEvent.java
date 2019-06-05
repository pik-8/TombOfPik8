package view.events;

import constants.view.SaveStateSelectionSceneProperties;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import view.scenes.OverWorldScene;
import view.scenes.SceneManager;
import view.scenes.Scenes;


/**
 * This class controls every KeyEvent that is being activated, while a Overworld-scene is in the Window
 *
 * @author Hagen
 */
public class OverworldKeyEvent implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        OverWorldScene scene = (OverWorldScene) event.getSource();
        double position = 0;
        double oneStep = 0;
        switch (event.getCode()){
            case DOWN:
                oneStep = scene.getHeight() / SaveStateSelectionSceneProperties.PARTS_OF_MAP;
                position = scene.getMapAndLevel().getTranslateY() - oneStep;

                double newBottomPoint = position + scene.getMapAndLevel().getHeight();
                if (newBottomPoint < scene.getHeight()) {
                    scene.getMapAndLevel().setTranslateY(scene.getHeight() - scene.getMapAndLevel().getHeight());
                } else {
                    scene.getMapAndLevel().setTranslateY(position);
                }
                break;
            case UP:
                oneStep = scene.getHeight() / SaveStateSelectionSceneProperties.PARTS_OF_MAP;
                position = scene.getMapAndLevel().getTranslateY() + oneStep;

                if (position >= 0) {
                    scene.getMapAndLevel().setTranslateY(0);
                } else {
                    scene.getMapAndLevel().setTranslateY(position);
                }
                break;
            case ESCAPE:
                SceneManager.getSceneManager().loadScene(Scenes.TITLE_SCENE, scene);
        }
        event.consume();
    }
}
