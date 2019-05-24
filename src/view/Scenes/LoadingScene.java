package view.Scenes;

import constants.ConfigKeys;
import constants.FileConstants;
import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.LoadingSceneProperties;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import view.Animation;
import view.ConfigStream;

public class LoadingScene extends Scene{

    private final HBox hBox;
    private final Label label;
    private final Animation animation;

    public LoadingScene(double width, double height) {
        super(new Pane());
        this.label = new Label();
        initText();
        this.animation = getAnimation();
        this.hBox = new HBox(label, animation);

        ImageView background = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_BACKGROUND));
        background.setFitWidth(background.getImage().getWidth() / (DefaultTextureSize.width / width));
        background.setFitHeight(background.getImage().getHeight() / (DefaultTextureSize.height / height));

        animation.setFitHeight(animation.getHeight() / (DefaultTextureSize.height / height));
        animation.setFitWidth(animation.getWidth() / (DefaultTextureSize.width / width));

        this.hBox.setTranslateX(LoadingSceneProperties.HBOX_POSITION[0]/ (DefaultTextureSize.width / width));
        this.hBox.setTranslateY(LoadingSceneProperties.HBOX_POSITION[1] / (DefaultTextureSize.height / height));

        this.hBox.setAlignment(Pos.BOTTOM_LEFT);
        this.hBox.setSpacing(LoadingSceneProperties.HBOX_SPACING);

        new Thread(this.animation).start();
        ((Pane) this.getRoot()).getChildren().addAll(background, this.hBox);
    }


    private void initText() {
        ConfigStream gameConfigStream = null;
        ConfigStream loadingReader = null;
        try {
            gameConfigStream = new ConfigStream(FileConstants.PATH_TO_GAME_CONFIG);
            loadingReader = new ConfigStream(FileConstants.PATH_TO_LANGUAGES
                    + "/" + gameConfigStream.getStringFromConfigFile(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE)
                    + FileConstants.PATH_TO_LOADING_SCENES_CONFIG);
            this.label.setText(loadingReader.getStringFromConfigFile(ConfigKeys.LOADING_SCENE_KEY_FOR_LABEL));
        } catch (Exception e) {
            System.out.println(e);
            this.label.setText(LoadingSceneProperties.DEFAULT_LABEL_TEXT);
        }

        this.label.getStylesheets().add(FileConstants.PATH_TO_LOADING_SCENE_LABEL_STYLE_SHEET);

    }

    private Animation getAnimation () {
        Image image1 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_1);
        Image image2 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_2);
        Image image3 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_3);
        Image image4 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_4);
        Image image5 = new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_LOADING_SCENE_ANIMATION_5);

        return new Animation(new Image[]{image1, image2 ,image3, image4, image5}, LoadingSceneProperties.FPS_OF_ANIMATION);
    }
}
