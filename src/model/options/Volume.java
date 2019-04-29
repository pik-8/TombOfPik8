package model.options;

import javafx.application.Application;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.awt.*;

/**
 * This class is used for the Volume sliders and options
 *
 * ToDo:
 * - getValues is 0.0 not 50, why?
 * - add saving and loading with gson
 * - add the following options: mute effects, mute music, ...
 *
 * @author Patrick Szalewicz
 */

public class Volume extends Application {


    public static void main(String[] args){
        System.out.println(GeneralVolumeValue);
    }

    public static double GeneralVolumeValue;
    public static double EffectsVolumeValue;
    public static double MusicVolumeValue;

    private double effectVolumeValue;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the sliders
        Slider GeneralVolumeSlider = new Slider(0, 100, 50);
        GeneralVolumeSlider.setShowTickLabels(true);
        GeneralVolumeSlider.setShowTickMarks(true);
        GeneralVolumeSlider.setBlockIncrement(10);

        Slider EffectsVolumeSlider = new Slider(0, 100, 50);
        EffectsVolumeSlider.setShowTickLabels(true);
        EffectsVolumeSlider.setShowTickMarks(true);
        EffectsVolumeSlider.setBlockIncrement(10);

        Slider MusicVolumeSlider = new Slider(0, 100, 50);
        MusicVolumeSlider.setShowTickLabels(true);
        MusicVolumeSlider.setShowTickMarks(true);
        MusicVolumeSlider.setBlockIncrement(10);

        this.GeneralVolumeValue = GeneralVolumeSlider.getValue();
        this.EffectsVolumeValue = EffectsVolumeSlider.getValue();
        this.MusicVolumeValue = MusicVolumeSlider.getValue();

    }

    public static void getSelectedVolumes(){

    }

    public double getEffectVolumeValue() {
        return effectVolumeValue;
    }

    public void setEffectVolumeValue(double effectVolumeValue) {
        this.effectVolumeValue = effectVolumeValue;
    }
}

