package view.scenes;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.OverWorldSceneProperties;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.other.GameLoaderSaver;
import model.other.SaveState;
import model.overworld.Overworld;
import org.omg.IOP.CodecFactory;
import view.events.OverworldKeyEvent;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Optional;
import java.util.Properties;

public class OverWorldScene extends Scene {

    private Pane mapAndLevel;
    private ImageView map;
    private String languageKey;
    private Properties sceneProperties;

    public OverWorldScene(String saveState, double width, double height) {
        super(new Pane());
        this.mapAndLevel = new Pane();
        this.map = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_OVERWORLD_BACKGROUND));
        this.map.setFitHeight(this.map.getImage().getHeight() / (DefaultTextureSize.height / height));
        this.map.setFitWidth(this.map.getImage().getWidth() / (DefaultTextureSize.width / width));

        //SaveState saveState = new GameLoaderSaver().

        Properties gameConfig = new Properties();
        Properties loadingProperity = new Properties();
        try {
            gameConfig.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
            this.languageKey = gameConfig.getProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE);
            if (this.languageKey != null) {
                loadingProperity.load(new FileInputStream(FileConstants.PATH_TO_LANGUAGES
                        + "/" + this.languageKey + FileConstants.PATH_TO_LOADING_SCENES_CONFIG));
            }
        } catch (Exception e) {}

        setEvents();
        this.mapAndLevel.getChildren().add(map);

        initLevels(new GameLoaderSaver().getSaveState(saveState), width, height);

        ((Pane) this.getRoot()).getChildren().addAll(this.mapAndLevel);
    }


    private void initLevels (SaveState saveState, double width, double height) {
        Overworld overworld = saveState.getOverworld();


        for (int i = OverWorldSceneProperties.INDEX_OF_FIRST_LEVEL; i < OverWorldSceneProperties.NUMBER_OF_LEVELS; i++) {
            ImageView level = getLevelImage(overworld, i);

            double ratioWidth = DefaultTextureSize.width/ width;
            double ratioHeight = DefaultTextureSize.height/ height;

            level.setFitWidth(level.getImage().getWidth() / ratioWidth);
            level.setFitHeight(level.getImage().getHeight() / ratioHeight);

            level.setTranslateX(OverWorldSceneProperties.POSITION_OF_LEVELS[i - OverWorldSceneProperties.INDEX_OF_FIRST_LEVEL][0] / ratioWidth);
            level.setTranslateY(OverWorldSceneProperties.POSITION_OF_LEVELS[i - OverWorldSceneProperties.INDEX_OF_FIRST_LEVEL][1] / ratioHeight);

            final int numberOfLevel = i;
            level.setOnMouseClicked(e -> {
                boolean hasProperties = false;
                try {
                    this.sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_5);
                    hasProperties = true;
                } catch (Exception exception) {}

                Dialog<ButtonType> dialog = new Dialog<>();
                if (hasProperties) {
                    ButtonType enterButton = new ButtonType(this.sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_ENTER_DUNGEON_BUTTON), ButtonBar.ButtonData.OK_DONE);
                    ButtonType exitButton = new ButtonType(this.sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_REFUSE_BUTTON), ButtonBar.ButtonData.NO);
                    dialog.getDialogPane().getButtonTypes().addAll(enterButton, exitButton);
                    boolean disabled = false; // computed based on content of text fields, for example
                    //dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
                    dialog.setContentText(
                            sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_1)
                                    + numberOfLevel + sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_2)
                                    + overworld.getLandscapesOfCurrentLevel(numberOfLevel) + "\n"
                                    + sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_3)
                                    + overworld.getDifficultyOfCurrentLevel(numberOfLevel)
                                    + sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_4)
                                    + overworld.getSeedOfLastLevel(numberOfLevel)
                                    + sceneProperties.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_5)
                    );
                } else {
                    ButtonType enterButton = new ButtonType(OverWorldSceneProperties.STANDARD_TEXT_DIALOG_ENTER_DUNGEON, ButtonBar.ButtonData.OK_DONE);
                    ButtonType exitButton = new ButtonType(OverWorldSceneProperties.STANDARD_TEXT_DONT_ENTER_DUNGEON, ButtonBar.ButtonData.NO);
                    dialog.getDialogPane().getButtonTypes().addAll(enterButton, exitButton);
                    dialog.setContentText(
                            OverWorldSceneProperties.STANDARD_DIALOG_TEXT_1
                            + numberOfLevel + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_2
                            + overworld.getLandscapesOfCurrentLevel(numberOfLevel) + "\n"
                            + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_3
                            + overworld.getDifficultyOfCurrentLevel(numberOfLevel)
                            + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_4
                            + overworld.getSeedOfLastLevel(numberOfLevel)
                            + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_5
                    );
                    boolean disabled = false; // computed based on content of text fields, for example
                    //dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
                }


                dialog.showAndWait().ifPresent(response -> {
                    System.out.println(response);
                    if (response.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                        System.out.println("Ok");
                    }
                });
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
}
