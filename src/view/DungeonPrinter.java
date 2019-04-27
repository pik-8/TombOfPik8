package view;

import model.dungeon.Dungeon;
import model.dungeon.Landscape;
import model.dungeon.Terrain;
import model.dungeon.Tile;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;


/**
 * @author Hagen
 */
public class DungeonPrinter {

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

    public void printLandscapes (Dungeon dungeon) {
        for (int y = 0; y < dungeon.getlayout()[0].length; y++) {
            for (int x = 0; x < dungeon.getlayout().length; x++) {
                printLetterOfLandscape(dungeon.getlayout()[x][y]);
            }
        }
    }


    private void printLetterOfTerrain (Terrain terrain) {
        switch (terrain){
            case NONE:
                System.out.print('_');
                break;
            case TREE:
                System.out.print('T');
                break;
            case BEDROCK:
                System.out.print('B');
                break;
            case START_POINT:
                System.out.print('S');
                break;
        }
    }

    private void printLetterOfLandscape (Tile tile) {
        if (tile.getLandscape() != null) {
            switch (tile.getLandscape()){
                case FOREST:
                    System.out.print('F');
                    break;
            }
        }
        else {
            System.out.print('-');
        }
    }

    private void printOneEmptyLine (int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(' ');
        }
    }
}
