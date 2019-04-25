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

    private int size;

    protected Tile (Square[][] layout) throws IllegalArgumentException, NullPointerException{
        checkLayout(Objects.requireNonNull(layout));
        this.layout = layout;
        this.size = layout.length;
    }

    private void checkLayout (Square[][] field) throws IllegalArgumentException{
        for (int x = 0; x < field.length; x++) {
            if (field[x].length != field.length) {
                throw new IllegalArgumentException(FIELD_FOR_TILE_IS_NO_SQUARE);
            }
        }

        boolean hasSize = false;
        for (int possibleSize: ModelProperties.ALLOWED_TILE_SIZES){
            if (field.length == possibleSize) {
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
