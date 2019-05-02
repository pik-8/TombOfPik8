package model.options;

import java.awt.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;

import static constants.FileConstants.*;


/**
 * This is the main option class.
 * Here you will get the requested volumes, resolution and other settings.

 *
 * @author Patrick Szalewicz
 */

public class Options {

    private Volume volume;
    private Gson gson;
    private static String resolution;
    private static String language;
    private static int generalVolume;
    private static int effectVolume;
    private static int musicVolume;


    public static void main(String[] args) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.println("Screen width = " + d.width + ", Screen height = " + d.height);
        getVolume("generalVolume");
        getVolume("effectVolume");
        getVolume("musicVolume");
        getResolution("resolution");
        getSettings("language");
    }

    private static void getSettings(String args) {
        try {
            String path = PATH_TO_SAVING_OPTION;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            JsonObject jobj = new Gson().fromJson(bufferedReader, JsonObject.class);

            String setting = jobj.get(args).toString();

            System.out.println(setting);

        } catch (FileNotFoundException ie) {
            ie.printStackTrace();
        }
    }

    public static void getVolume(String args) {
        getSettings(args);
    }

    public void setVolume (Volume volume) {
        this.volume = volume;
    }

    public static void getResolution(String args) {
        getSettings(args);
    }

}