package view.Scenes;

import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.TitleScreenTextures;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.dungeon.DungeonFactory;
import model.dungeon.Landscape;


import static constants.ImagePaths.*;

public class TitleScene extends Scene {

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

    public TitleScene(double width, double height) {
        super(new Pane());
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

        this.leaf.setOnMouseClicked(e -> System.exit(69));
        this.bottomSphere.setOnMouseClicked(e -> {
                DungeonFactory dungeonFactory = new DungeonFactory();
                SceneManager manager = new SceneManager();
                manager.loadDungeonScene(dungeonFactory.generateRandomDungeon(new Landscape[]{Landscape.FOREST}, 5, 20), this);
            });
        this.rightSphere.setOnMouseClicked(event -> {
            new SceneManager().loadScene(Scenes.OPTIONS_SCENE, TitleScene.this);
        });

        setLayout();
        setPosition();
        setSizeImages(width, height);
    }

    private void setLayout() {
        // here was the set graphic before.
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


    private void setPosition() {
        changePosition(this.background, TitleScreenTextures.posBackground[0], TitleScreenTextures.posBackground[1]);
        changePosition(this.cloudsBackground, TitleScreenTextures.posCloudsBackground[0], TitleScreenTextures.posCloudsBackground[1]);
        changePosition(this.cloudsForeground, TitleScreenTextures.posCloudsForeground[0], TitleScreenTextures.posCloudsForeground[1]);
        changePosition(this.trunk, TitleScreenTextures.posTrunk[0], TitleScreenTextures.posTrunk[1]);
        changePosition(this.bottomSphere, TitleScreenTextures.posBottomSphere[0], TitleScreenTextures.posBottomSphere[1]);
        changePosition(this.leftSphere, TitleScreenTextures.posLeftSphere[0], TitleScreenTextures.posLeftSphere[1]);
        changePosition(this.rightSphere, TitleScreenTextures.posRightSphere[0], TitleScreenTextures.posRightSphere[1]);
        changePosition(this.topSphere, TitleScreenTextures.posTopSphere[0], TitleScreenTextures.posTopSphere[1]);
        changePosition(this.lightRaysBackground, TitleScreenTextures.posLightRaysBackground[0], TitleScreenTextures.posLightRaysBackground[1]);
        changePosition(this.leaf, TitleScreenTextures.posLeaf[0], TitleScreenTextures.posLeaf[1]);
    }

    private void changePosition(ImageView image, double xValue, double yValue) {
        image.setTranslateX(xValue);
        image.setTranslateY(yValue);
    }
}
