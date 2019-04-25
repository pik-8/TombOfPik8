package utility;

import constants.ModelProperties;
import model.dungeon.Landscape;
import model.dungeon.Square;
import model.dungeon.Terrain;
import model.dungeon.Tile;
import model.effects.Condition;
import model.effects.EffectFactory;

import java.util.Random;


/**
 * A class to create the "guts", the square and terrain layout, of an Tile-Object from a template, randomly
 * or with a few instructions.
 *
 * @author Hagen
 */
public class TileGenerator {

    private TileGenerator () {}


    /**
     * Generates an two-dimensional array of squares, that can be used to generate a tile.
     *
     * @param size: The size of the two dimensions of the array.
     * @param type: The type of landscape to determine the terrains.
     * @return
     */
    public static Square[][] generateSquaresAsTiel (int size, Landscape type) {
        Square[][] squares = new Square[size][size];
        fillSquaresWithStandard(squares);
        fillSquare(squares, type.getPossibleTerrains());
        return squares;
    }


    public static Tile getTile7x7 (Landscape type, boolean hasTileToRight, boolean hasTileToLeft,
                                   boolean hasTileAbove, boolean hasTileBelow) {
        switch (type) {
            case FOREST:
                Square[][] squares = new Square[7][7];
                fillSquaresWithStandard(squares);
                //setBorders(squares, Forest.endMarker, hasTileToRight, hasTileToLeft, hasTileAbove, hasTileBelow);
                //fillSquare(squares, Forest.allPossibleTerrains);
                checkIfSquareIsTraversable();
                // return new Forest(squares);
            default:
                return null;
        }
    }

    private static void checkIfSquareIsTraversable () {
        //TODO implement the algorithm.
    }


    private static void fillSquare (Square[][] squares, Terrain[] possibleTerrains) {
        Random random = new Random();
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares.length; y++) {
                if (random.nextFloat() <= ModelProperties.PROBABILITY_TO_SPAWN_A_TERRAIN) {
                    if (squares[x][y].getTerrain() == null || squares[x][y].getTerrain() == Terrain.NONE) {
                        squares[x][y] = new Square(possibleTerrains[random.nextInt(possibleTerrains.length)], EffectFactory.getEffect(Condition.NONE));
                    }
                }
            }
        }
    }


    private static void setBorders (Square[][] squares, Terrain borderMaterial, boolean hasTileToRight, boolean hasTileToLeft,
                                    boolean hasTileAbove, boolean hasTileBelow) {
        if (!hasTileAbove) {
            fillYDimension(0, squares, borderMaterial);
        }

        if (!hasTileBelow) {
            fillYDimension(squares.length -1, squares, borderMaterial);
        }

        if (!hasTileToLeft) {
            fillXDimension(0, squares, borderMaterial);
        }

        if (!hasTileToRight) {
            fillXDimension(squares.length -1, squares, borderMaterial);
        }
    }

    /**
     * Sets on every field in the array with the given x value the given terrain.
     *
     * @param xIndex The column that should be filled.
     * @param squares The array that should be filled.
     * @param terrain the terrain that should be placed on the whole column.
     */
    private static void fillXDimension (int xIndex, Square[][] squares, Terrain terrain) {
        for (int y = 0; y < squares[xIndex].length; y++) {
            squares[xIndex][y] = new Square(terrain, EffectFactory.getEffect(Condition.NONE));
        }
    }


    /**
     * Almost the same as fillXDimension, however instead of an column a line will be filled.
     */
    private static void fillYDimension (int yIndex, Square[][] squares, Terrain terrain) {
        for (int x = 0; x < squares[yIndex].length; x++) {
            squares[x][yIndex] = new Square(terrain, EffectFactory.getEffect(Condition.NONE));
        }
    }


    public static Square[][] generateTerrainOnSquare (int size, boolean hasTileToRight, boolean hasTileToLeft,
                                                      boolean hasTileAbove, boolean hasTileBelow,
                                                      Terrain[] allowedTerrains, Terrain endMarker) {
        //TODO implement the Method.
        return null;
    }

    private static void fillSquaresWithStandard (Square[][] squares) {
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares.length; y++) {
                squares[x][y] = new Square(Terrain.NONE, EffectFactory.getEffect(Condition.NONE));
            }
        }
    }
}
