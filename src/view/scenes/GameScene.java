package view.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;


/**
 * This class is the super-class of all scenes in this project.
 * Forces every sub-class to have a closeScene-method, that should stop background process.
 *
 * @author Hagen
 */
public abstract class GameScene extends Scene {

    protected GameScene() {
        super(new Pane());
    }

    protected GameScene (Pane pane) {
        super(pane);
    }


    public abstract void closeScene();
}
