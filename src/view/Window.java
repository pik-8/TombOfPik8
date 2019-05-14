package view;

import constants.view.DefaultTextureSize;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Window extends Stage {



    public Window (Scene scene) {
        this.setScene(scene);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        setX(bounds.getMinX());
        setY(bounds.getMinY());
        setWidth(bounds.getWidth());
        setHeight(bounds.getHeight());

        //this.setScene(new TitleScene(bounds.getWidth(), bounds.getHeight()));


        widthProperty().addListener((obs, oldVal, newVal) -> {
            setScaledWidth((double) newVal);
            setScaledXPosition((double) newVal / (double) oldVal);
        });

        heightProperty().addListener((obs, oldVal, newVal) -> {
            setScaledHeight((double) newVal);
            setScaledYPosition((double) newVal / (double) oldVal);
        });
    }


    private void setScaledWidth(double width) {
        double ratioWidth = DefaultTextureSize.width / width;
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            try {
                ((ImageView) element).setFitWidth(((ImageView) element).getImage().getWidth() / ratioWidth);
            } catch (Exception e) {
                ((ImageView) ((Button) element).getGraphic()).setFitWidth(((ImageView) ((Button) element).getGraphic()).getImage().getWidth() / ratioWidth);
            }
        }
    }

    private void setScaledHeight(double height) {
        double ratioHeight = DefaultTextureSize.height / height;
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            try {
                ((ImageView) element).setFitHeight(((ImageView) element).getImage().getHeight() / ratioHeight);
            } catch (Exception e) {
                Button theButton = (Button) element;
                ImageView image = (ImageView) theButton.getGraphic();
                image.setFitHeight(image.getImage().getHeight() / ratioHeight);
                System.out.println("delta: " + (theButton.getHeight() - image.getFitHeight()));

            }
        }
    }

    private void setScaledXPosition(double ratio) {
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            element.setTranslateX(element.getTranslateX() *ratio);
        }
    }

    private void setScaledYPosition(double ratio) {
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            element.setTranslateY(element.getTranslateY() *ratio);
        }
    }
}
