package view.scenes;

import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.OverWorldSceneProperties;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.other.GameLoaderSaver;
import model.other.SaveState;
import model.overworld.Overworld;
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

        initLevels(new GameLoaderSaver().getSaveState(saveState), width, height);

        ((Pane) this.getRoot()).getChildren().addAll(this.mapAndLevel);
    }


    private void initLevels (SaveState saveState, double width, double height) {
        Overworld overworld = saveState.getOverworld();


        for (int i = 0; i < OverWorldSceneProperties.NUMBER_OF_LEVELS; i++) {
            ImageView level = getLevelImage(overworld, i);

            double ratioWidth = DefaultTextureSize.width/ width;
            double ratioHeight = DefaultTextureSize.height/ height;

            level.setFitWidth(level.getImage().getWidth() / ratioWidth);
            level.setFitHeight(level.getImage().getHeight() / ratioHeight);

            level.setTranslateX(OverWorldSceneProperties.POSITION_OF_LEVELS[i][0] / ratioWidth);
            level.setTranslateY(OverWorldSceneProperties.POSITION_OF_LEVELS[i][1] / ratioHeight);

            level.setOnMouseClicked(e -> {
                System.out.println("Hello");
                Dialog<String> dialog = new Dialog<>();
                dialog.setX(level.getTranslateX());
                dialog.setY(level.getTranslateY());
                dialog.setContentText("asjdaködfjsbghköadfsbhjködf");
            });

            this.mapAndLevel.getChildren().add(level);
        }

    }


    private ImageView getLevelImage (Overworld overworld, int index) {
        /*
        if (overworld.getSeedOfLastLevel(index) == ModelProperties.NO_SEED_NUMBER) {
            return new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_NOT_TRIED_LEVEL));
        } else {
            return new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_BEATEN_LEVEL));
        }
         */
        //TODO trying to find out why it always has a nullpointer-exception. Probably because off the inner class.


        return new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_BEATEN_LEVEL));
    }


    private void setEvents () {
        this.setOnKeyPressed(new OverworldKeyEvent());
    }


    public Pane getMapAndLevel() {
        return mapAndLevel;
    }
}
