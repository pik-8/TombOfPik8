package model.dungeon;


/**
 * Class, to instantiate a specific type of a Tile, in this case a Forest-Type.
 *
 *
 * @author hagen
 */
class Forest extends Tile{

    public static final Terrain[] allPossibleTerrains = {Terrain.TREE};
    public static final Terrain endMarker = Terrain.BEDROCK;

    protected Forest(Square[][] squares) throws IllegalArgumentException {
        super(squares);
    }
}
