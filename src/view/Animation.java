package view;


import constants.view.DefaultTextureSize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
public class Animation extends ImageView {


    private Image[] images;
    private int index;
    private long timeBetweenFrames;

    private long waitedTime;


    /**
     *
     * @param images Every image should have the same size
     * @param fps
     */
    public Animation(Image[] images, int fps) {
        this.images = images;
        this.setImage(images[0]);
        this.index = 1;
        this.timeBetweenFrames = 1000000000 / fps; //1,000,000,000 = 1 second, time is measured in nano seconds.
        this.waitedTime = 0;
    }


    public void nextImage (long deltaT) {
        this.waitedTime += deltaT;
        if (Math.abs(this.waitedTime) >= this.timeBetweenFrames) {
            this.waitedTime = 0;
            if (this.index < this.images.length) {
                this.setImage(this.images[index]);
                this.index++;
            }
            else {
                this.setImage(images[0]);
                this.index = 1;
            }
        }
    }

    public void sizeToScene (double width, double height) {
        this.setFitWidth(this.getImage().getWidth() / (DefaultTextureSize.width / width));
        this.setFitHeight(this.getImage().getHeight() / (DefaultTextureSize.height / height));
    }

    public void stop () {
        GUIController.getActiveGuiController().removeAnimation(this);
    }

    public void start () {
        GUIController.getActiveGuiController().addAnimation(this);
    }
}
