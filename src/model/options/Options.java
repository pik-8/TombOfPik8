package model.options;

import java.awt.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import constants.ModelProperties;
import model.dungeon.Difficulty;

import java.io.*;

import static constants.FileConstants.*;


/**
 * This is the main option class.
 * Here you will get the requested volumes, resolution and other settings.

 *
 * @author Patrick Szalewicz
 */

public class Options {

    private static Options activeSaveStateOptions;

    private Difficulty difficulty;
    private double masterVolume;


    public static Options getActiveOptions() {
        if (activeSaveStateOptions == null) {
            activeSaveStateOptions = new Options();
        }
        return activeSaveStateOptions;
    }

    private Options () {
        this.masterVolume = ModelProperties.MASTER_VOLUME_MIN_VALUE;
    }


    public double getMasterVolume() {
        return masterVolume;
    }

    public void setMasterVolume(double masterVolume) {
        this.masterVolume = masterVolume;
    }
}