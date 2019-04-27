package view;

import model.dungeon.Dungeon;
import model.dungeon.Landscape;
import model.dungeon.Terrain;
import model.dungeon.Tile;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;


/**
 * A class that prints a map of dungeons.
 * Either the whole map with the Terrain-Objects or every landscape.
 *
 * @author Hagen
 */
public class DungeonPrinter {


    /**
     * Prints every Terrain-object in the dungeon as a map.
     * Prints the first two letters of a terrain.
     *
     * @param dungeon: The dungeon that should be printed.
     */
    public void printDungeon (Dungeon dungeon) {
        int tileSize = 0;

        //searches through the layout to find a tile that is not null to get the length of the tiles.
        for (int i = 0; i < dungeon.getlayout().length; i++) {
            for (int j = 0; j < dungeon.getlayout()[i].length; j++) {
                if (dungeon.getlayout()[i][j] != null) {
                    tileSize = dungeon.getlayout()[i][j].getSize();
                    i = dungeon.getlayout().length -1;
                    j = dungeon.getlayout()[i].length;
                }
            }
        }
        /*
        for (Tile tiles[] : dungeon.getlayout()) {
            tileSize = Arrays.stream(tiles).filter(field -> field != null).findFirst().get().getSize();
        }
         */
        for (int y = 0; y < dungeon.getlayout()[0].length; y++) {
            for (int tileYIndex = 0; tileYIndex < tileSize; tileYIndex++) {
                for (int x = 0; x < dungeon.getlayout().length; x++) {
                    if (dungeon.getlayout()[x][y] != null) {
                        for (int tileX = 0; tileX < tileSize; tileX++) {
                            printLetterOfTerrain(dungeon.getlayout()[x][y].getlayout()[tileX][tileYIndex].getTerrain());
                        }
                    } else {
                        printOneEmptyLine(tileSize);
                    }
                }
                System.out.println();
            }
        }
    }


    /**
     * Prints the first two letters of a landscape and creates a map of the dungeon.
     *
     * @param dungeon: The dungeon that should be printed.
     */
    public void printLandscapes (Dungeon dungeon) {
        for (int y = 0; y < dungeon.getlayout()[0].length; y++) {
            for (int x = 0; x < dungeon.getlayout().length; x++) {
                printOneLetterForLandscape(dungeon.getlayout()[x][y]);
            }
            System.out.println();
        }
    }


    private void printLetterOfTerrain (Terrain terrain) {
        if (terrain == Terrain.NONE) {
            System.out.print("   ");
        } else {
            System.out.print(((terrain.name().charAt(0))) + String.valueOf(terrain.name().charAt(1))
                    .toLowerCase() + " ");
        }
    }


    private void printOneLetterForLandscape (Tile tile) {
        if (tile == null) {
            System.out.print("  ");
        } else {
            System.out.print(tile.getLandscape().name().charAt(0) + " ");
        }

    }


    private void printTwoLettersOfLandscape (Tile tile) {
        if (tile != null) {
            System.out.print((String.valueOf(tile.getLandscape().name().charAt(0))) + String.valueOf(
                    tile.getLandscape().name().charAt(1)).toLowerCase() + " ");
        }
        else {
            System.out.print("   ");
        }
    }

    private void printOneEmptyLine (int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("   ");
        }
    }
}
