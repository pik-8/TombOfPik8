package model.dungeon;

import model.effects.Effect;

import java.util.Objects;


/**
 * A Square is the elemental component of an Tile.
 * A Square can contain an Effect and an Terrain.
 *
 * @author Hagen
 */
public class Square {

    private Terrain terrain;
    private Effect effect;

    /**
     * The constructor for creating a Square-Object.
     *
     * @param terrain The Terrain which should be on this Square.
     * @param effect An Effect which should be on this Square.
     * @throws NullPointerException If, at least one param is null.
     */
    public Square(Terrain terrain, Effect effect) throws NullPointerException{
        this.terrain = Objects.requireNonNull(terrain);
        setEffect(effect);
    }


    public Terrain getTerrain() {
        return terrain;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
