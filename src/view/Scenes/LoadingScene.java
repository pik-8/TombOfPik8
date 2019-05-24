package view.Scenes;

import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.dungeon.Dungeon;
import model.dungeon.DungeonFactory;
import view.DungeonPrinter;

public class LoadingScene extends Scene{


    private final Scenes scene;

    private final Label label;

    public LoadingScene(Scenes scene, double width, double height) {
        super(new Pane());

        this.label = new Label();



        this.scene = scene;

        ImageView background = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_BACKGROUND));
        background.setFitWidth(background.getImage().getWidth() / (DefaultTextureSize.width / width));
        background.setFitHeight(background.getImage().getHeight() / (DefaultTextureSize.height / height));

        ((Pane) this.getRoot()).getChildren().add(background);
    }
}
