package view.scenes;

import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.TitleSceneProperties;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.Animation;

import java.io.File;


/**
 * This is the first scene, that the user will see.
 * It contains the title of the game and the authors.
 *
 * @author Hagen
 */
public class TitleScene extends GameScene {

    private Animation animation;
    private ImageView background;
    private ImageView start;


    public TitleScene(double width, double height) {
        initAnimation(width, height);
        initImages(width, height);
        setLayout();
    }


    private void initAnimation (double width, double height) {
        File[] pictures = new File(ImagePaths.PATH_TO_TITLE_SCREEN_ANIMATION).listFiles();
        Image[] images = new Image[pictures.length];
        for (int i = 0; i < pictures.length; i++) {
            images[i] = new Image(ModelProperties.FILE_KEY + pictures[i].getPath());
        }

        this.animation = new Animation(images, TitleSceneProperties.FPS_OF_ANIMATION);
        animation.sizeToScene(width, height);

        animation.setTranslateX(TitleSceneProperties.POSITION_ANIMATION[0] / (DefaultTextureSize.WIDTH / width));
        animation.setTranslateY(TitleSceneProperties.POSITION_ANIMATION[1] / (DefaultTextureSize.HEIGHT / height));

        animation.start();
    }


    private void initImages (double width, double height) {
        this.background = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_TITLE_SCREEN_BACKGROUND));
        this.background.setTranslateX(TitleSceneProperties.POSITION_BACKGROUND[0] / (DefaultTextureSize.WIDTH / width));
        this.background.setTranslateY(TitleSceneProperties.POSITION_BACKGROUND[1] / (DefaultTextureSize.HEIGHT / height));

        this.background.setFitWidth(this.background.getImage().getWidth() / (DefaultTextureSize.WIDTH / width));
        this.background.setFitHeight(this.background.getImage().getHeight() / (DefaultTextureSize.HEIGHT / height));

        this.start = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_TITLE_SCREEN_START_TEXT));
        this.start.setTranslateX(TitleSceneProperties.POSITION_START[0] / (DefaultTextureSize.WIDTH / width));
        this.start.setTranslateY(TitleSceneProperties.POSITION_START[1] / (DefaultTextureSize.HEIGHT / height));

        this.start.setFitWidth(this.start.getImage().getWidth() / (DefaultTextureSize.WIDTH / width));
        this.start.setFitHeight(this.start.getImage().getHeight() / (DefaultTextureSize.HEIGHT / height));
    }


    private void setLayout () {
        ((Pane)this.getRoot()).getChildren().addAll(this.background, this.animation, this.start);
    }


    @Override
    public void closeScene() {
        this.animation.stop();
    }
}
