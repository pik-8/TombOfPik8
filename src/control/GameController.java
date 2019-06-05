package control;

import javafx.stage.Stage;
import view.GUIController;

public class GameController extends Thread{

    private static GameController gameController;

    private GUIController guiController;

    public static GameController getGameController() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }


    private GameController () {}


    public void startGame () {
        GUIController.launch(GUIController.class);
    }

}
