package view;

import constants.view.DefaultTextureSize;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.options.Options;

import java.awt.*;


/**
 * This class is the only Stage-Class, that will bew used in the project.
 * It automatically resizes the scenes inside of it, when the window itself is being resized.
 *
 * @author Hagen, Frederick Hastedt
 */
public class Window extends Stage {


    public Window (double width, double height) {

        /*
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        setX(bounds.getMinX());
        setY(bounds.getMinY());
        setWidth(bounds.getWidth());
        setHeight(bounds.getHeight());

         */

        setWidth(width);
        setHeight(height);


        widthProperty().addListener((obs, oldVal, newVal) -> {
            setScaledWidth((double) newVal);
            setScaledXPosition((double) newVal / (double) oldVal);
        });

        heightProperty().addListener((obs, oldVal, newVal) -> {
            setScaledHeight((double) newVal);
            setScaledYPosition((double) newVal / (double) oldVal);
        });
    }
    
    public void setDimensions(int width, int height) {
    	setWidth(width);
    	setHeight(height);
    }

    private void setScaledWidth(double width) {
        double ratioWidth = DefaultTextureSize.width / width;
        setScaleWidthOfChildren(((Pane) this.getScene().getRoot()).getChildren(), ratioWidth);
    }

    private void setScaleWidthOfChildren (ObservableList<Node> children, double ratio) {
        for (Node element : children) {
            if (element.getClass() == ImageView.class) {
                ((ImageView) element).setFitWidth(((ImageView) element).getImage().getWidth() / ratio);
            } else if (element.getClass() == Label.class || element.getClass() == Button.class || element.getClass() == Slider.class) {
                element.setScaleX(1 / ratio);
            } else if (element.getClass() == Animation.class) {
                ((Animation) element).setFitWidth(((Animation) element).getImage().getWidth() / ratio);
            }else {
                setScaleWidthOfChildren(((Pane) element).getChildren(), ratio);
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
            } else if (element.getClass() == Label.class || element.getClass() == Button.class || element.getClass() == Slider.class) {
                element.setScaleY(1 / ratio);
            } else if (element.getClass() == Animation.class) {
                ((Animation)element).setFitHeight(((ImageView) element).getImage().getHeight() / ratio);
            } else {
                setScaleHeightOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }

    private void setScaledXPosition(double ratio) {
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            if (element.getClass() != Pane.class && element.getClass() != HBox.class && element.getClass() != VBox.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
            } else if (element.getClass() == VBox.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            } else if (element.getClass() == HBox.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            } else {
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }

    private void setScaleXPositionOfChildren (ObservableList<Node> children, double ratio) {
        for (Node element : children) {
            if (element.getClass() != Pane.class && element.getClass() != HBox.class && element.getClass() != VBox.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
            } else if (element.getClass() == VBox.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            } else if (element.getClass() == HBox.class) {
                element.setTranslateX(element.getTranslateX() *ratio);
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            } else {
                setScaleXPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }




    private void setScaledYPosition(double ratio) {
        for (Node element : ((Pane) this.getScene().getRoot()).getChildren()) {
            if (element.getClass() != Pane.class && element.getClass() != HBox.class && element.getClass() != VBox.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
            } else if (element.getClass() == VBox.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            } else if (element.getClass() == HBox.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            } else {
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }

    private void setScaleYPositionOfChildren (ObservableList<Node> children, double ratio) {
        for (Node element : children) {
            if (element.getClass() != Pane.class && element.getClass() != HBox.class && element.getClass() != VBox.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
            } else if (element.getClass() == VBox.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            } else if (element.getClass() == HBox.class) {
                element.setTranslateY(element.getTranslateY() *ratio);
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            }  else {
                setScaleYPositionOfChildren(((Pane) element).getChildren(), ratio);
            }
        }
    }
}
