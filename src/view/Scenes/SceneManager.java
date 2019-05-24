package view.Scenes;

import javafx.application.Platform;
import javafx.scene.Scene;
import model.dungeon.Dungeon;
import view.GUIController;


public class SceneManager {


    /**
     * The default is the title scene.
     * @param scene
     * @param currentScene
     */
    public void loadScene (Scenes scene, Scene currentScene) {
        showLoadingScene(currentScene.getWidth(), currentScene.getHeight());
        switch (scene){
            case TITLE_SCENE:
                new Thread(() -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            GUIController.getActiveGuiController().setScene(new TitleScene(currentScene.getWidth(), currentScene.getHeight()));
                        }
                    });
                }).start();
                break;
            case OPTIONS_SCENE:
                new Thread(() -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            GUIController.getActiveGuiController().setScene(new OptionScene(currentScene.getWidth(), currentScene.getHeight()));
                        }
                    });
                }).start();
                break;
            case OVERWORLD_SCENE:
                //showLoadingScene();
                break;
            default:
                new Thread(() -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            GUIController.getActiveGuiController().setScene(new OptionScene(currentScene.getWidth(), currentScene.getHeight()));
                        }
                    });
                }).start();
        }
    }


    public void loadDungeonScene (Dungeon dungeon, Scene currentScene) {
        showLoadingScene(currentScene.getWidth(), currentScene.getHeight());

        new Thread(() -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    GUIController.getActiveGuiController().setScene(new DungeonScene(dungeon, currentScene.getWidth(), currentScene.getHeight()));
                }
            });
        }).start();
    }


    public void showLoadingScene (double width, double height) {
        LoadingScene loadingScene = new LoadingScene(width, height);
        GUIController.getActiveGuiController().setScene(loadingScene);
    }

    private void showDungeon (Dungeon dungeon) {
        Scene dungeonScene = new DungeonScene(dungeon, GUIController.getActiveGuiController().getStage().getWidth(), GUIController.getActiveGuiController().getStage().getHeight());
        GUIController.getActiveGuiController().setScene(dungeonScene);
    }
}
