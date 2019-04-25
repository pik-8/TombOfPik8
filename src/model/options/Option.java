package model.options;

import java.awt.*;

import static model.options.WindowSize.*;

public enum WindowSize {
    LOW(858, 480, false),
    MEDIUM(1280, 720, false),
    HIGH(1920, 1080, false),
    HIGH_FULL(1920, 1080, true);

    private Integer width;
    private Integer height;
    private boolean isFullscreen;

    WindowSize(Integer width, Integer height, boolean isFullscreen) {
        this.width = width;
        this.height = height;
        this.isFullscreen = isFullscreen;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean getisFullscreen() {
        return isFullscreen;
    }
}

public class Option {

    public static void defaultOptions() {

        //Here I'm declaring my Option variables and setting a default value which can be overwritten at the game load.
        int GeneralVolume = 50;
        int MusicVolume = 50;
        int EffectsVolume = 50;
    }

    public static void getWindowSize(String[] args) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        //System.out.println("Screen width = " + d.width);
        //System.out.println("Screen height = " + d.height);
    }

    public static void getSelectedWindowSize(String[] args) {

        switch(WindowSize) {
            case LOW:
                System.out.println("Window size is low - Width: " + this.windowsize.getWidth() + " x Height: " + this.windowsize.getHeight() + " fullscreen? " + this.windowsize.getisFullscreen());
                break;
            case MEDIUM:
                System.out.println("Window size is medium - Width: " + this.windowsize.getWidth() + " x Height: " + this.windowsize.getHeight() + " fullscreen? " + this.windowsize.getisFullscreen());
                break;
            case HIGH:
                System.out.println("Window size is high - Width: " + this.windowsize.getWidth() + " x Height: " + this.windowsize.getHeight() + " fullscreen? " + this.windowsize.getisFullscreen());
                break;
            case HIGH_FULL:
                System.out.println("Window size is high and fullscreen - Width: " + this.windowsize.getWidth() + " x Height: " + this.windowsize.getHeight() + " fullscreen? " + this.windowsize.getisFullscreen());
                break;
            default:
                this.windowsize = MEDIUM;
                System.out.println("Window size is medium - Width: " + this.windowsize.getWidth() + " x Height: " + this.windowsize.getHeight() + " fullscreen? " + this.windowsize.getisFullscreen());
                break;


        }
    }
}
