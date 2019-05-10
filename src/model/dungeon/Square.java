package model.dungeon;

import java.util.Objects;

import model.effects.Effect;
import model.effects.IEffectable;


/**
 * A Square is the elemental component of an Tile.
 * A Square can contain an Effect and an Terrain.
 *
 * @author Hagen
 */
public class Square implements IEffectable{

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


	@Override
	public void effect(Effect e) {
		e.apply(this);
	}

	@Override
	public void uneffect(Effect e) {
		e.deApply(this);
	}

	@Override
	public void reeffect(Effect e) {
		e.reApply(this);
	}
}
