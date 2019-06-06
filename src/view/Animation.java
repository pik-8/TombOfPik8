package view;


import constants.view.DefaultTextureSize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A class that will change the images inside off it, in the order that they are inside the array.
 * The frequency is determined by the int fps.
 * Has to be started by the start-method to start the change of images.
 *
 * When the animation should be stopped, use the stop() method.
 * When the animation should be continued, use the start() method.
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
        ViewController.getViewController().removeAnimation(this);
    }

    public void start () {
        ViewController.getViewController().addAnimation(this);
    }
}
