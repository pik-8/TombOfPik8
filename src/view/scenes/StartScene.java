package view.scenes;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.StartSceneProperties;
import control.GameController;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.io.FileReader;
import java.util.Properties;

import static constants.ImagePaths.*;


/**
 * This scene will be displayed after the title scene.
 * Has some options to determine the next scene or to leave the game.
 *
 * @author Hagen
 */
public class StartScene extends GameScene {

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

    private final ImageView[] allImages;

    private final Pane layout;


    public StartScene (double width, double height) {
        super();
        this.background = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_BACKGROUND));
        this.cloudsBackground = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_CLOUDS_BACKGROUND));
        this.cloudsForeground = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_CLOUDS_FOREGROUND));
        this.trunk = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_TRUNK));
        this.leaf = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_LEAF));
        this.bottomSphere = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_BOTTOM_SPHERE));
        this.leftSphere = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_LEFT_SPHERE));
        this.rightSphere = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_RIGHT_SPHERE));
        this.topSphere = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_TOP_SPHERE));
        this.lightRaysBackground = new ImageView(new Image(ModelProperties.FILE_KEY + PATH_TO_START_SCREEN_LIGHT_RAYS_BACKGROUND));

        // the order is important. The later, the higher the priority.
        this.allImages = new ImageView[] { this.background, this.cloudsBackground, this.lightRaysBackground,
                this.bottomSphere, this.leftSphere, this.rightSphere, this.topSphere, this.trunk, this.leaf,
                this.cloudsForeground };

        this.layout = new Pane();

        setEvents();

        setLayout();
        setPosition(width, height);
        setSizeImages(width, height);
    }


    private void setEvents () {
        setHoverEvents();
        this.leaf.setOnMouseClicked(e -> System.exit(69));
        this.bottomSphere.setOnMouseClicked(e -> {
            SceneManager.getSceneManager().loadScene(Scenes.OVERWORLD_SCENE, this);
        });
        this.rightSphere.setOnMouseClicked(event -> {
            SceneManager.getSceneManager().loadScene(Scenes.OPTIONS_SCENE, StartScene.this);
        });
        this.topSphere.setOnMouseClicked(e -> {
            SceneManager.getSceneManager().loadScene(Scenes.SAVE_STATE_SELECTION_SCENE, this);
        });

    }

    private void setHoverEvents () {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(FileConstants.PATH_TO_LANGUAGES + "/" + GameController.getGameController().getLanguage()
                    + FileConstants.PATH_TO_START_SCENE_CONFIG));
        } catch (Exception e) {
            System.out.println(e);
        }

        Label label = new Label();
        label.getStylesheets().add(FileConstants.PATH_TO_START_SCENE_HOVER_LABEL_STYLE_SHEET);

        this.topSphere.setOnMouseEntered(e -> {
            label.setText(properties.getProperty(ConfigKeys.START_SCENE_SAVE_STATE_LABEL));
            label.setTranslateX(topSphere.getTranslateX() + ModelProperties.LABEL_OFFSET_X);
            label.setTranslateY(topSphere.getTranslateY() + ModelProperties.LABEL_OFFSET_Y);

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(ModelProperties.HOVER_BRIGHTNESS);
            this.topSphere.setEffect(colorAdjust);
            ((Pane) StartScene.this.getRoot()).getChildren().add(label);
        });

        this.topSphere.setOnMouseExited(e -> {
            ((ColorAdjust)this.topSphere.getEffect()).setBrightness(ModelProperties.STANDARD_BRIGHTNESS);
            ((Pane) StartScene.this.getRoot()).getChildren().remove(label);
        });

        this.leaf.setOnMouseEntered(e -> {
            label.setText(properties.getProperty(ConfigKeys.START_SCENE_EXIT_LABEL));
            label.setTranslateX(leaf.getTranslateX() + ModelProperties.LABEL_OFFSET_X);
            label.setTranslateY(leaf.getTranslateY() + ModelProperties.LABEL_OFFSET_Y);

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(ModelProperties.HOVER_BRIGHTNESS);
            this.leaf.setEffect(colorAdjust);
            ((Pane) StartScene.this.getRoot()).getChildren().add(label);
        });

        this.leaf.setOnMouseExited(e -> {
            ((ColorAdjust)this.leaf.getEffect()).setBrightness(ModelProperties.STANDARD_BRIGHTNESS);
            ((Pane) StartScene.this.getRoot()).getChildren().remove(label);
        })

        ;this.rightSphere.setOnMouseEntered(e -> {
            label.setText(properties.getProperty(ConfigKeys.START_SCENE_OPTION_LABEL));
            label.setTranslateX(rightSphere.getTranslateX() + ModelProperties.LABEL_OFFSET_X);
            label.setTranslateY(rightSphere.getTranslateY() + ModelProperties.LABEL_OFFSET_Y);

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(ModelProperties.HOVER_BRIGHTNESS);
            this.rightSphere.setEffect(colorAdjust);
            ((Pane) StartScene.this.getRoot()).getChildren().add(label);
        });

        this.rightSphere.setOnMouseExited(e -> {
            ((ColorAdjust)this.rightSphere.getEffect()).setBrightness(ModelProperties.STANDARD_BRIGHTNESS);
            ((Pane) StartScene.this.getRoot()).getChildren().remove(label);
        });
    }


    public void reSizeAndRePlace (double width, double height) {
        setPosition(width, height);
        setSizeImages(width, height);
    }

    private void setLayout() {
        this.layout.getChildren().addAll(this.allImages);
        this.setRoot(layout);
    }

    private void setSizeImages(double width, double height) {
        double ratioHeight = DefaultTextureSize.height / height;
        double ratioWidth = DefaultTextureSize.width / width;

        for (ImageView image : allImages) {
            image.setFitWidth(image.getImage().getWidth() / ratioWidth);
            image.setFitHeight(image.getImage().getHeight() / ratioHeight);
        }
    }


    private void setPosition(double width, double height) {
        double widthRatio = DefaultTextureSize.width / width;
        double heightRatio = DefaultTextureSize.height / height;

        changePosition(this.background, StartSceneProperties.POSITION_BACKGROUND[0], StartSceneProperties.POSITION_BACKGROUND[1], widthRatio, heightRatio);
        changePosition(this.cloudsBackground, StartSceneProperties.POSITION_CLOUDS_BACKGROUND[0], StartSceneProperties.POSITION_CLOUDS_BACKGROUND[1], widthRatio, heightRatio);
        changePosition(this.cloudsForeground, StartSceneProperties.POSITION_CLOUDS_FOREGROUND[0], StartSceneProperties.POSITION_CLOUDS_FOREGROUND[1], widthRatio, heightRatio);
        changePosition(this.trunk, StartSceneProperties.POSITION_TRUNK[0], StartSceneProperties.POSITION_TRUNK[1], widthRatio, heightRatio);
        changePosition(this.bottomSphere, StartSceneProperties.POSITION_BOTTOM_SPHERE[0], StartSceneProperties.POSITION_BOTTOM_SPHERE[1], widthRatio, heightRatio);
        changePosition(this.leftSphere, StartSceneProperties.POSITION_LEFT_SPHERE[0], StartSceneProperties.POSITION_LEFT_SPHERE[1], widthRatio, heightRatio);
        changePosition(this.rightSphere, StartSceneProperties.POSITION_RIGHT_SPHERE[0], StartSceneProperties.POSITION_RIGHT_SPHERE[1], widthRatio, heightRatio);
        changePosition(this.topSphere, StartSceneProperties.POSITION_TOP_SPHERE[0], StartSceneProperties.POSITION_TOP_SPHERE[1], widthRatio, heightRatio);
        changePosition(this.lightRaysBackground, StartSceneProperties.POSITION_LIGHT_RAYS_BACKGROUND[0], StartSceneProperties.POSITION_LIGHT_RAYS_BACKGROUND[1], widthRatio, heightRatio);
        changePosition(this.leaf, StartSceneProperties.POSITION_LEAF[0], StartSceneProperties.POSITION_LEAF[1], widthRatio, heightRatio);
    }

    private void changePosition(ImageView image, double xValue, double yValue, double widthRatio, double heightRatio) {
        image.setTranslateX(xValue / widthRatio);
        image.setTranslateY(yValue / heightRatio);
    }

    @Override
    public void closeScene() {

    }
}
