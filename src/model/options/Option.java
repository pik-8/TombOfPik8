package model.options;

import javafx.scene.control.Slider;

import java.awt.*;

import static model.options.Resolution.WindowSize.MEDIUM;
import static model.options.Volume.getSelectedVolumes;

/**
 *
 *
 * @author Patrick Szalewicz
 */

public class Option {

    public void DefaultOptionValues() {
        Resolution.WindowSize winSiz = MEDIUM;
        //this.GeneralVolumeSlider = new Slider(0, 100, 50);
        //this.EffectsVolumeSlider = new Slider(0, 100, 50);
        //this.MusicVolumeSlider = new Slider(0, 100, 50);
    }


    public static void main(String[] args){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.println("Screen width = " + d.width + ", Screen height = " + d.height);
        System.out.println();
    }



}
