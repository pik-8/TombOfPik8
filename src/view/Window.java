package view;

import constants.view.DefaultTextureSize;
import javafx.collections.ObservableList;
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
        setScaleWidthOfChildren(((Pane) this.getScene().getRoot()).getChildren(), ratioWidth);
    }

    private void setScaleWidthOfChildren (ObservableList<Node> children, double ratio) {
        for (Node element : children) {
            if (element.getClass() == ImageView.class) {
                ((ImageView) element).setFitWidth(((ImageView) element).getImage().getWidth() / ratio);
            } else if (element.getClass() == Pane.class) {
                setScaleWidthOfChildren(((Pane) element).getChildren(), ratio);
            } else {
                System.out.println(element.getClass());
            }
        }
    }

    private void setScaledHeight(double height) {
        double ratioHeight = DefaultTextureSize.height / height;
        setScaleHeightOfChildren(((Pane) this.getScene().getRoot()).getChildren(), ratioHeight);
    }

    private void setScaleHeightOfChildren (ObservableList<Node> children, double ratio) {
        for (Node element : children) {
            if (element.getClass() == ImageView.class) {
                ((ImageView) element).setFitHeight(((ImageView) element).getImage().getHeight() / ratio);
            } else if (element.getClass() == Pane.class) {
                setScaleHeightOfChildren(((Pane) element).getChildren(), ratio);
            } else {
                System.out.println(element.getClass());
            }
        }
    }

    private void setScaledXPosition(double ratio) {
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            if (element.getClass() != Pane.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
            } else {
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }

    private void setScaleXPositionOfChildren (ObservableList<Node> children, double ratio) {
        for (Node element : children) {
            if (element.getClass() != Pane.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
            } else {
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }




    private void setScaledYPosition(double ratio) {
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            if (element.getClass() != Pane.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
            } else {
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }

    private void setScaleYPositionOfChildren (ObservableList<Node> children, double ratio) {
        for (Node element : children) {
            if (element.getClass() != Pane.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
            } else {
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }
}
