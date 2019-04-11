package model.dungeon;

import java.util.Objects;


/**
 * A Dungeon contains the map of itself and the objective, that has to be fulfilled to leaf the dungeon.
 *
 * @author hagen
 */
public class Dungeon {

    private Tile[][] map;
    private Objective objective;


    public Dungeon(Tile[][] map, Objective objective) throws NullPointerException {
        this.map = Objects.requireNonNull(map);
        this.objective = Objects.requireNonNull(objective);
    }


    public Tile[][] getMap() {
        return map;
    }

    public void setMap(Tile[][] map) {
        this.map = map;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
