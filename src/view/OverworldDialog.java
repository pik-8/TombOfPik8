package view;

import constants.ConfigKeys;
import constants.balancing.Levels;
import constants.view.OverWorldSceneProperties;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import model.dungeon.Difficulty;
import model.dungeon.DifficultyFactory;
import model.dungeon.Dungeon;
import model.dungeon.DungeonFactory;
import model.overworld.Info;
import model.overworld.Overworld;
import view.scenes.OverWorldScene;
import view.scenes.SceneManager;

import java.util.Properties;
import java.util.Random;

public class OverworldDialog extends Dialog<ButtonType> {

    public OverworldDialog (Properties property, int numberOfLevel, Overworld overworld, Scene currentScene) {
        boolean hasProperties = false;
        try {
            property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_5);
            hasProperties = true;
        } catch (Exception exception) {}

        if (hasProperties) {
            ButtonType enterButton = new ButtonType(property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_ENTER_DUNGEON_BUTTON), ButtonBar.ButtonData.OK_DONE);
            ButtonType exitButton = new ButtonType(property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_REFUSE_BUTTON), ButtonBar.ButtonData.NO);
            this.getDialogPane().getButtonTypes().addAll(enterButton, exitButton);
            this.setContentText(
                    property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_1)
                            + numberOfLevel + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_2)
                            + overworld.getLandscapesOfCurrentLevel(numberOfLevel) + "\n"
                            + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_3)
                            + overworld.getDifficultyOfCurrentLevel(numberOfLevel)
                            + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_4)
                            + overworld.getSeedOfLastLevel(numberOfLevel)
                            + property.getProperty(ConfigKeys.OVERWORLD_KEY_FOR_DIALOG_TEXT_5)
            );
        } else {
            ButtonType enterButton = new ButtonType(OverWorldSceneProperties.STANDARD_TEXT_DIALOG_ENTER_DUNGEON, ButtonBar.ButtonData.OK_DONE);
            ButtonType exitButton = new ButtonType(OverWorldSceneProperties.STANDARD_TEXT_DONT_ENTER_DUNGEON, ButtonBar.ButtonData.NO);
            this.getDialogPane().getButtonTypes().addAll(enterButton, exitButton);
            this.setContentText(
                    OverWorldSceneProperties.STANDARD_DIALOG_TEXT_1
                            + numberOfLevel + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_2
                            + overworld.getLandscapesOfCurrentLevel(numberOfLevel - Levels.INDEX_OF_FIRST_LEVEL) + "\n"
                            + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_3
                            + overworld.getDifficultyOfCurrentLevel(numberOfLevel - Levels.INDEX_OF_FIRST_LEVEL)
                            + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_4
                            + overworld.getSeedOfLastLevel(numberOfLevel - Levels.INDEX_OF_FIRST_LEVEL)
                            + OverWorldSceneProperties.STANDARD_DIALOG_TEXT_5
            );
        }

        this.showAndWait().ifPresent(response -> {
            if (response.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                int seed = new Random().nextInt();
                Difficulty difficulty = DifficultyFactory.getDifficultyFactory().getEasyDifficulty();
                //TODO change the difficulty to a dynamic variation.
                Dungeon dungeon = new DungeonFactory().generateRandomDungeon(Levels.LEVEL_1_WIDTH, Levels.LEVEL_1_HEIGHT, Levels.LEVEL_1_TILES, Levels.LANDSCAPES_OF_LEVEL[numberOfLevel], Levels.START_POSITION);

                overworld.setLastDungeon(new Info(Levels.LANDSCAPES_OF_LEVEL[numberOfLevel], seed, difficulty), numberOfLevel);
                new SceneManager().loadScene(dungeon, currentScene);
            }
        });
    }
}
