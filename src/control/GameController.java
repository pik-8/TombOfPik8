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
        //this.start();
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
        this.guiController = GUIController.getActiveGuiController();
        Stage start = this.guiController.getStage();
        this.guiController.update();
        //start.setTitle("Changed");
        //this.window.setStage(start);

        run();
    }
}
