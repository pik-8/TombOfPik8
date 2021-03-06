package view.scenes;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.function.Consumer;

import constants.ConfigKeys;
import constants.ExceptionConstants;
import constants.FileConstants;
import constants.ModelProperties;
import constants.balancing.Factors;
import constants.balancing.IDifficulty;
import constants.view.OptionSceneProperties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.options.Options;
import model.options.WindowMode;
import view.events.OptionSceneKeyEvent;

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

	
	private HBox mainButtonBox;
	private VBox optionsContent;
	private VBox allContent;
	
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
		initDifficultyArea();
		initLayouts();
		initEvents();
	}

	private void initEvents () {
		this.setOnKeyPressed(new OptionSceneKeyEvent());
	}

	private void initButtons() {
		for (Button b : new Button[] { difficultyButton, graphicButton, soundButton }) {
			b.setPrefSize(OptionSceneProperties.BUTTON_RATIO[0] * Options.getActiveOptions().getWindowWidth(), 
					OptionSceneProperties.BUTTON_RATIO[1] * Options.getActiveOptions().getWindowHeight());
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
		
		//TODO THE FOLLOWING IS PLACEHOLDER CODE. THE FUNCTIONALITY TO HAVE THE RIGHT OPTION SELECTED ON OPTION VIEW NEEDS TO BE IMPLEMENTED PROPERLY.
		if(Options.getActiveOptions().getWindowWidth() == 1920 && Options.getActiveOptions().getWindowHeight() == 1080) {
			resolutions.getSelectionModel().select(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_HIGH_RES_TEXT));			
		}
		else if(Options.getActiveOptions().getWindowWidth() == 1280 && Options.getActiveOptions().getWindowHeight() == 720) {
			resolutions.getSelectionModel().select(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MEDIUM_RES_TEXT));			
		}
		else if(Options.getActiveOptions().getWindowWidth() == 640 && Options.getActiveOptions().getWindowHeight() == 360) {
			resolutions.getSelectionModel().select(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_LOW_RES_TEXT));			
		}
		
		setResolutionsEventHandler(resolutions);
		resolutionsBox.getChildren().addAll(resolutionLabel, resolutions);
		resolutionsBox.setPadding(padding);
		
		// Creating the window mode ComboBox
		VBox windowModeBox = new VBox();
		Label windowModeLabel = new Label(
				this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_WINDOW_MODE_TEXT));
		ComboBox<WindowMode> windowModes = new ComboBox<WindowMode>();	
		windowModes.getItems().add(WindowMode.Windowed);
		windowModes.getItems().add(WindowMode.Fullscreen);
		windowModes.getItems().add(WindowMode.Maximized);
		
		switch(Options.getActiveOptions().getWindowMode()) {
		case Windowed:
			windowModes.getSelectionModel().select(WindowMode.Windowed);
			break;		
		case Fullscreen:
			windowModes.getSelectionModel().select(WindowMode.Fullscreen);
			break;
		case Maximized:
			windowModes.getSelectionModel().select(WindowMode.Maximized);
			break;
		}
		
		setWindowModeEventHandler(windowModes);
		windowModeBox.getChildren().addAll(windowModeLabel, windowModes);
		windowModeBox.setPadding(padding);

		this.graphicsContent.getChildren().addAll(resolutionsBox, windowModeBox);
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
	
	private void setWindowModeEventHandler(ComboBox<WindowMode> wm) {
		wm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Options.getActiveOptions().setWindowMode(wm.getValue());	
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

	private void createSliderHandler(Slider slider, Consumer<Double> optionSetter) {
		slider.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				optionSetter.accept(slider.getValue());
			}
		});
	}
	
	private void initDifficultyArea() {
		// Create difficulty Labels
		Label spawnRateLabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_SPAWN_RATE_TEXT));
		Label mobLevelLabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MOB_LEVEL_TEXT));
		Label mobTierLabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MOB_TIER_TEXT));
		Label mobAILabel = new Label(this.optionLabels.getProperty(ConfigKeys.OPTION_SCENE_KEY_FOR_MOB_AI_TEXT));
		
		// Create difficulty Sliders
		Slider spawnRateSlider = new Slider(IDifficulty.MIN_MOB_SPAWN_RATE, IDifficulty.MAX_MOB_SPAWN_RATE, Options.getActiveOptions().getMobSpawnRate());
		Slider mobLevelSlider = new Slider(Factors.MIN_MOB_LEVEL_FACTOR, Factors.MAX_MOB_LEVEL_FACTOR, Options.getActiveOptions().getMobLevel());
		Slider mobTierSlider = new Slider(IDifficulty.MIN_MOB_TIER, IDifficulty.MAX_MOB_TIER, Options.getActiveOptions().getMobTier());
		Slider mobAISlider = new Slider(IDifficulty.MIN_MOB_AI, IDifficulty.MAX_MOB_AI, Options.getActiveOptions().getMobAI());
		
		Slider[] sliderArr = new Slider[]{spawnRateSlider, mobLevelSlider, mobTierSlider, mobAISlider};
		activateTickLabelsAndMarkers(sliderArr);
		
		// Add EventHandler to Sliders
		createSliderHandler(spawnRateSlider, Options.getActiveOptions()::setMobSpawnRate);
		createSliderHandler(mobLevelSlider, Options.getActiveOptions()::setMobLevel);
		createSliderHandler(mobTierSlider, Options.getActiveOptions()::setMobTier);
		createSliderHandler(mobAISlider, Options.getActiveOptions()::setMobAI);
		
		VBox spawnRateBox = new VBox(), mobLevelBox = new VBox(), mobTierBox = new VBox(), mobAIBox = new VBox();
		
		spawnRateBox.getChildren().addAll(spawnRateLabel, spawnRateSlider);
		mobLevelBox.getChildren().addAll(mobLevelLabel, mobLevelSlider);
		mobTierBox.getChildren().addAll(mobTierLabel, mobTierSlider);
		mobAIBox.getChildren().addAll(mobAILabel, mobAISlider);
		
		setDifficultyBoxesPadding(new VBox[]{spawnRateBox, mobLevelBox, mobTierBox, mobAIBox});
		
		difficultyContent.getChildren().setAll(spawnRateBox, mobLevelBox, mobTierBox, mobAIBox);
	}
		
	private void activateTickLabelsAndMarkers(Slider[] sliders) {
		for(Slider s : sliders) {
			s.setMajorTickUnit((s.getMax() - s.getMin()) / 5);
			s.setShowTickLabels(true);
			s.setShowTickMarks(true);
		}
	}
	
	private void setDifficultyBoxesPadding(VBox[] boxes) {
		for(VBox box : boxes)
			box.setPadding(new Insets(OptionSceneProperties.DIFFICULTY_PADDING));
	}
	
	private void selectOptionsContent(VBox optionsContent) {
		this.allContent.getChildren().set(1, optionsContent);
	}

	private void initLayouts() {
		mainButtonBox = new HBox(this.difficultyButton, this.graphicButton, this.soundButton);
		this.optionsContent = this.soundContent;
		allContent = new VBox();
		allContent.getChildren().addAll(mainButtonBox, this.optionsContent);
		ScrollPane sp = new ScrollPane(allContent);
		this.layout.getChildren().addAll(sp);
	}

	@Override
	public void closeScene() {

	}
}
