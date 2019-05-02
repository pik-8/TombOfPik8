package view;

import model.characters.Character;
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
     * Prints the first two letters of a landscape and creates a map of the dungeon.
     *
     * @param dungeon: The dungeon that should be printed.
     */
    public static void printLandscapes (Dungeon dungeon) {
        for (int y = 0; y < dungeon.getLayout()[0].length; y++) {
            for (int x = 0; x < dungeon.getLayout().length; x++) {
                printOneLetterForLandscape(dungeon.getLayout()[x][y]);
            }
            System.out.println();
        }
    }


    public static void printMobLayout (Character[][] mobLayout) {
        for (int y = 0; y < mobLayout[0].length; y++) {
            for (int x = 0; x < mobLayout.length; x++) {
                printLetterOfMob(mobLayout[x][y]);
            }
            System.out.println();
        }
    }


    public static void printDungeon (Dungeon dungeon, Character[][] mobLayout) {
        int tileSize = gettileSize(dungeon);

        for (int y = 0; y < dungeon.getLayout()[0].length; y++) {
            for (int tileYIndex = 0; tileYIndex < tileSize; tileYIndex++) {
                for (int x = 0; x < dungeon.getLayout().length; x++) {
                    if (dungeon.getLayout()[x][y] != null) {
                        for (int tileX = 0; tileX < tileSize; tileX++) {
                            if (mobLayout[(x * tileSize) + tileX][(y* tileSize) + tileYIndex] != null) {
                                printLetterOfMob(mobLayout[(x * tileSize) + tileX][(y* tileSize) + tileYIndex]);
                            } else {
                                printLetterOfTerrain(dungeon.getLayout()[x][y].getLayout()[tileX][tileYIndex].getTerrain());
                            }
                        }
                    } else {
                        printOneEmptyLine(tileSize);
                    }
                }
                System.out.println();
            }
        }
    }


    public static void printDungeon (Dungeon dungeon) {
        int tileSize = gettileSize(dungeon);
        for (int y = 0; y < dungeon.getLayout()[0].length; y++) {
            for (int tileYIndex = 0; tileYIndex < tileSize; tileYIndex++) {
                for (int x = 0; x < dungeon.getLayout().length; x++) {
                    if (dungeon.getLayout()[x][y] != null) {
                        for (int tileX = 0; tileX < tileSize; tileX++) {
                            printLetterOfTerrain(dungeon.getLayout()[x][y].getLayout()[tileX][tileYIndex].getTerrain());
                        }
                    } else {
                        printOneEmptyLine(tileSize);
                    }
                }
                System.out.println();
            }
        }
    }



    private static void printLetterOfMob (Character mob) {
        if (mob == null) {
            System.out.print("   ");
        } else {
            System.out.print(((mob.getName().charAt(0))) + String.valueOf(mob.getName().charAt(1)).toUpperCase() + " ");
        }
    }

    private static void printLetterOfTerrain (Terrain terrain) {
        if (terrain == Terrain.NONE) {
            System.out.print("   ");
        } else {
            System.out.print(((terrain.name().charAt(0))) + String.valueOf(terrain.name().charAt(1))
                    .toLowerCase() + " ");
        }
    }


    private static void printOneLetterForLandscape (Tile tile) {
        if (tile == null) {
            System.out.print("  ");
        } else {
            System.out.print(tile.getLandscape().name().charAt(0) + " ");
        }

    }


    private static void printTwoLettersOfLandscape (Tile tile) {
        if (tile != null) {
            System.out.print((String.valueOf(tile.getLandscape().name().charAt(0))) + String.valueOf(
                    tile.getLandscape().name().charAt(1)).toLowerCase() + " ");
        }
        else {
            System.out.print("   ");
        }
    }

    private static void printOneEmptyLine (int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("   ");
        }
    }

    private static int gettileSize (Dungeon dungeon) {
        int tileSize = 0;

        //searches through the layout to find a tile that is not null to get the length of the tiles.
        for (int i = 0; i < dungeon.getLayout().length; i++) {
            for (int j = 0; j < dungeon.getLayout()[i].length; j++) {
                if (dungeon.getLayout()[i][j] != null) {
                    tileSize = dungeon.getLayout()[i][j].getSize();
                    break;
                }
            }
            if (tileSize != 0) {
                break;
            }
        }
        /*
        for (Tile tiles[] : dungeon.getLayout()) {
            tileSize = Arrays.stream(tiles).filter(field -> field != null).findFirst().get().getSize();
        }
         */
        return tileSize;
    }
}
