package view.scenes;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ImagePaths;
import constants.ModelProperties;
import constants.balancing.Levels;
import constants.view.DefaultTextureSize;
import constants.view.OverWorldSceneProperties;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.other.GameLoaderSaver;
import model.other.SaveState;
import model.overworld.Overworld;
import view.OverworldDialog;
import view.events.OverworldKeyEvent;

import java.io.FileInputStream;
import java.util.Properties;


/**
 * This scene is the overworld, a place where the player can choose, which levels it wants to play.
 *
 * @author Hagen
 */
public class OverWorldScene extends GameScene {

    private Pane mapAndLevel;
    private ImageView map;
    private String languageKey;
    private Properties sceneProperties;

    public OverWorldScene(String saveState, double width, double height) {
        super();
        this.mapAndLevel = new Pane();
        this.map = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_BACKGROUND));
        this.map.setFitHeight(this.map.getImage().getHeight() / (DefaultTextureSize.HEIGHT / height));
        this.map.setFitWidth(this.map.getImage().getWidth() / (DefaultTextureSize.WIDTH / width));

        Properties gameConfig = new Properties();
        this.sceneProperties = new Properties();
        try {
            gameConfig.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
            this.languageKey = gameConfig.getProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE);
            if (this.languageKey != null) {
                String path = FileConstants.PATH_TO_LANGUAGES
                        + "/" + this.languageKey + FileConstants.PATH_TO_OVERWORLD_SCENE_CONFIG;
                this.sceneProperties.load(new FileInputStream(path));
            }
        } catch (Exception e) {}

        setEvents();
        this.mapAndLevel.getChildren().add(map);

        initLevels(new GameLoaderSaver().getSaveState(saveState), width, height);

        ((Pane) this.getRoot()).getChildren().addAll(this.mapAndLevel);
    }


    private void initLevels (SaveState saveState, double width, double height) {
        Overworld overworld = saveState.getOverworld();


        for (int i = Levels.INDEX_OF_FIRST_LEVEL; i <= Levels.NUMBER_OF_LEVELS; i++) {
            ImageView level = getLevelImage(overworld, i);

            double ratioWidth = DefaultTextureSize.WIDTH / width;
            double ratioHeight = DefaultTextureSize.HEIGHT / height;

            level.setFitWidth(level.getImage().getWidth() / ratioWidth);
            level.setFitHeight(level.getImage().getHeight() / ratioHeight);

            level.setTranslateX(OverWorldSceneProperties.POSITION_OF_LEVELS[i - Levels.INDEX_OF_FIRST_LEVEL][0] / ratioWidth);
            level.setTranslateY(OverWorldSceneProperties.POSITION_OF_LEVELS[i - Levels.INDEX_OF_FIRST_LEVEL][1] / ratioHeight);

            final int numberOfLevel = i;
            level.setOnMouseClicked(e -> {
                new OverworldDialog(sceneProperties, numberOfLevel, overworld, this);
            });

            this.mapAndLevel.getChildren().add(level);
        }
    }


    private ImageView getLevelImage (Overworld overworld, int index) {

        if (overworld.getLandscapesOfLastLevel(index) == null) {
            return new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_NOT_TRIED_LEVEL));
        } else {
            return new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_BEATEN_LEVEL));
        }
    }


    private void setEvents () {
        this.setOnKeyPressed(new OverworldKeyEvent());
    }


    public Pane getMapAndLevel() {
        return mapAndLevel;
    }

    @Override
    public void closeScene() {

    }
}
