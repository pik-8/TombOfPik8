package view.scenes;

import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.other.GameLoaderSaver;
import model.other.SaveState;
import view.events.OverworldKeyEvent;

public class OverWorldScene extends Scene {

    private Pane mapAndLevel;
    private ImageView map;

    public OverWorldScene(String saveState, double width, double height) {
        super(new Pane());
        this.mapAndLevel = new Pane();
        this.map = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_BACKGROUND));
        this.map.setFitHeight(this.map.getImage().getHeight() / (DefaultTextureSize.height / height));
        this.map.setFitWidth(this.map.getImage().getWidth() / (DefaultTextureSize.width / width));

        //SaveState saveState = new GameLoaderSaver().

        setEvents();
        this.mapAndLevel.getChildren().add(map);
        ((Pane) this.getRoot()).getChildren().addAll(this.mapAndLevel);
    }

    private void setEvents () {
        this.setOnKeyPressed(new OverworldKeyEvent());
    }


    public Pane getMapAndLevel() {
        return mapAndLevel;
    }
}
