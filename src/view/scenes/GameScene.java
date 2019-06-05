package view.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class GameScene extends Scene {

    protected GameScene() {
        super(new Pane());
    }

    protected GameScene (Pane pane) {
        super(pane);
    }


    public abstract void closeScene();
}
