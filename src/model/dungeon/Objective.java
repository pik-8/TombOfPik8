package model.dungeon;


/**
 * An Objective is an object, that determines, when a dungeon is finished.
 * To make win conditions unique, we made it as an interface, so that new conditions have to be made.
 *
 * @author Hagen
 */
public interface Objective {

    String getWinCondition ();
    boolean isFullfilled ();

}
