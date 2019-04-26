package model.options;

import java.awt.*;


/**
 * This is the main option class.
 * Here you will get the requested volumes, resolution and other settings.
 *
 * ToDo:
 * - volume.xxxValue() is 0.0 not 50, fix it in Volume.java
 * - add getResolution()
 *
 * @author Patrick Szalewicz
 */

public class Option {

    public static void main(String[] args){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.println("Screen width = " + d.width + ", Screen height = " + d.height);
        getVolume();
    }

    public static void getVolume() {
        Volume volume = new Volume();
        System.out.println("General volume: " + volume.GeneralVolumeValue);
        System.out.println("Effects volume: " + volume.EffectsVolumeValue);
        System.out.println("Music volume: " + volume.MusicVolumeValue);
    }


}

