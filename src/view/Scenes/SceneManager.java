package view.Scenes;

import constants.ImagePaths;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.dungeon.Dungeon;
import view.GUIController;

import java.awt.*;
import java.sql.SQLOutput;

public class SceneManager {
    private static final String FILE_KEY = "file:";

    public void loadScene (Scenes scene) {
        switch (scene){
            case TITLE_SCENE:
                showLoadingScene();
                break;
            case OPTIONS_SCENE:
                showLoadingScene();
                break;
            case OVERWORLD_SCENE:
                showLoadingScene();
                break;
        }

    }

    public void loadDungeonScene (Dungeon dungeon) {
        showLoadingScene();
        new Thread() {
            @Override
            public void run () {
                try {
                    Thread.sleep(5000);
                    showDungeon(dungeon);
                } catch (Exception w) {

                }
            }
        }.start();
        System.out.println("quak");

    }

    public void showDungeon (Dungeon dungeon) {
        System.out.println("Hello");
        Scene dungeonScene = new DungeonScene(dungeon, GUIController.getActiveGuiController().getStage().getWidth(), GUIController.getActiveGuiController().getStage().getHeight());
        GUIController.getActiveGuiController().setScene(dungeonScene);
    }


    private void showLoadingScene () {
        Pane layout = new Pane(new ImageView(new Image(FILE_KEY + ImagePaths.PATH_TO_LOADING_SCNE_BACKGROUND)));
        Scene loadingScene = new Scene(layout);
        GUIController.getActiveGuiController().setScene(loadingScene);
    }
}
