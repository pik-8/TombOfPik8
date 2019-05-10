package view;

import javafx.stage.Stage;

public class GameWindow extends Stage {

    private static GameWindow ourInstance;

    public static GameWindow getInstance() {
        if (ourInstance == null) {
            return new GameWindow();
        }
        return ourInstance;
    }

    private GameWindow() {
    }
}
