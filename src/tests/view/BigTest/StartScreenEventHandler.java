package tests.view.BigTest;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class StartScreenEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.exit(69);
    }

}
