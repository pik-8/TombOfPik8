package view.options;


import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import model.options.Resolution;

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

    public static void main(String args[]) {
        launch(args);
        System.out.println("Thank you for playing our super nice game! :)");
    }

    Button btn;
    Label labl;
    Slider slider;

    @Override
    public void start(Stage primaryStage)
    {
        // Create the button
        btn = new Button();
        btn.setText("Easy");
        btn.setOnAction(e -> buttonClick());

        // Create the label
        labl = new Label("Difficulty");

        // Create the slider
        slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(10);

        // Add the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setCenter(btn);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 400, 250);

        // Add the scene to the stage, set the title
        // and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Test");
        primaryStage.show();
    }

    public void buttonClick()
    {
        if (btn.getText() == "Easy")
        {
            btn.setText("Difficult");
            //btn.setText(model.options.Resolution.)
        }
        else
        {
            btn.setText("Easy");
        }
    }
}

