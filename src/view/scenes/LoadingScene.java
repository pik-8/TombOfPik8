package view.scenes;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.LoadingSceneProperties;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import view.Animation;

import java.io.FileInputStream;
import java.util.Properties;


/**
 * A scene that will always be displayed, when a new scene is loading.
 * Contains a background and a hbox, that contains a label and an animation.
 * The animation has to be stopped from the SceneManager.
 *
 * @author Hagen
 */
public class LoadingScene extends GameScene{

    private final HBox hBox;
    private final Label label;
    private final Animation animation;
    private final ImageView background;

    private Thread animationThread;

    public LoadingScene(double width, double height) {
        super();
        this.animation = createAnimation();
        this.animation.start();
        this.label = new Label();
        this.hBox = new HBox(label, animation);
        this.background = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_BACKGROUND));

        initText();
        setSizesAndPositions(width, height);


        ((Pane) this.getRoot()).getChildren().addAll(background, this.hBox);
    }

    private void setSizesAndPositions (double width, double height) {
        background.setFitWidth(background.getImage().getWidth() / (DefaultTextureSize.width / width));
        background.setFitHeight(background.getImage().getHeight() / (DefaultTextureSize.height / height));

        animation.setFitHeight(animation.getImage().getHeight() / (DefaultTextureSize.height / height));
        animation.setFitWidth(animation.getImage().getWidth() / (DefaultTextureSize.width / width));

        this.hBox.setTranslateX(LoadingSceneProperties.HBOX_POSITION[0]/ (DefaultTextureSize.width / width));
        this.hBox.setTranslateY(LoadingSceneProperties.HBOX_POSITION[1] / (DefaultTextureSize.height / height));

        this.hBox.setAlignment(Pos.BOTTOM_LEFT);
        this.hBox.setSpacing(LoadingSceneProperties.HBOX_SPACING);
    }

    private void initText() {
        Properties gameConfig = new Properties();
        Properties loadingProperite = new Properties();
        try {
            gameConfig.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
            loadingProperite.load(new FileInputStream(FileConstants.PATH_TO_LANGUAGES
                    + "/" + gameConfig.getProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE)
                    + FileConstants.PATH_TO_LOADING_SCENES_CONFIG));
            this.label.setText(loadingProperite.getProperty(ConfigKeys.LOADING_SCENE_KEY_FOR_LABEL));
        } catch (Exception e) {
            System.out.println(e);
            this.label.setText(LoadingSceneProperties.DEFAULT_LABEL_TEXT);
        }
        this.label.getStylesheets().add(FileConstants.PATH_TO_LOADING_SCENE_LABEL_STYLE_SHEET);
    }

    private Animation createAnimation () {
        Image image1 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_1);
        Image image2 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_2);
        Image image3 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_3);
        Image image4 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_4);
        Image image5 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_5);

        return new Animation(new Image[]{image1, image2 ,image3, image4, image5}, LoadingSceneProperties.FPS_OF_ANIMATION);
    }

    @Override
    public void closeScene() {
        this.animation.stop();
    }
}
