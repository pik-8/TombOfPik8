package view.Scenes;

import constants.ImagePaths;
import constants.view.DefaultTextureSize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LoadingLayout extends Pane {

    private final static String FILE_KEY = "file:";

    public LoadingLayout (double width, double height) {
        ImageView background = new ImageView(new Image(FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_BACKGROUND));
        background.setFitWidth(background.getImage().getWidth() / (DefaultTextureSize.width / width));
        background.setFitHeight(background.getImage().getHeight() / (DefaultTextureSize.height / height));

        this.getChildren().add(background);
    }
}
