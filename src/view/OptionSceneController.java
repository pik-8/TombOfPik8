package view;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class OptionSceneController {

    public void setLayoutToDifficulty (Event event) {
        System.out.println("Clicked too difficulty");
        Button button = (Button) event.getSource();
        Pane layout = (Pane) ((Button) event.getSource()).getParent().getParent();
        VBox[] contentBoxs = new VBox[layout.getChildren().size()];
        for (int i = 0; i < layout.getChildren().size(); i++) {
            if (layout.getChildren().get(i) instanceof VBox) {
                contentBoxs[i]= (VBox) layout.getChildren().get(i);
            }
        }
        VBox difficulty = null;
        for (VBox vBox : contentBoxs) {
            for (Node node : vBox.getChildren()) {
                if (node instanceof Label) {
                    if (((Label)node).getText().contains("Schwierigkeit") ) {
                        difficulty = vBox;
                        break;
                    }
                }
            }
            if (difficulty == null) {
                break;
            }
        }
        for (VBox vBox : contentBoxs) {
            vBox.setTranslateY(-10000);
            vBox.setTranslateY(-10000);
        }

        difficulty.setTranslateX(0);
        difficulty.setTranslateY(100);

    }
}
