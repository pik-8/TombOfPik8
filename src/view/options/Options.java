package view.options;


import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is just a test of JavaFX and the option model at this moment.
 * Will be used as the options view later on
 *
 * ToDo:
 * - get window size from model.options.Resolution
 * - add multiple Scenes (main options, volume, resolution, etc)
 *
 * @author Patrick Szalewicz
 */

public class Options extends Application {


    Scene optionsMenu, volumeMenu, resolutionMenu;


    // Create the labels
    Label optionslabel= new Label("This is the options scene");
    Label labl_messageresolution = new Label("Resolution settings");
    Label labl_messagevolume = new Label("Volume settings");
    Label labl_generalvolume = new Label("General volume");
    Label labl_effectvolume = new Label("Effect volume");
    Label labl_musicvolume = new Label("Music volume");
    Label labl_generalvolume_value = new Label("");
    Label labl_effectvolume_value = new Label("");
    Label labl_musicvolume_value = new Label("");


    // Create the buttons
    Button optionsButton= new Button("Go to options");
    Button volumeButton= new Button("Go to volume settings");
    Button resolutionButton= new Button("Go to resolution settings");
    Button saveVolumeButton = new Button("save");
    Button saveResolutionButton = new Button("save");
    Button exitButton = new Button("exit");


    // Create the sliders
    Slider slider_generalvolume;
    Slider slider_effectvolume;
    Slider slider_musicvolume;


    @Override
    public void start(Stage optionsStage) {


        // Setup the sliders
        slider_generalvolume = new Slider(0,100, 50);
        slider_generalvolume.setBlockIncrement(10);
        slider_generalvolume.setMajorTickUnit(10);
        slider_generalvolume.setMinorTickCount(0);
        slider_generalvolume.setShowTickLabels(true);
        slider_generalvolume.setShowTickMarks(true);
        slider_generalvolume.setSnapToTicks(false);

        slider_effectvolume = new Slider();
        slider_effectvolume.setMin(0);
        slider_effectvolume.setMax(100);
        slider_effectvolume.setValue(50);
        slider_effectvolume.setShowTickLabels(true);
        slider_effectvolume.setShowTickMarks(true);
        slider_effectvolume.setBlockIncrement(10);

        slider_musicvolume = new Slider();
        slider_musicvolume.setMin(0);
        slider_musicvolume.setMax(100);
        slider_musicvolume.setValue(50);
        slider_musicvolume.setShowTickLabels(true);
        slider_musicvolume.setShowTickMarks(true);
        slider_musicvolume.setBlockIncrement(10);


        // Setup the main button
        optionsButton.setOnAction(e -> optionsStage.setScene(optionsMenu));
        volumeButton.setOnAction(e -> optionsStage.setScene(volumeMenu));
        resolutionButton.setOnAction(e -> optionsStage.setScene(resolutionMenu));
        exitButton.setOnAction(e -> Platform.exit());
        saveVolumeButton.setOnAction(e -> Platform.exit());
        saveResolutionButton.setOnAction(e -> Platform.exit());


        // Setup the layout and add elements to it
        VBox optionsLayout = new VBox(20);
        optionsLayout.getChildren().addAll(optionslabel, volumeButton, resolutionButton, exitButton);
        optionsLayout.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        optionsMenu = new Scene(optionsLayout, 300, 250);

        GridPane volumeLayout = new GridPane();
        volumeLayout.setPadding(new Insets(10, 10, 10, 10));
        volumeLayout.setVgap(8);
        volumeLayout.setHgap(10);
        GridPane.setConstraints(labl_messagevolume, 1, 0);
        GridPane.setConstraints(labl_generalvolume, 0, 1);
        GridPane.setConstraints(slider_generalvolume, 1, 1);
        GridPane.setConstraints(labl_generalvolume_value, 2, 1);
        GridPane.setConstraints(labl_effectvolume, 0, 2);
        GridPane.setConstraints(slider_effectvolume, 1, 2);
        GridPane.setConstraints(labl_effectvolume_value, 2, 2);
        GridPane.setConstraints(labl_musicvolume, 0, 3);
        GridPane.setConstraints(slider_musicvolume, 1, 3);
        GridPane.setConstraints(labl_musicvolume_value, 2, 3);
        GridPane.setConstraints(saveVolumeButton, 1,4);
        volumeLayout.getChildren().addAll(labl_messagevolume,
                labl_generalvolume, slider_generalvolume, labl_generalvolume_value,
                labl_effectvolume, slider_effectvolume, labl_effectvolume_value,
                labl_musicvolume, slider_musicvolume, labl_musicvolume_value,
                saveVolumeButton);
        volumeLayout.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        volumeMenu = new Scene(volumeLayout, 550, 300);

        GridPane resolutionLayout = new GridPane();
        resolutionLayout.setPadding(new Insets(10, 10, 10, 10));
        resolutionLayout.setVgap(8);
        resolutionLayout.setHgap(10);
        GridPane.setConstraints(labl_messageresolution, 0, 0);
        GridPane.setConstraints(saveResolutionButton, 0,1);
        resolutionLayout.getChildren().addAll(labl_messageresolution,
                saveResolutionButton);
        resolutionLayout.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        resolutionMenu = new Scene(resolutionLayout, 550, 300);


        // Adding listeners to value property
        slider_generalvolume.valueProperty().addListener((observable, oldValue_general, newValue_general) -> {
            Number roundValue_general = Math.round((Double) newValue_general);
            labl_generalvolume_value.setText("" + roundValue_general);
        });

        slider_effectvolume.valueProperty().addListener((observable, oldValue_effect, newValue_effect) -> {
            Number roundValue_effect = Math.round((Double) newValue_effect);
            labl_effectvolume_value.setText("" + roundValue_effect);
        });

        slider_musicvolume.valueProperty().addListener((observable, oldValue_music, newValue_music) -> {
            Number roundValue_music = Math.round((Double) newValue_music);
            labl_musicvolume_value.setText("" + roundValue_music);
        });


        // Setup stage and start it
        optionsStage.setTitle("Options");
        optionsStage.setScene(optionsMenu);
        optionsStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("exited");
    }

}