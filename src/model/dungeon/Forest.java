package model.dungeon;


/**
 * Class, to instantiate a specific type of a Tile, in this case a Forest-Type.
 *
 *
 * @author hagen
 */
class Forest extends Tile{

    protected Forest(Square[][] layout) throws IllegalArgumentException {
        super(layout);
    }
}
