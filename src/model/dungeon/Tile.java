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

    public Tile (Square[][] layout, Landscape landscape) throws IllegalArgumentException, NullPointerException{
        checkLayout(Objects.requireNonNull(layout));
        this.layout = layout;
        this.size = layout.length;
        this.landscape = landscape;
    }


    public Tile (int size, Landscape landscape) {
        this.size = size;
        checkSize(size);
        this.landscape = landscape;
        utility.TileGenerator.generateSquaresAsTiel(size, landscape);
        //should here also be checked if the squares are valid?
    }


    private void checkLayout (Square[][] field) throws IllegalArgumentException{
        for (int x = 0; x < field.length; x++) {
            if (field[x].length != field.length) {
                throw new IllegalArgumentException(FIELD_FOR_TILE_IS_NO_SQUARE);
            }
        }

        checkSize(field.length);
    }

    private void checkSize (int size) {
        boolean hasSize = false;
        for (int possibleSize: ModelProperties.ALLOWED_TILE_SIZES){
            if (size == possibleSize) {
                hasSize = true;
            }
        }

        if (!hasSize) {
            throw new IllegalArgumentException(FIELD_HAS_NOT_THE_RIGHT_SIZE);
        }
    }


    public Square[][] getlayout () {
        return this.layout;
    }

    public int getSize () {
        return this.size;
    }
}
