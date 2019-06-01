package view;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static java.lang.Thread.sleep;


/**
 * A class that will change the images inside off it, in the order that they are inside the array.
 * The frequency is determined by the int fps.
 * Has to be started from a Thread-Object.
 *
 * How to use.
 * 1. Create an Animation-Instance.
 * 2. Create a Thread-Object with this instance as a parameter.
 * 3. Start the thread.
 * 4. Put the Animation-Object (not the Thread) in a Scene.
 *
 * Step 4 and 5 may not be in order.
 *
 * When the animation should be stopped, use the stop() method.
 * When the animation should be continued, use the resume() method.
 *
 * @author Hagen
 */
public class Animation extends ImageView implements Runnable{


    private Image[] images;
    private int index;
    private int pauseBetweenImages;

    private boolean isRunning;


    public Animation(Image[] images, int fps) {
        this.images = images;
        this.pauseBetweenImages = Math.round(1000 / fps);
        this.setImage(images[0]);
        this.index = 1;
        this.isRunning = true;
    }


    @Override
    public void run() {
        if(this.isRunning) {
            if (this.index < images.length) {
                this.setImage(images[index]);
                index++;
            }
            else {
                this.setImage(images[0]);
                index = 1;
            }
            try {
                sleep(pauseBetweenImages);
                this.run();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    public float getHeight () {
        int height = 0;
        int numberOfImages = 0;
        for (Image image : images) {
            height += image.getHeight();
            numberOfImages++;
        }
        return height / numberOfImages;
    }


    public float getWidth () {
        int width = 0;
        int numberOfImages = 0;
        for (Image image : images) {
            width += image.getWidth();
            numberOfImages++;
        }
        return width / numberOfImages;
    }


    public void stop () {
        this.isRunning = false;
    }

    public void resume () {
        this.isRunning = true;
        run();
    }
}
