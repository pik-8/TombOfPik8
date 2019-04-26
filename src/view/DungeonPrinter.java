package view;

import model.dungeon.Dungeon;
import model.dungeon.Terrain;
import model.dungeon.Tile;


/**
 * @author Hagen
 */
public class DungeonPrinter {

    public void printDungeon (Dungeon dungeon, int tileSize) {


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

    public  void printTile (Tile tile) {
        for (int y = 0; y < tile.getlayout().length; y++) {
            for (int x = 0; x < tile.getlayout().length; x++) {
                printLetterOfTerrain(tile.getlayout()[x][y].getTerrain());
            }
            System.out.println();
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
        }
    }

    private void printOneEmptyLine (int size) {
        for (int i = 0; i < size; i++) {
            System.out.print('-');
        }
    }
}
