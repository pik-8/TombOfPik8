package view.scenes;

import java.io.FileInputStream;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Properties;
import java.util.function.Consumer;

import constants.ConfigKeys;
import constants.ExceptionConstants;
import constants.FileConstants;
import constants.ModelProperties;
import constants.view.OptionSceneProperties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.options.Options;

/**
 * A scene that contains a menu, in which the user can configure the game.
 *
 * @author Frederick Hastedt and Hagen
 */
public class OptionScene extends GameScene {

	private Properties optionLabels;

	private final Button difficultyButton;
	private final Button graphicButton;
	private final Button soundButton;

	private VBox layout;

	private VBox optionsContent;
	private final VBox graphicsContent;
	private final VBox soundContent;
	private final VBox difficultyContent;

	public OptionScene(double width, double height) {
		super(new VBox());
		layout = (VBox) this.getRoot();

		this.difficultyButton = new Button();
		this.graphicButton = new Button();
		this.soundButton = new Button();

		this.optionsContent = (VBox) this.getRoot();
		this.graphicsContent = new VBox();
		this.soundContent = new VBox();
		this.difficultyContent = new VBox();
		init();
	}

	private void init() {
		this.optionLabels = new Properties();

		try {
			optionLabels.load(new FileInputStream(FileConstants.PATH_TO_LANGUAGES + "/"
					+ Options.getActiveOptions().getLanguage() + FileConstants.PATH_TO_OPTION_SCENES_CONFIG));
		} catch (Exception e) {
			System.out.println(e);
		}

		initButtons();
		initSoundArea();
		initGraphicsArea();
		initLayouts();
	}

	private void initButtons() {
		for (Button b : new Button[] { difficultyButton, graphicButton, soundButton }) {
			b.setPrefSize(OptionSceneProperties.BUTTON_SIZE[0], OptionSceneProperties.BUTTON_SIZE[1]);
		}

		this.difficultyButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_DIFFICULTY_BUTTON_STYLE_SHEET);
		this.graphicButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_GRAPHIC_BUTTON_STYLE_SHEET);
		this.soundButton.getStylesheets().add(FileConstants.PATH_TO_OPTION_SCENE_SOUND_BUTTON_STYLE_SHEET);

		try {
			this.difficultyButton
					.setText(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_DIFFICULTY_BUTTON_TEXT));
			this.graphicButton
					.setText(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_GRAPHIC_BUTTON_TEXT));
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
		this.difficultyButton.setOnAction(createButtonHandler(difficultyContent));
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
		Insets padding = new Insets(OptionSceneProperties.GRAPHICS_PADDING);

		// Creating the resolutions ComboBox
		VBox resolutionsBox = new VBox();
		Label resolutionLabel = new Label(
				this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_RESOLUTION_TEXT));
		ComboBox<String> resolutions = new ComboBox<String>();
		resolutions.getItems().add(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_HIGH_RES_TEXT));
		resolutions.getItems().add(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MEDIUM_RES_TEXT));
		resolutions.getItems().add(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_LOW_RES_TEXT));
		setResolutionsEventHandler(resolutions);
		resolutionsBox.getChildren().addAll(resolutionLabel, resolutions);
		resolutionsBox.setPadding(padding);

		this.graphicsContent.getChildren().addAll(resolutionsBox,
				createCheckBoxBox(ConfigKeys.OPTiON_SCENE_KEY_FOR_FULLSCREEN_TEXT),
				createCheckBoxBox(ConfigKeys.OPTiON_SCENE_KEY_FOR_BORDERLESS_WINDOW_TEXT));
	}

	private HBox createCheckBoxBox(String labelKey) {
		Insets padding = new Insets(OptionSceneProperties.GRAPHICS_PADDING);
		HBox boxBox = new HBox();
		Label boxLabel = new Label(this.optionLabels.getProperty(labelKey));
		CheckBox checkBox = new CheckBox();
		boxLabel.setPadding(padding);
		checkBox.setPadding(padding);
		boxBox.getChildren().addAll(boxLabel, checkBox);
		return boxBox;
	}

	private void setResolutionsEventHandler(ComboBox<String> res) {
		res.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String selectedRes = (String) res.getValue();
				selectedRes = selectedRes.split("\\(")[1].replaceAll(" ", "");
				selectedRes = selectedRes.substring(0, selectedRes.length() - 1);
				int width = Integer.parseInt(selectedRes.split("x")[0]);
				int height = Integer.parseInt(selectedRes.split("x")[1]);
				Options.getActiveOptions().setWindowHeight(height);
				Options.getActiveOptions().setWindowWidth(width);
			}
		});
	}

	private void initSoundArea() {
		this.soundContent.getChildren()
				.addAll(createSoundSliderBox(ConfigKeys.OPTION_SCENE_KEY_FOR_MASTER_VOLUME_TEXT,
						Options.getActiveOptions().getMasterVolume(),
						Options.getActiveOptions()::setMasterVolume),
						createSoundSliderBox(ConfigKeys.OPTION_SCENE_KEY_FOR_SOUND_VOLUME_TEXT,
								Options.getActiveOptions().getSoundVolume(),
								Options.getActiveOptions()::setSoundVolume),
						createSoundSliderBox(ConfigKeys.OPTION_SCENE_KEY_FOR_MUSIC_VOLUME_TEXT,
								Options.getActiveOptions().getMusicVolume(),
								Options.getActiveOptions()::setMusicVolume));
	}

	private VBox createSoundSliderBox(String labelKey, double startingVolume, Consumer<Double> volumeSetter) {
		VBox soundSliderBox = new VBox();
		Label soundSliderLabel = new Label(this.optionLabels.getProperty(labelKey));
		Slider soundSlider = createSoundSlider(startingVolume);
		soundSlider.setShowTickLabels(true);
		soundSlider.setShowTickMarks(true);
		createSliderHandler(soundSlider, volumeSetter);
		soundSliderBox.getChildren().addAll(soundSliderLabel, soundSlider);
		soundSliderBox.setPadding(new Insets(OptionSceneProperties.SOUNDS_PADDING));
		return soundSliderBox;
	}

	private Slider createSoundSlider(double initialValue) {
		return new Slider(ModelProperties.VOLUME_MIN_VALUE, ModelProperties.VOLUME_MAX_VAlUE, initialValue);
	}

	private void createSliderHandler(Slider slider, Consumer<Double> volumeSetter) {
		slider.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				volumeSetter.accept(slider.getValue());
			}
		});
	}
	
	private void initDifficultyArea() {
		
	}
	
	private void selectOptionsContent(VBox optionsContent) {
		this.layout.getChildren().remove(this.optionsContent);
		this.optionsContent = optionsContent;
		this.layout.getChildren().add(this.optionsContent);
	}

	private void initLayouts() {
		HBox hbox = new HBox(this.difficultyButton, this.graphicButton, this.soundButton);
		this.optionsContent = this.soundContent;
		this.layout.getChildren().addAll(hbox, this.optionsContent);
	}

	private void updateMasterVolumeValue(double masterVolume) {
		Options options = Options.getActiveOptions();
		options.setMasterVolume(masterVolume);
	}

	@Override
	public void closeScene() {

	}
}
