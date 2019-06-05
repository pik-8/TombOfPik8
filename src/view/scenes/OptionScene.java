package view.scenes;

import java.io.FileInputStream;
import java.util.Properties;

import constants.ConfigKeys;
import constants.ExceptionConstants;
import constants.FileConstants;
import constants.ModelProperties;
import constants.view.OptionSceneProperties;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.options.Options;


/**
 * A scene that contains a menu, in which the user can configure the game.
 *
 * @author Hagen
 */
public class OptionScene extends GameScene {

	
	private Properties optionLabels;
	
    private final Button difficultyButton;
    private final Button graphicButton;
    private final Button soundButton;
    private final Button controlsButton;

    private VBox layout;
    
    private VBox optionsContent;
    private final VBox graphicsContent;
    private final VBox soundContent;

    public OptionScene(double width, double height) {
        super(new VBox());
        layout = (VBox) this.getRoot();
        
        this.difficultyButton = new Button();
        this.graphicButton = new Button();
        this.soundButton = new Button();
        this.controlsButton = new Button();

        this.optionsContent = (VBox) this.getRoot();
        this.graphicsContent = new VBox();
        this.soundContent = new VBox();
        init();
    }

    private void init () {
        this.optionLabels = new Properties();
        
        try {
            optionLabels.load(new FileInputStream(FileConstants.PATH_TO_LANGUAGES
                    + "/" + Options.getActiveOptions().getLanguage()
                    + FileConstants.PATH_TO_OPTION_SCENES_CONFIG));
        } catch (Exception e) {
            System.out.println(e);
        }

        initButtons();
        initSoundArea();
        initGraphicsArea();
        initLayouts();
    }

    private void initOptions() {
    	
    }
    
    private void initButtons () {
        this.difficultyButton.setPrefSize(OptionSceneProperties.BUTTON_SIZE[0], OptionSceneProperties.BUTTON_SIZE[1]);
        this.graphicButton.setPrefSize(OptionSceneProperties.BUTTON_SIZE[0], OptionSceneProperties.BUTTON_SIZE[1]);
        this.soundButton.setPrefSize(OptionSceneProperties.BUTTON_SIZE[0], OptionSceneProperties.BUTTON_SIZE[1]);

        this.difficultyButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_DIFFICULTY_BUTTON_STYLE_SHEET);
        this.graphicButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_GRAPHIC_BUTTON_STYLE_SHEET);
        this.soundButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_SOUND_BUTTON_STYLE_SHEET);

        try {
            this.difficultyButton.setText(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_DIFFICULTY_BUTTON_TEXT));
            this.graphicButton.setText(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_GRAPHIC_BUTTON_TEXT));
            this.soundButton.setText(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_SOUND_BUTTON_TEXT));
        } catch (Exception e) {
            System.out.println(e);
            this.difficultyButton.setText(ExceptionConstants.NO_TEXT_FOUD);
            this.graphicButton.setText(ExceptionConstants.NO_TEXT_FOUD);
            this.soundButton.setText(ExceptionConstants.NO_TEXT_FOUD);
        }
        
        addMainButtonEventHandlers();
        
    }

    private void addMainButtonEventHandlers() {
    	this.graphicButton.setOnAction(createButtonHandler(graphicsContent));
    	this.soundButton.setOnAction(createButtonHandler(soundContent));
    }
    
    private EventHandler<ActionEvent> createButtonHandler(VBox optionsContent) {
    	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				selectOptionsContent(optionsContent);
			}
        };
        return buttonHandler;
    }
    
    private void initGraphicsArea() {
    	Label resolutionLabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_RESOLUTION_TEXT));
    	ComboBox<String> resolutions = new ComboBox<String>();
    	resolutions.getItems().add(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_HIGH_RES_TEXT));
    	resolutions.getItems().add(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MEDIUM_RES_TEXT));
    	resolutions.getItems().add(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_LOW_RES_TEXT));
    	
    	CheckBox fullscreen = new CheckBox(this.optionLabels.getProperty(ConfigKeys.OPTiON_SCENE_KEY_FOR_FULLSCREEN_TEXT));
    	CheckBox borderlessWindow = new CheckBox(this.optionLabels.getProperty(ConfigKeys.OPTiON_SCENE_KEY_FOR_BORDERLESS_WINDOW_TEXT));
    	
    	resolutions.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String selectedRes = (String) resolutions.getValue();
				selectedRes = selectedRes.split("\\(")[1].replaceAll(" ", "");
				selectedRes = selectedRes.substring(0, selectedRes.length() - 1);
				int width = Integer.parseInt(selectedRes.split("x")[0]);
				int height = Integer.parseInt(selectedRes.split("x")[1]);
				Options.getActiveOptions().setWindowHeight(height);
				Options.getActiveOptions().setWindowWidth(width);
			}
		});
    	this.graphicsContent.getChildren().addAll(resolutionLabel, resolutions, fullscreen, borderlessWindow);
    }

    private void initSoundArea () {
        Label masterVolumeSliderLabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MASTER_VOLUME_TEXT));
        Slider masterVolumeSlider = new Slider(ModelProperties.VOLUME_MIN_VALUE, ModelProperties.VOLUME_MAX_VAlUE, Options.getActiveOptions().getMasterVolume());
        Label soundVolumeSliderLabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_SOUND_VOLUME_TEXT));
        Slider soundVolumeSlider = new Slider(ModelProperties.VOLUME_MIN_VALUE, ModelProperties.VOLUME_MAX_VAlUE, Options.getActiveOptions().getSoundVolume());
        Label musicVolumeSliderLabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MUSIC_VOLUME_TEXT));
        Slider musicVolumeSlider = new Slider(ModelProperties.VOLUME_MIN_VALUE, ModelProperties.VOLUME_MAX_VAlUE, Options.getActiveOptions().getMusicVolume());
        masterVolumeSlider.valueProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> arg0, Object oldValue, Object newValue) {
                updateMasterVolumeValue((double) newValue);
            }
        });
        this.soundContent.getChildren().addAll(masterVolumeSliderLabel, masterVolumeSlider);
    }

    private void selectOptionsContent(VBox optionsContent) {
    	this.layout.getChildren().remove(this.optionsContent);
    	this.optionsContent = optionsContent;
    	this.layout.getChildren().add(this.optionsContent);
    }
    
    private void initLayouts () {
        HBox hbox = new HBox(this.difficultyButton, this.graphicButton, this.soundButton);
        this.optionsContent = this.soundContent;
        this.layout.getChildren().addAll(hbox, this.optionsContent);
    }

    private void updateMasterVolumeValue (double masterVolume) {
        Options options = Options.getActiveOptions();
        options.setMasterVolume(masterVolume);
    }


    @Override
    public void closeScene() {

    }
}
