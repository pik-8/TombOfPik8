package model.dungeon;

import java.util.Objects;


/**
 * A Dungeon contains the layout of itself and the objective, that has to be fulfilled to leaf the dungeon.
 *
 * @author Hagen
 */
public class Dungeon {

    private Tile[][] layout;
    private Objective objective;

    private Difficulty difficulty;


    protected Dungeon(Tile[][] layout, Objective objective, Difficulty difficulty) throws NullPointerException {
        this.layout = Objects.requireNonNull(layout);
        this.objective = Objects.requireNonNull(objective);
        this.difficulty = difficulty;
    }

    public Dungeon(Tile[][] layout, Difficulty difficulty) {
        this.layout = layout;
        this.difficulty = difficulty;
    }

    public Tile[][] getlayout() {
        return layout;
    }

    public Objective getObjective() {
        return objective;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
