package model.dungeon;

import java.io.ObjectInput;
import java.util.Objects;


/**
 * A Dungeon contains the layout of itself and the objective, that has to be fulfilled to leaf the dungeon.
 *
 * @author Hagen
 */
public class Dungeon {

    private Tile[][] layout;
    private Objective objective;


    protected Dungeon(Tile[][] layout, Objective objective) throws NullPointerException {
        this.layout = Objects.requireNonNull(layout);
        this.objective = Objects.requireNonNull(objective);
    }

    public Dungeon (int size, Objective objective, Landscape[] possibleLandscapes) {
        //this.layout = .DungeonCreator.generateDungeonLayout(size, possibleLandscapes);
        this.objective = objective;
    }

    public Dungeon(Tile[][] layout) {
        this.layout = layout;
    }

    public Tile[][] getlayout() {
        return layout;
    }

    public Objective getObjective() {
        return objective;
    }
}
