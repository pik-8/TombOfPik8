package tests.view.BigTest;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class StartScreenEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        if (((Button) event.getSource()).getScaleX() != 1) {
            ((Button) event.getSource()).setScaleX(1);
        } else {
            ((Button) event.getSource()).setScaleX(0.1);
        }
        System.out.println(((Button) event.getSource()).getTranslateX());
    }

}
