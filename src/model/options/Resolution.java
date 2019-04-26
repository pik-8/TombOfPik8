package model.options;

import javafx.application.Application;
import javafx.stage.Stage;

import static model.options.Resolution.WindowSize.MEDIUM;

/**
 * This class is used to store and get the resolutions
 *
 * ToDo:
 * - add saving and loading with gson
 * - add fullscreen option
 * - change the enum (remove *_FULL)
 *
 * @author Patrick Szalewicz
 */

public class Resolution {

    enum WindowSize {
        LOW(858, 480, false),
        MEDIUM(1280, 720, false),
        HIGH(1920, 1080, false),
        MEDIUM_FULL(1280, 720, true),
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

        public Boolean getIfFullscreen() {
            return isFullscreen;
        }
    }


    public static void getSelectedWindowSize(Resolution.WindowSize winSiz) {

        switch(winSiz) {
            case LOW:
                System.out.println("Window size is low - Width: " + winSiz.getWidth() + " x Height: " + winSiz.getHeight() + " fullscreen? " + winSiz.getIfFullscreen());
                break;
            case MEDIUM:
                System.out.println("Window size is medium - Width: " + winSiz.getWidth() + " x Height: " + winSiz.getHeight() + " fullscreen? " + winSiz.getIfFullscreen());
                break;
            case HIGH:
                System.out.println("Window size is high - Width: " + winSiz.getWidth() + " x Height: " + winSiz.getHeight() + " fullscreen? " + winSiz.getIfFullscreen());
                break;
            case MEDIUM_FULL:
                System.out.println("Window size is medium and fullscreen - Width: " + winSiz.getWidth() + " x Height: " + winSiz.getHeight() + " fullscreen? " + winSiz.getIfFullscreen());
                break;
            case HIGH_FULL:
                System.out.println("Window size is high and fullscreen - Width: " + winSiz.getWidth() + " x Height: " + winSiz.getHeight() + " fullscreen? " + winSiz.getIfFullscreen());
                break;
            default:
                winSiz = MEDIUM;
                System.out.println("Window size is medium - Width: " + winSiz.getWidth() + " x Height: " + winSiz.getHeight() + " fullscreen? " + winSiz.getIfFullscreen());
                break;
        }
    }

}
