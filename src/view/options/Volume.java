package view.options;


        import javafx.application.*;
        import javafx.geometry.Insets;
        import javafx.scene.*;
        import javafx.scene.control.*;
        import javafx.scene.control.Label;
        import javafx.scene.control.Slider;
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

public class Volume extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    Button btn;
    Label labl_message;
    Label labl_generalvolume;
    Label labl_effectvolume;
    Label labl_musicvolume;
    Slider slider_generalvolume;
    Slider slider_effectvolume;
    Slider slider_musicvolume;

    @Override
    public void start(Stage primaryStage)
    {
        // Create the button
        btn = new Button();
        btn.setText("Save");
        btn.setOnAction(e -> buttonClick());

        // Create the labels
        labl_message = new Label("Volume settings");
        labl_generalvolume = new Label("General volume");
        labl_effectvolume = new Label("Effect volume");
        labl_musicvolume = new Label("Music volume");

        // Create the sliders
        slider_generalvolume = new Slider();
        slider_generalvolume.setMin(0);
        slider_generalvolume.setMax(100);
        slider_generalvolume.setValue(50);
        slider_generalvolume.setShowTickLabels(true);
        slider_generalvolume.setShowTickMarks(true);
        slider_generalvolume.setBlockIncrement(10);

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

        // Add the button to a layout pane
        VBox pane_volume = new VBox();
        pane_volume.setPadding(new Insets(20));
        pane_volume.setSpacing(10);
        pane_volume.getChildren().addAll(labl_message, labl_generalvolume, slider_generalvolume, labl_effectvolume, slider_effectvolume, labl_musicvolume, slider_musicvolume, btn);
        pane_volume.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Add the layout pane to a scene
        Scene scene = new Scene(pane_volume, 600, 350);

        // Add the scene to the stage, set the title
        // and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu - Volume");
        primaryStage.show();
    }

    public void buttonClick()
    {
        if (btn.getText() == "Save")
        {
            btn.setText("Saved! - Back?");
            // Add a method for saving
        }
        else if (btn.getText() == "Saved! - Back?")
        {
            Platform.exit();
        }
        else
        {
            btn.setText("Save");

        }
    }
}

