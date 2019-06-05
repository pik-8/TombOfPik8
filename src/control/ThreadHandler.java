package control;

import view.Animation;

import java.util.ArrayList;
import java.util.List;

public class ThreadHandler {

    private static ThreadHandler instance;

    private List<Thread> allThreads;
    private List<Animation> allAnimations;


    private ThreadHandler () {
        this.allThreads = new ArrayList<>();
        this.allAnimations = new ArrayList<>();
    }

    public static ThreadHandler getThreadHandler () {
        if (instance == null){
            instance = new ThreadHandler();
        }
        return instance;
    }

    public void removeThread (Thread thread) {
        this.allThreads.remove(thread);
    }


    public void addThread (Thread thread) {
        this.allThreads.add(thread);
    }


    public void removeAnimation (Animation animation) {
        this.allAnimations.remove(animation);
    }


    public void addAnimation (Animation animation) {
        this.allAnimations.add(animation);
    }

    public void stopAllAnimations () {
        for (Animation animation : this.allAnimations) {
            animation.stop();
        }
    }

    public void removeAllAnimations () {
        stopAllAnimations();
        this.allAnimations.clear();
    }
}
