package model.dungeon;


/**
 * A Factory, that produces different types Tiles.
 *
 * Uses Landscape-Enum to determine the specific type of Tile.
 *
 * A Tile can only be generated from this class.
 *
 * @author Hagen
 */
public class TileFactory {

    private TileFactory () {}

    public static Tile getTile7x7 (Landscape type) {
        switch (type) {
            case FOREST:
                return new Forest(new Square[7][7]);
            default:
                return null;
        }
    }
}
