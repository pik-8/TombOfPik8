package tests;

import model.dungeon.*;
import model.other.Position;

public class DungeonTests {

    public static void testTileBorders () {
        System.out.println("Tile with no borders:");
        Tile test = TileFactory.getTile7x7(Landscape.FOREST, true, true, true, true);
        printTile(test);
        System.out.println("Tile with borders");
        Tile test2 = TileFactory.getTile7x7(Landscape.FOREST, false, false, false, false);
        printTile(test2);
    }

    public static void testTileBordersUpAndDown () {
        System.out.println("Tile with no bottom borders:");
        Tile test = TileFactory.getTile7x7(Landscape.FOREST, false, false, false, true);
        printTile(test);
        System.out.println("Tile with no upper borders");
        Tile test2 = TileFactory.getTile7x7(Landscape.FOREST, false, false, true, false);
        printTile(test2);
    }

    public static void testGoThrough () {
        boolean foundBossRoom = false;
        int[][] layout = new int[5][5];
        layout[0][0] = 1;
        layout[1][0] = 1;
        layout[2][0] = 1;
        layout[3][0] = 1;
        layout[3][1] = 1;
        layout[4][1] = 2;
        goThroughArray(layout,new Position());
        System.out.println("Ergebnis: \n\t" + foundBoss);
    }

    private static boolean foundBoss = false;


    /**
     * Can go through an array on a path.
     * Just a test.
     *
     * @param array
     * @param currentPosition
     */
    private static void goThroughArray (int[][] array, Position currentPosition) {

        if (array[currentPosition.getXPosition()][currentPosition.getYPosition()] == 2) {
            foundBoss = true;
        }

        //To mark already visited places.
        array[currentPosition.getXPosition()][currentPosition.getYPosition()] = -1;

        //Going one filed up
        if (currentPosition.getYPosition() -1 >= 0 && array[currentPosition.getXPosition()][currentPosition.getYPosition() - 1] > 0) {
            currentPosition.setYPosition(currentPosition.getYPosition() -1);
            goThroughArray(array,currentPosition);
        }

        //Going one filed down
        if (currentPosition.getYPosition() + 1 < array.length && array[currentPosition.getXPosition()][currentPosition.getYPosition() + 1] > 0 ) {
            currentPosition.setYPosition(currentPosition.getYPosition() +1);
            goThroughArray(array,currentPosition);
        }

        //Going one filed left
        if (currentPosition.getXPosition() -1 >= 0 && array[currentPosition.getXPosition() -1][currentPosition.getYPosition()] > 0) {
            currentPosition.setXPosition(currentPosition.getXPosition() -1);
            goThroughArray(array,currentPosition);
        }

        //Going one filed right
        if (currentPosition.getXPosition() +1 < array.length && array[currentPosition.getXPosition() +1][currentPosition.getYPosition()] > 0) {
            currentPosition.setXPosition(currentPosition.getXPosition() + 1);
            goThroughArray(array,currentPosition);
        }
    }


    private static void printTile (Tile tile) {
        for (int y = 0; y < tile.getlayout().length; y++) {
            for (int x = 0; x < tile.getlayout().length; x++) {
                if (tile.getlayout()[x][y].getTerrain() == Terrain.NONE) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" T ");
                }
            }
            System.out.println();
        }
    }
}
