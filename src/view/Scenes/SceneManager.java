package view.Scenes;

import constants.ImagePaths;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.dungeon.Dungeon;
import model.dungeon.DungeonFactory;
import view.DungeonPrinter;
import view.GUIController;

import java.awt.*;
import java.sql.SQLOutput;

public class SceneManager {
    private static final String FILE_KEY = "file:";

    public void loadScene (Scenes scene, Scene currentScene) {
        switch (scene){
            case TITLE_SCENE:
                LoadingScene loadingScene = new LoadingScene(Scenes.DUNGEON_SCENE, currentScene.getWidth(), currentScene.getHeight());
                GUIController.getActiveGuiController().setScene(loadingScene);

                new Thread(() -> {
                    DungeonFactory df = new DungeonFactory();
                    Pane layout = DungeonPrinter.printDungeonImage(df.generateRandomDungeon(), currentScene.getWidth(), currentScene.getHeight());
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            loadingScene.setRoot(layout);
                        }
                    });
                }).start();
                break;
            case OPTIONS_SCENE:
                //showLoadingScene();
                break;
            case OVERWORLD_SCENE:
                //showLoadingScene();
                break;
        }

    }

    public void loadDungeonScene (Dungeon dungeon, double width, double height) {
        //showDungeon(dungeon);
    }

    private void showDungeon (Dungeon dungeon) {
        Scene dungeonScene = new DungeonScene(dungeon, GUIController.getActiveGuiController().getStage().getWidth(), GUIController.getActiveGuiController().getStage().getHeight());
        GUIController.getActiveGuiController().setScene(dungeonScene);
    }
}
