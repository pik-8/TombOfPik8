package view.scenes;

import javafx.application.Platform;
import javafx.scene.Scene;
import model.dungeon.Dungeon;
import view.GUIController;


/**
 * The scene manager loads new scenes and makes a loading scene while the new scenes is loading.
 *
 * @author Hagen
 */
public class SceneManager {


    /**
     * Loads a scene corresponding to the enum.
     * Also shows a scene that informs the user, that a new scene is loading.
     *
     * @param scene
     * @param currentScene
     */
    public void loadScene (Scenes scene, Scene currentScene) {
        LoadingScene loadingScene = showLoadingScene(currentScene.getWidth(), currentScene.getHeight());
        switch (scene){
            case OPTIONS_SCENE:
                new Thread(() -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            GUIController.getActiveGuiController().setScene(new OptionScene(currentScene.getWidth(), currentScene.getHeight()));
                            stopLoadingScene(loadingScene);
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
                            GUIController.getActiveGuiController().setScene(new TitleScene(currentScene.getWidth(), currentScene.getHeight()));
                            stopLoadingScene(loadingScene);
                        }
                    });
                }).start();
        }
    }


    public void loadScene (Dungeon dungeon, Scene currentScene) {
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


    public LoadingScene showLoadingScene (double width, double height) {
        LoadingScene loadingScene = new LoadingScene(width, height);
        GUIController.getActiveGuiController().setScene(loadingScene);
        return loadingScene;
    }


    private void stopLoadingScene (LoadingScene loadingScene) {
        loadingScene.getAnimation().stop();
    }
}
