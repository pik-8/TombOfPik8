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


    private static SceneManager sceneManager;
    private StartScene startScene;

    private SceneManager () {}


    public static SceneManager getSceneManager () {
        if (sceneManager == null) {
            sceneManager = new SceneManager();
        }
        return sceneManager;
    }

    public void startGame (double width, double height) {
        TitleScene titleScene = new TitleScene(width, height);
        setEvents(titleScene);
        GUIController.getActiveGuiController().setScene(titleScene);
        GUIController.getActiveGuiController().getStage().show();

        new Thread(() -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    startScene = new StartScene(width, height);
                }
            });
        }).start();
    }

    private void setEvents (TitleScene titleScene) {
        titleScene.setOnMouseClicked(e -> {
            this.startScene.reSizeAndRePlace(GUIController.getActiveGuiController().getStage().getWidth(), GUIController.getActiveGuiController().getStage().getHeight());
            GUIController.getActiveGuiController().setScene(this.startScene);
        });

        titleScene.setOnKeyPressed(e -> {
            this.startScene.reSizeAndRePlace(GUIController.getActiveGuiController().getStage().getWidth(), GUIController.getActiveGuiController().getStage().getHeight());
            GUIController.getActiveGuiController().setScene(this.startScene);
        });
    }

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
            case SAVE_STATE_SELECTION_SCENE:
                new Thread(() -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            GUIController.getActiveGuiController().setScene(new SaveStateSelectionScene(currentScene.getWidth(), currentScene.getHeight()));
                            loadingScene.closeScene();
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
                            loadingScene.closeScene();
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
                            GUIController.getActiveGuiController().setScene(new StartScene(currentScene.getWidth(), currentScene.getHeight()));
                            loadingScene.closeScene();
                        }
                    });
                }).start();
        }
    }


    public void loadScene (Dungeon dungeon, Scene currentScene) {
        LoadingScene loadingScene = showLoadingScene(currentScene.getWidth(), currentScene.getHeight());

        new Thread(() -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    GUIController.getActiveGuiController().setScene(new DungeonScene(dungeon, currentScene.getWidth(), currentScene.getHeight()));
                    loadingScene.closeScene();
                }
            });
        }).start();
    }


    public void loadScene (String saveState, Scene currentScene) {
        LoadingScene loadingScene = showLoadingScene(currentScene.getWidth(), currentScene.getHeight());

        new Thread(() -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    GUIController.getActiveGuiController().setScene(new OverWorldScene(saveState, currentScene.getWidth(), currentScene.getHeight()));
                    loadingScene.closeScene();
                }
            });
        }).start();
    }


    private LoadingScene showLoadingScene (double width, double height) {
        LoadingScene loadingScene = new LoadingScene(width, height);
        GUIController.getActiveGuiController().setScene(loadingScene);
        return loadingScene;
    }
}
