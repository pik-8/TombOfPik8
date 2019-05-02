package model.dungeon;


/**
 * An Exception to be used with everything concerning the dungeon
 * where no native Java exception fits the use-case.
 *
 * @author Frederick
 */
public class DungeonException extends Exception {

	public DungeonException(String message) {
		super(message);
	}
}
