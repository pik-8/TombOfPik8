package view.scenes;

import constants.FileConstants;
import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import constants.view.SaveStateSelectionSceneProperties;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.other.GameLoaderSaver;
import model.other.SaveState;


public class SaveStateSelectionScene extends GameScene {

    private ImageView background;
    private VBox content;


    public SaveStateSelectionScene(double width, double height) {
        super();
        this.background = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_SAVE_STATE_SELECTION_BACKGROUND));
        setSize(this.background, width, height);
        setPosition(this.background, SaveStateSelectionSceneProperties.POSITION_BACKGROUND, width, height);
        this.content = new VBox();

        setPosition(this.content, SaveStateSelectionSceneProperties.POSITION_CONTENT, width, height);

        initContent(width, height);
        ((Pane) this.getRoot()).getChildren().addAll(this.background, this.content);
    }


    private void initContent (double width, double height) {
        SaveState[] saveStates = new GameLoaderSaver().getAllSaveStates();
        for (int i = 0; i < saveStates.length; i++) {
            Pane box = new Pane();
            ImageView boxBackground = new ImageView(new Image(ModelProperties.FILE_KEY + ImagePaths.PATH_TO_SAVE_STATE_SELECTION_INFO_BOX));
            setSize(boxBackground, width, height );
            setPosition(boxBackground, SaveStateSelectionSceneProperties.POSITION_BOX_BACKGROUND, width, height);

            Label name = new Label(saveStates[i].getPlayer().getName());
            name.getStylesheets().add(FileConstants.PATH_TO_SAVE_STATE_SELECTION_SCENE_NAME_LABEL_STYLE_SHEET);
            setSize(name, width, height);
            setPosition(name, SaveStateSelectionSceneProperties.POSITION_NAME_LABEL, width, height);

            Label playTime = new Label(String.valueOf(saveStates[i].getPlaytime()));
            playTime.getStylesheets().add(FileConstants.PATH_TO_SAVE_STATE_SELECTION_SCENE_PLAY_TIME_LABEL_STYLE_SHEET);
            setSize(playTime, width, height);
            setPosition(playTime, SaveStateSelectionSceneProperties.POSITION_PLAY_TIME_LABEl, width, height);

            box.getChildren().addAll(boxBackground, name, playTime);
            final int index = i;
            box.setOnMouseClicked(e -> {
                new SceneManager().loadScene(saveStates[index].getPlayer().getName() + FileConstants.STANDARD_FILE_ENDING, this);
            });
            this.content.getChildren().add(box);
        }
    }



    private void setPosition (Node node,double[] position , double width, double height) {
        node.setTranslateX(position[0] / (DefaultTextureSize.width / width));
        node.setTranslateY(position[1] / (DefaultTextureSize.height / height));
    }


    private void setSize (Label label, double width, double height) {
        label.setScaleX(width / DefaultTextureSize.width);
        label.setScaleY(height / DefaultTextureSize.height);
    }


    private void setSize (ImageView image, double width, double height) {
        image.setFitWidth(image.getImage().getWidth() / (DefaultTextureSize.width / width));
        image.setFitHeight(image.getImage().getHeight() / (DefaultTextureSize.height / height));
    }


    @Override
    public void closeScene() {

    }
}
