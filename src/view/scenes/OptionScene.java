package view.scenes;

import constants.ConfigKeys;
import constants.ExceptionConstants;
import constants.FileConstants;
import constants.ModelProperties;
import constants.view.OptionSceneProperties;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.options.Options;

import java.io.FileInputStream;
import java.util.Properties;


/**
 * A scene that contains a menu, in which the user can configure the game.
 *
 * @author Hagen
 */
public class OptionScene extends GameScene {

    private final Button difficultyButton;
    private final Button graphicButton;
    private final Button soundButton;

    private final VBox soundContent;



    public OptionScene(double width, double height) {
        super(new VBox());
        this.difficultyButton = new Button();
        this.graphicButton = new Button();
        this.soundButton = new Button();

        this.soundContent = new VBox();
        init();
    }

    private void init () {
        Properties gameConfig = new Properties();
        Properties option = new Properties();
        try {
            gameConfig.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
            option.load(new FileInputStream(FileConstants.PATH_TO_LANGUAGES
                    + "/" + gameConfig.getProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE)
                    + FileConstants.PATH_TO_OPTION_SCENES_CONFIG));
        } catch (Exception e) {
            System.out.println(e);
        }

        initButtons(option);
        initSoundArea(option);
        initLayouts();
    }

    private void initButtons (Properties optionReader) {
        this.difficultyButton.setPrefSize(OptionSceneProperties.BUTTON_SIZE[0], OptionSceneProperties.BUTTON_SIZE[1]);
        this.graphicButton.setPrefSize(OptionSceneProperties.BUTTON_SIZE[0], OptionSceneProperties.BUTTON_SIZE[1]);
        this.soundButton.setPrefSize(OptionSceneProperties.BUTTON_SIZE[0], OptionSceneProperties.BUTTON_SIZE[1]);

        this.difficultyButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_DIFFICULTY_BUTTON_STYLE_SHEET);
        this.graphicButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_GRAPHIC_BUTTON_STYLE_SHEET);
        this.soundButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_SOUND_BUTTON_STYLE_SHEET);

        try {
            this.difficultyButton.setText(optionReader.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_DIFFICULTY_BUTTON_TEXT));
            this.graphicButton.setText(optionReader.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_GRAPHIC_BUTTON_TEXT));
            this.soundButton.setText(optionReader.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_SOUND_BUTTON_TEXT));
        } catch (Exception e) {
            System.out.println(e);
            this.difficultyButton.setText(ExceptionConstants.NO_TEXT_FOUD);
            this.graphicButton.setText(ExceptionConstants.NO_TEXT_FOUD);
            this.soundButton.setText(ExceptionConstants.NO_TEXT_FOUD);
        }
    }


    private void initSoundArea (Properties optionReader) {

        Label masterVolumeSliderLabel = new Label(optionReader.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MASTER_VOLUME_TEXT));
        Slider masterVolumeSlider = new Slider(ModelProperties.MASTER_VOLUME_MIN_VALUE, ModelProperties.MASTER_VOLUME_MAX_VAlUE, ModelProperties.MASTER_VOLUME_MAX_VAlUE);

        masterVolumeSlider.valueProperty().addListener(new ChangeListener() {


            @Override
            public void changed(ObservableValue arg0, Object oldValue, Object newValue) {
                updateMasterVolumeValue((double) newValue);
            }
        });

        this.soundContent.getChildren().addAll(masterVolumeSliderLabel, masterVolumeSlider);
    }


    private void initLayouts () {
        HBox hbox = new HBox(this.difficultyButton, this.graphicButton, this.soundButton);
        VBox layout = (VBox) this.getRoot();
        layout.getChildren().addAll(hbox, this.soundContent);

    }


    private void updateMasterVolumeValue (double masterVolume) {
        Options options = Options.getActiveOptions();
        options.setMasterVolume(masterVolume);
    }


    @Override
    public void closeScene() {

    }
}
