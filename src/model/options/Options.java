package model.options;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import constants.ConfigKeys;
import constants.FileConstants;
import model.dungeon.Difficulty;


/**
 * This is the main option class.
 * Here you will get the requested volumes, resolution and other settings.

 *
 * @author Patrick Szalewicz
 */

public class Options {

    private static Options activeSaveStateOptions;
    private Properties savedOptions;
    private boolean hasRecentlyChanged;
    
    // Difficulty Options
    private Difficulty difficulty;
    
    // Language Options
    private String language;

    // Volume Options
	private double masterVolume;
	private double soundVolume;
	private double musicVolume;
	
	// Graphic Options
	private int windowHeight;
	private int windowWidth;
	private boolean isFullscreen;
	private boolean isBorderlessWindowed;

    public static Options getActiveOptions() {
        if (activeSaveStateOptions == null) {
            activeSaveStateOptions = new Options();
        }
        return activeSaveStateOptions;
    }

    private Options () {
    	this.savedOptions = new Properties();
    	try {
			savedOptions.load(new FileInputStream(FileConstants.PATH_TO_GAME_CONFIG));
			
			setSoundConfig();
			setGraphicsConfig();
			setLanguage(savedOptions.getProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE));
			changeHappened();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public boolean hasRecentlyChanged() {
		return hasRecentlyChanged;
	}

	public void changeHappened() {
		this.hasRecentlyChanged = true;
	}
	
	public void changeApplied() {
		this.hasRecentlyChanged = false;
	}

	private void setSoundConfig() {
    	setMasterVolume(Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_GENERAL_VOLUME)));
    	setSoundVolume(Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_SOUND_VOLUME)));
    	setMusicVolume(Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_MUSIC_VOLUME)));
    }
    
    private void setGraphicsConfig() {
    	setWindowHeight(Integer.parseInt(savedOptions.getProperty(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW)));
    	setWindowWidth(Integer.parseInt(savedOptions.getProperty(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW)));
    	setIsFullscreen(Boolean.parseBoolean(savedOptions.getProperty(ConfigKeys.KEY_FOR_FULLSCREEN)));
    	setIsBorderlessWindowed(Boolean.parseBoolean(savedOptions.getProperty(ConfigKeys.KEY_FOR_BORDERLESS_WINDOW)));
    }
    
    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
		changeHappened();
	}

	public double getSoundVolume() {
		return soundVolume;
	}

	public double getMusicVolume() {
		return musicVolume;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public boolean getIsFullscreen() {
		return isFullscreen;
	}

	public boolean getIsBorderlessWindowed() {
		return isBorderlessWindowed;
	}

    
    public Difficulty getDifficulty() {
    	return difficulty;
    }

	public void setSoundVolume(double soundVolume) {
		this.soundVolume = soundVolume;
		changeHappened();
	}

	public void setMusicVolume(double musicVolume) {
		this.musicVolume = musicVolume;
		changeHappened();
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
		changeHappened();
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
		changeHappened();
	}

	public void setIsFullscreen(boolean isFullscreen) {
		this.isFullscreen = isFullscreen;
		changeHappened();
	}

	public void setIsBorderlessWindowed(boolean isBorderlessWindowed) {
		this.isBorderlessWindowed = isBorderlessWindowed;
		changeHappened();
	}

	public double getMasterVolume() {
        return masterVolume;
    }

    public void setMasterVolume(double masterVolume) {
        this.masterVolume = masterVolume;
        changeHappened();
    }
}