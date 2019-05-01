package model.dungeon;

import model.characters.Character;

import java.util.Objects;


/**
 * A Dungeon contains the layout of itself and the objective, that has to be fulfilled to leaf the dungeon.
 *
 * @author Hagen
 */
public class Dungeon {

    private Tile[][] layout;
    private Objective objective;
    private Character[][] mobLayout;


    protected Dungeon(Tile[][] layout, Objective objective) throws NullPointerException {
        this.layout = Objects.requireNonNull(layout);
        this.objective = Objects.requireNonNull(objective);
    }

    public Dungeon(Tile[][] layout, Character[][] mobLayout) {
        this.layout = layout;
        this.mobLayout = mobLayout;
    }

    public Tile[][] getlayout() {
        return layout;
    }

    public Objective getObjective() {
        return objective;
    }

    public Character[][] getMobLayout() {
        return mobLayout;
    }
}
