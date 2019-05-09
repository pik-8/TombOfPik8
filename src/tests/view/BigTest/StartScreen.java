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

    private final Pane layout;
    private final Scene scene;

    public StartScreen (int width, int height) {
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
                this.bottomSphere, this.leftSphere, this.rightSphere, this.topSphere, this.trunk, this.cloudsForeground, this.lightRaysForeground};

        this.setTitle("Tomb of Pik 8");

        this.leafButton = new Button();
        this.leafButton.setStyle("-fx-background-color: transparent;");
        this.leafButton.setOnMouseClicked(new StartScreenEventHandler());

        this.layout = new Pane();
        
//      setSize(width, height);
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        setX(bounds.getMinX());
        setY(bounds.getMinY());
        setWidth(bounds.getWidth());
        setHeight(bounds.getHeight());
                
        setSize((int)bounds.getWidth(), (int)bounds.getHeight());
        setLayout();
        setPosition();
        
        this.scene = new Scene(layout, bounds.getWidth(), bounds.getHeight());
        this.setScene(scene);
        
        widthProperty().addListener((obs, oldVal, newVal) -> {
        	setWidth((double) newVal);
        	setScaledWidth((double) newVal);
        	setScaledXPosition((double) newVal/ (double)oldVal);
        });
        
        heightProperty().addListener((obs, oldVal, newVal) -> {
        	setHeight((double) newVal);
        	setScaledHeight((double) newVal);
        	setScaledYPosition((double) newVal/ (double)oldVal);
        });
        
    }


    private void setLayout () {
        this.leafButton.setGraphic(this.leaf);
        this.layout.getChildren().addAll(this.allImages);
        this.layout.getChildren().addAll(this.leafButton);
    }

    private void setSize (int width, int height) {
        float ratioHeight = 2160/height;
        float ratioWidth = 3840/width;

        for (ImageView image : allImages) {
            image.setFitHeight(image.getImage().getHeight() / ratioHeight);
            image.setFitWidth(image.getImage().getWidth() / ratioWidth);
        }
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
    }

    private void setScaledYPosition(double ratio) {
    	for(ImageView image : allImages) {
    		image.setTranslateY(image.getTranslateY() * ratio);
    	}
    }
    
    private void setPosition () {
        changePositionOfImage(this.background, 0, 0);
        changePositionOfImage(this.cloudsBackground, 0, 0);
        changePositionOfImage(this.cloudsForeground, 650, -160);
        changePositionOfImage(this.trunk, 850, 40);
        //changePositionOfImage(this.leaf, 970, 770);
        changePositionOfImage(this.bottomSphere, 910, 580);
        changePositionOfImage(this.leftSphere, 850, 460);
        changePositionOfImage(this.rightSphere, 1083, 370);
        changePositionOfImage(this.topSphere, 965, 112);
        changePositionOfImage(this.lightRaysBackground, 500, -160);
        changePositionOfImage(this.lightRaysForeground, 200, -250);
        this.leafButton.setTranslateX(900);
        this.leafButton.setTranslateY(800);
    }


    private void changePositionOfImage (ImageView image, int xValue, int yValue) {
        image.setTranslateX(xValue);
        image.setTranslateY(yValue);
    }
}
