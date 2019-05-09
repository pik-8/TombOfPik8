package tests.view.BigTest;

import static constants.ImagePaths.PATH_TO_START_SCREEN_BACKGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_BOTTOM_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_CLOUDS_BACKGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_CLOUDS_FOREGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_LEAF;
import static constants.ImagePaths.PATH_TO_START_SCREEN_LEFT_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_LIGHT_RAYS_BACKGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_LIGHT_RAYS_FOREGROUND;
import static constants.ImagePaths.PATH_TO_START_SCREEN_RIGHT_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_TOP_SPHERE;
import static constants.ImagePaths.PATH_TO_START_SCREEN_TRUNK;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StartScreen extends Stage {

    private final String FILE_KEY = "file:";


    private final ImageView background;
    private final ImageView cloudsBackground;
    private final ImageView cloudsForeground;
    private final ImageView trunk;
    private final ImageView bottomSphere;
    private final ImageView leftSphere;
    private final ImageView rightSphere;
    private final ImageView topSphere;
    private final ImageView leaf;
    private final ImageView lightRaysBackground;
    private final ImageView lightRaysForeground;

    private final ImageView[] allImages;


    private final Button leafButton;

    private final Button[] allButtons;

    private final Pane layout;
    private final Scene scene;

    public StartScreen () {
        this.background = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_BACKGROUND));
        this.cloudsBackground = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_CLOUDS_BACKGROUND));
        this.cloudsForeground = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_CLOUDS_FOREGROUND));
        this.trunk = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_TRUNK));
        this.leaf = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_LEAF));
        this.bottomSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_BOTTOM_SPHERE));
        this.leftSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_LEFT_SPHERE));
        this.rightSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_RIGHT_SPHERE));
        this.topSphere = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_TOP_SPHERE));
        this.lightRaysBackground = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_LIGHT_RAYS_BACKGROUND));
        this.lightRaysForeground = new ImageView(new Image(FILE_KEY + PATH_TO_START_SCREEN_LIGHT_RAYS_FOREGROUND));

        //the order is important. The later, the higher the priority.
        this.allImages = new ImageView[]{this.background, this.cloudsBackground, this.lightRaysBackground,
                this.bottomSphere, this.leftSphere, this.rightSphere,
                this.topSphere, this.trunk, this.leaf, this.cloudsForeground, this.lightRaysForeground};

        this.leafButton = new Button();
        this.leafButton.setStyle("-fx-background-color: transparent;");
        this.leafButton.setOnMouseClicked(new StartScreenEventHandler());

        this.allButtons = new Button[]{this.leafButton};
        this.setTitle("Tomb of Pik 8");

        this.layout = new Pane();
        
//      setSizeImages(width, height);
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        setX(bounds.getMinX());
        setY(bounds.getMinY());
        setWidth(bounds.getWidth());
        setHeight(bounds.getHeight());

        //this.setFullScreen(true);
                
        setLayout();
        setPosition();
        setSizeImages((int)bounds.getWidth(), (int)bounds.getHeight());
        setGraphicOfButtons();
        //setScaledHeight(bounds.getHeight());

        this.scene = new Scene(layout, bounds.getWidth(), bounds.getHeight());
        this.setScene(scene);
        
        widthProperty().addListener((obs, oldVal, newVal) -> {
        	setScaledWidth((double) newVal);
        	setScaledXPosition((double) newVal/ (double)oldVal);
        });
        
        heightProperty().addListener((obs, oldVal, newVal) -> {
        	setScaledHeight((double) newVal);
        	setScaledYPosition((double) newVal/ (double)oldVal);
        });
        
    }


    private void setLayout () {
        //here was the set graphic before.
        this.layout.getChildren().addAll(this.allImages);
        this.layout.getChildren().addAll(this.allButtons);
    }

    private void setSizeImages(double width, double height) {
        double ratioHeight = 2160/height;
        double ratioWidth = 3840/width;

        for (ImageView image : allImages) {
            image.setFitWidth(image.getImage().getWidth() / ratioWidth);
            image.setFitHeight(image.getImage().getHeight() / ratioHeight);
        }
    }

    private void setGraphicOfButtons () {
        this.leafButton.setGraphic(this.leaf);
    }
    
    private void setScaledWidth(double width) {
    	double ratioWidth = 3840/width;
    	for(ImageView image : allImages) {
    		image.setFitWidth(image.getImage().getWidth() / ratioWidth);
    	}
    }
    
    private void setScaledHeight(double height) {
    	double ratioHeight = 2160/height;
    	for(ImageView image : allImages) {
    		image.setFitHeight(image.getImage().getHeight() / ratioHeight);
    	}
    }
    
    private void setScaledXPosition(double ratio) {
    	for(ImageView image : allImages) {
    		image.setTranslateX(image.getTranslateX() * ratio);
    	}
    	for (Button button : allButtons) {
            button.setTranslateX(button.getTranslateX() * ratio);
        }
    }

    private void setScaledYPosition(double ratio) {
    	for(ImageView image : allImages) {
    		image.setTranslateY(image.getTranslateY() * ratio);
    	}
        for (Button button : allButtons) {
            button.setTranslateY(button.getTranslateY() * ratio);
        }
    }
    
    private void setPosition () {
        changePosition(this.background, 0, 0);
        changePosition(this.cloudsBackground, 0, 0);
        changePosition(this.cloudsForeground, 650, -160);
        changePosition(this.trunk, 850, 50);
        //changePosition(this.leaf, 970, 770);
        changePosition(this.bottomSphere, 910, 570);
        changePosition(this.leftSphere, 850, 460);
        changePosition(this.rightSphere, 1083, 370);
        changePosition(this.topSphere, 965, 112);
        changePosition(this.lightRaysBackground, 500, -160);
        changePosition(this.lightRaysForeground, 200, -250);

        changePosition(this.leafButton, 965, 747);
    }


    private void changePosition(ImageView image, int xValue, int yValue) {
        image.setTranslateX(xValue);
        image.setTranslateY(yValue);
    }

    private void changePosition(Button button, int xValue, int yValue) {
        button.setTranslateX(xValue);
        button.setTranslateY(yValue);
    }
}
