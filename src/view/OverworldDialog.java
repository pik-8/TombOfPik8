package view;

import constants.ConfigKeys;
import constants.balancing.Levels;
import constants.view.OverWorldSceneProperties;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import model.dungeon.*;
import model.overworld.Info;
import model.overworld.Overworld;
import view.scenes.SceneManager;

import java.io.File;
import java.util.Properties;
import java.util.Random;


/**
 * This class is for displaying information about a level the player is about to enter.
 * Whole displaying, the everything else stops.
 *
 * @author Hagen
 */
public class OverworldDialog extends Dialog<ButtonType> {

    public OverworldDialog (Properties property, int numberOfLevel, Overworld overworld, Scene currentScene) {
        boolean hasProperties = false;
        try {
            hasProperties = property.propertyNames().hasMoreElements();
        } catch (Exception exception) {}

        if (hasProperties) {
            initDialogWithProperty(property, numberOfLevel, overworld);
        } else {
            initDialogWithDefault (numberOfLevel, overworld);
        }

        this.showAndWait().ifPresent(response -> {
            if (response.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                int seed = new Random().nextInt();
                Difficulty difficulty = DifficultyFactory.getDifficultyFactory().getEasyDifficulty();
                //TODO change the difficulty to a dynamic variation.
                Dungeon dungeon = new DungeonFactory(seed).generateRandomDungeon(Levels.LEVEL_HEIGHTS[numberOfLevel -Levels.INDEX_OF_FIRST_LEVEL], Levels.LEVEL_WIDTHS[numberOfLevel -Levels.INDEX_OF_FIRST_LEVEL], Levels.LEVEL_TILE_SIZE[numberOfLevel - Levels.INDEX_OF_FIRST_LEVEL], Levels.LEVEL_TILE_NUMBER[numberOfLevel -Levels.INDEX_OF_FIRST_LEVEL], Levels.LANDSCAPES_OF_LEVEL[numberOfLevel - Levels.INDEX_OF_FIRST_LEVEL]);

                overworld.setLastDungeon(new Info(Levels.LANDSCAPES_OF_LEVEL[numberOfLevel - Levels.INDEX_OF_FIRST_LEVEL], seed, difficulty), numberOfLevel);
                SceneManager.getSceneManager().loadScene(dungeon, currentScene);
            }
        });
    }

    private void initDialogWithProperty (Properties property, int numberOfLevel, Overworld overworld) {
        ButtonType enterButton = new ButtonType(property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_ENTER_DUNGEON_BUTTON), ButtonBar.ButtonData.OK_DONE);
        ButtonType exitButton = new ButtonType(property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_REFUSE_BUTTON), ButtonBar.ButtonData.NO);
        this.getDialogPane().getButtonTypes().addAll(exitButton, enterButton);
        String landscapes = "";
        for (int i = 0; i < overworld.getLandscapesOfCurrentLevel(numberOfLevel).length; i++) {
                landscapes += overworld.getLandscapesOfCurrentLevel(numberOfLevel)[i].name();
                if ((i + 1) < overworld.getLandscapesOfCurrentLevel(numberOfLevel).length) {
                    landscapes += ", ";
                }
        }

        this.setContentText(
                property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_1)
                        + numberOfLevel + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_2)
                        + landscapes
                        + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_3)
                        + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_4)
                        + overworld.getDifficultyOfCurrentLevel(numberOfLevel).getMobSpawnRate()
                        + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_5)
                        + overworld.getDifficultyOfCurrentLevel(numberOfLevel).getMobLevelRate()
                        + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_6)
                        + overworld.getSeedOfLastLevel(numberOfLevel)
                        + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_7)
        );
    }

    private void initDialogWithDefault (int numberOfLevel, Overworld overworld) {
        ButtonType enterButton = new ButtonType(OverWorldSceneProperties.STANDARD_TEXT_DIALOG_ENTER_DUNGEON, ButtonBar.ButtonData.OK_DONE);
        ButtonType exitButton = new ButtonType(OverWorldSceneProperties.STANDARD_TEXT_DONT_ENTER_DUNGEON, ButtonBar.ButtonData.NO);
        this.getDialogPane().getButtonTypes().addAll(exitButton, enterButton);
        String landscapes = "";
        for (int i = 0; i < overworld.getLandscapesOfCurrentLevel(numberOfLevel).length; i++) {
            landscapes += overworld.getLandscapesOfCurrentLevel(numberOfLevel)[i].name();
            if ((i + 1) < overworld.getLandscapesOfCurrentLevel(numberOfLevel).length) {
                landscapes += ", ";
            }
        }
        this.setContentText(
                OverWorldSceneProperties.STANDARD_DIALOG_TEXT_1
                        + numberOfLevel + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_2
                        + landscapes
                        + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_3
                        + overworld.getDifficultyOfCurrentLevel(numberOfLevel)
                        + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_4
                        + overworld.getDifficultyOfCurrentLevel(numberOfLevel).getMobSpawnRate()
                        + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_5
                        + overworld.getDifficultyOfCurrentLevel(numberOfLevel).getMobLevelRate()
                        + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_6
                        + overworld.getSeedOfLastLevel(numberOfLevel)
                        + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_7
        );
    }

}
