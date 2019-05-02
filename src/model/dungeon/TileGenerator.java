package model.dungeon;

import constants.ModelProperties;
import constants.balancing.Factors;
import model.dungeon.Landscape;
import model.dungeon.Square;
import model.dungeon.Terrain;
import model.dungeon.Tile;
import model.effects.HealingEffect;

import java.util.Random;


/**
 * A singelton class to create the "guts", the square and terrain layout, of an Tile-Object from a template, randomly
 * or with a few instructions.
 *
 * @author Hagen
 */
public class TileGenerator {

    private static TileGenerator tileGenerator;

    private TileGenerator () {}


    public static TileGenerator getTileGenerator () {
        if (tileGenerator == null) {
            return new TileGenerator();
        }
        return tileGenerator;
    }


    /**
     * Generates an two-dimensional array of squares, that can be used to generate a tile.
     *
     * @param size: The size of the two dimensions of the array.
     * @param type: The type of landscape to determine the terrains.
     * @return
     */
    public Square[][] generateSquaresAsTiel (int size, Landscape type) {
        Square[][] squares = new Square[size][size];
        fillSquaresWithStandard(squares);
        fillSquare(squares, type.getPossibleTerrains());
        return squares;
    }


    public Tile getTile (int size, Landscape type, boolean hasTileToRight, boolean hasTileToLeft,
                                boolean hasTileAbove, boolean hasTileBelow)
    {
        Square[][] squares = new Square[size][size];
        fillSquaresWithStandard(squares);
        setBorders(squares, type, hasTileToRight, hasTileToLeft, hasTileAbove, hasTileBelow);
        fillSquare(squares, type.getPossibleTerrains());
        checkIfSquareIsTraversable();
        return new Tile(squares, type);
    }

    public Tile getTile7x7 (Landscape type, boolean hasTileToRight, boolean hasTileToLeft,
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

    private void checkIfSquareIsTraversable () {
        //TODO implement the algorithm.
    }


    private void fillSquare (Square[][] squares, Terrain[] possibleTerrains) {
        Random random = new Random();
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares.length; y++) {
                if (random.nextFloat() <= Factors.PROBABILITY_TO_SPAWN_A_TERRAIN) {
                    if (squares[x][y].getTerrain() == null || squares[x][y].getTerrain() == Terrain.NONE) {
                        squares[x][y] = new Square(possibleTerrains[random.nextInt(possibleTerrains.length)], new HealingEffect());
                    }
                }
            }
        }
    }


    private void setBorders (Square[][] squares, Landscape landscape, boolean hasTileToRight, boolean hasTileToLeft,
                                    boolean hasTileAbove, boolean hasTileBelow) {
        if (!hasTileAbove) {
            fillYDimension(0, squares, landscape.getBorders());
        }

        if (!hasTileBelow) {
            fillYDimension(squares.length -1, squares, landscape.getBorders());
        }

        if (!hasTileToLeft) {
            fillXDimension(0, squares, landscape.getBorders());
        }

        if (!hasTileToRight) {
            fillXDimension(squares.length -1, squares, landscape.getBorders());
        }
    }

    /**
     * Sets on every field in the array with the given x value the given terrain.
     *
     * @param xIndex The column that should be filled.
     * @param squares The array that should be filled.
     * @param terrains the terrains that should be placed randomly on the whole column.
     */
    private void fillXDimension (int xIndex, Square[][] squares, Terrain[] terrains) {
        Random random = new Random();
        for (int y = 0; y < squares[xIndex].length; y++) {
            squares[xIndex][y] = new Square(terrains[random.nextInt(terrains.length)], new HealingEffect());
        }
    }


    /**
     * Almost the same as fillXDimension, however instead of an column a line will be filled.
     */
    private void fillYDimension (int yIndex, Square[][] squares, Terrain terrains[]) {
        Random random = new Random();
        for (int x = 0; x < squares[yIndex].length; x++) {
            squares[x][yIndex] = new Square(terrains[random.nextInt(terrains.length)], new HealingEffect());
        }
    }


    public Square[][] generateTerrainOnSquare (int size, boolean hasTileToRight, boolean hasTileToLeft,
                                                      boolean hasTileAbove, boolean hasTileBelow,
                                                      Terrain[] allowedTerrains, Terrain endMarker) {
        //TODO implement the Method.
        return null;
    }

    private void fillSquaresWithStandard (Square[][] squares) {
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares.length; y++) {
                squares[x][y] = new Square(Terrain.NONE, new HealingEffect());
            }
        }
    }
}
