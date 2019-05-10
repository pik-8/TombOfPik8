package control;

import javafx.stage.Stage;
import view.GUIController;

public class GameController extends Thread{

    private static GameController gameController;


    private GUIController window;

    public static GameController getGameController() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }


    private GameController () {}


    public void startGame () {
        this.start();
        GUIController.launch(GUIController.class);
    }

    @Override
    public void run () {
        try {
            sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("hello");
        this.window = GUIController.getActiveGameWindow();
        Stage start = this.window.getStage();
        this.window.update();
        //start.setTitle("Changed");
        //this.window.setStage(start);

        run();
    }
}
