package model.options;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import constants.ConfigKeys;
import constants.FileConstants;
import model.dungeon.Difficulty;


/**
 * This is the main option class.
 * Here you will get the requested volumes, resolution and other settings.

 *
 * @author Frederick Hastedt (mit Dank an Patrick fuer die Vorlage)
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
	private WindowMode windowMode;
	

	private boolean isFullscreen;
	private boolean isBorderlessWindow;

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
			setDifficultyConfig();
			setLanguage(savedOptions.getProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE));
			changeHappened();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void save() {
    	saveSoundConfig();
    	saveGraphicsConfig();
    	saveDifficultyConfig();
    	savedOptions.setProperty(ConfigKeys.GAME_CONFIG_KEY_FOR_LANGUAGE, getLanguage());
    	try {
			savedOptions.store(new FileOutputStream(FileConstants.PATH_TO_GAME_CONFIG), "");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void saveSoundConfig() {
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_GENERAL_VOLUME, String.valueOf(getMasterVolume()));
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_SOUND_VOLUME, String.valueOf(getSoundVolume()));
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_MUSIC_VOLUME, String.valueOf(getMusicVolume()));
    }
    
    private void saveGraphicsConfig() {
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW, String.valueOf(getWindowHeight()));
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW, String.valueOf(getWindowWidth()));
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_WINDOW_MODE, getWindowMode().toString());
    }

    private void saveDifficultyConfig() {
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_MOB_AI, String.valueOf(getMobAI()));
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_MOB_LEVEL, String.valueOf(getMobLevel()));
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_MOB_SPAWN_RATE, String.valueOf(getMobSpawnRate()));
    	savedOptions.setProperty(ConfigKeys.KEY_FOR_MOB_TIER, String.valueOf(getMobTier()));    	
    }
    
    private void setSoundConfig() {
    	setMasterVolume(Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_GENERAL_VOLUME)));
    	setSoundVolume(Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_SOUND_VOLUME)));
    	setMusicVolume(Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_MUSIC_VOLUME)));
    }
    
    private void setGraphicsConfig() {
    	setWindowHeight(Integer.parseInt(savedOptions.getProperty(ConfigKeys.KEY_FOR_HEIGHT_OF_WINDOW)));
    	setWindowWidth(Integer.parseInt(savedOptions.getProperty(ConfigKeys.KEY_FOR_WIDTH_OF_WINDOW)));
    	setWindowMode(WindowMode.valueOf(savedOptions.getProperty(ConfigKeys.KEY_FOR_WINDOW_MODE)));
    }
    
    private void setDifficultyConfig() {
    	this.difficulty = new Difficulty(Integer.parseInt(savedOptions.getProperty(ConfigKeys.KEY_FOR_MOB_SPAWN_RATE)),
    			Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_MOB_LEVEL)),
    			Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_MOB_TIER)),
    			Double.parseDouble(savedOptions.getProperty(ConfigKeys.KEY_FOR_MOB_AI)));
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
	
	public void setMobSpawnRate(double spawnRate) {
		getDifficulty().setMobSpawnRate((int)spawnRate);
		changeHappened();
	}
	
	public void setMobSpawnRate(int spawnRate) {
		getDifficulty().setMobSpawnRate(spawnRate);
		changeHappened();
	}
	
	public int getMobSpawnRate() {
		return getDifficulty().getMobSpawnRate();
	}
	
	public void setMobLevel(double mobLevel) {
		getDifficulty().setMobLevelRate(mobLevel);
		changeHappened();
	}
	
	public double getMobLevel() {
		return getDifficulty().getMobLevelRate();
	}
	
	public void setMobTier(double mobTier) {
		getDifficulty().setMobTier(mobTier);
		changeHappened();
	}
	
	public double getMobTier() {
		return getDifficulty().getMobTier();
	}
	
	public void setMobAI(double mobAI) {
		getDifficulty().setMobAI(mobAI);
		changeHappened();
	}
	
	public double getMobAI() {
		return getDifficulty().getMobAI();
	}

	public WindowMode getWindowMode() {
		return windowMode;
	}
	
	public void setWindowMode(WindowMode windowMode) {
		this.windowMode = windowMode;
		changeHappened();
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

	public boolean isFullscreen() {
		return isFullscreen;
	}

	public boolean isBorderlessWindow() {
		return isBorderlessWindow;
	}

    private Difficulty getDifficulty() {
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
		this.isBorderlessWindow = isBorderlessWindowed;
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