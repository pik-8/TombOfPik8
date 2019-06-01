package view.events;

import constants.view.DungeonSceneProperties;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import view.scenes.DungeonScene;


/**
 * This class controls what will happen, after a ScrollEvent is activated in the DungeonScene.
 *
 * @author Hagen
 */
public class DungeonSceneScrollEvent implements EventHandler<ScrollEvent> {
    @Override
    public void handle(ScrollEvent event) {
        DungeonScene scene = (DungeonScene) event.getSource();
        if (event.getDeltaY() > 0) {
            if (scene.getDungeonLayout().getScaleX() <= DungeonSceneProperties.MAX_SCALE_OF_DUNGEON) {
                scene.getDungeonLayout().setScaleY(scene.getDungeonLayout().getScaleY() + DungeonSceneProperties.DELTA_FOR_SCROLLING);
                scene.getDungeonLayout().setScaleX(scene.getDungeonLayout().getScaleX() + DungeonSceneProperties.DELTA_FOR_SCROLLING);
            }
        } else {
            if ((scene.getDungeonLayout().getScaleX() - DungeonSceneProperties.DELTA_FOR_SCROLLING) > DungeonSceneProperties.MIN_SCALE_OF_DUNGEON) {
                scene.getDungeonLayout().setScaleY(scene.getDungeonLayout().getScaleY() - DungeonSceneProperties.DELTA_FOR_SCROLLING);
                scene.getDungeonLayout().setScaleX(scene.getDungeonLayout().getScaleX() - DungeonSceneProperties.DELTA_FOR_SCROLLING);
            }
        }
    }
}
