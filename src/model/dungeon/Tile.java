package model.dungeon;

import constants.ModelProperties;

import java.util.Objects;

import static constants.ExceptionConstants.*;


/**
 * A Til-Object contains an Array of Square-Objects, which form the Tile.
 * A Tile can only be created if the array forms a square and has a specific size.
 *
 * Can not be instantiated, only through subclasses.
 *
 * @author Hagen
 */
public class Tile {

    private Square[][] layout;
    private Landscape landscape;

    private int size;


    /**
     * Generates a Tile from all the necessary informations a Tile has.
     *
     * @param layout: A quadratic Square-Array, that basically form a Tile.
     *                Every Square must not be null.
     * @param landscape: The type of landscape this Tile is.
     */
    public Tile (Square[][] layout, Landscape landscape) throws IllegalArgumentException, NullPointerException{
        checkLayout(layout);
        this.layout = layout;
        this.size = layout.length;
        this.landscape = landscape;
    }


    /**
     * generates a random Tile from the landscape and size.
     * @param landscape: Determines the Terrain of the Tile.
     * @param size: How big this tile should be.
     */
    public Tile (Landscape landscape, int size) {
        this.size = size;
        this.landscape = landscape;
        this.layout = utility.TileGenerator.generateSquaresAsTiel(size, landscape);
    }


    private void checkLayout (Square[][] field) throws IllegalArgumentException{
        for (int x = 0; x < field.length; x++) {
            if (field[x].length != field.length) {
                throw new IllegalArgumentException(FIELD_FOR_TILE_IS_NO_SQUARE);
            }
        }

        for (Square[] squareLine : field) {
            for (Square square : squareLine) {
                if (square == null) {
                    throw new IllegalArgumentException(SQUARE_IN_TILE_IS_NULL);
                }
            }
        }
    }


    public Square[][] getLayout () {
        return this.layout;
    }

    public int getSize () {
        return this.size;
    }

    public Landscape getLandscape () {
        return this.landscape;
    }
    
    public Square get(Position pos) {
    	return this.getLayout()[pos.getxSquare()][pos.getySquare()];
    }
}
