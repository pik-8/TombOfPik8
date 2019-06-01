package view;

import constants.ImagePaths;
import constants.ModelProperties;
import constants.view.DefaultTextureSize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.characters.Character;
import model.dungeon.Dungeon;
import model.dungeon.Landscape;
import model.dungeon.Terrain;
import model.dungeon.Tile;

import java.io.File;
import java.util.Random;


/**
 * A class that prints a map of dungeons.
 * Either the whole map with the Terrain-Objects or every landscape and with mobs, if one wants to.
 *
 * @author Hagen
 */
public class DungeonPrinter {

    /**
     * Returns a Pane-Layout, that contains every Tile in  the dungeon.
     *
     * @param dungeon
     * @param width
     * @param height
     * @return
     */
    public static Pane printDungeonImage (Dungeon dungeon, double width, double height) {
        Pane dungeonLayout = new Pane();
        Random random = new Random();
        for (int y = 0; y < dungeon.getLayout()[0].length; y++) {
            for (int x = 0; x < dungeon.getLayout().length; x++) {
                if (dungeon.getTile(x, y) != null) {
                    File folder = new File(getPathToImage(dungeon.getTile(x, y).getLandscape()));
                    ImageView tileImage = new ImageView(new Image(ModelProperties.FILE_KEY + folder.listFiles()[random.nextInt(folder.listFiles().length)]));

                    tileImage.setFitWidth(tileImage.getImage().getWidth() / (DefaultTextureSize.width / width));
                    tileImage.setFitHeight(tileImage.getImage().getHeight() / (DefaultTextureSize.height / height));

                    tileImage.setTranslateX(x * tileImage.getFitWidth());
                    tileImage.setTranslateY(y * tileImage.getFitHeight());

                    dungeonLayout.getChildren().add(tileImage);
                }
            }
        }

        return dungeonLayout;
    }



    /**
     * Returns a Pane-Layout, that contains every Tile and Terrain in  the dungeon.
     *
     * Uses a single Forest tile to determine the spacing of the Terrain Objects.
     *
     * @param dungeon
     * @param width
     * @param height
     * @return
     */
    public static Pane printFullDungeonImage (Dungeon dungeon, double width, double height) {
        Pane dungeonLayout = printDungeonImage(dungeon, width, height);

        File exampleTiles = new File(ImagePaths.PATH_TO_FOREST_TILES);
        Image exampleImage = new Image(ModelProperties.FILE_KEY +  exampleTiles.listFiles()[0].getPath());

        double tileWidth = exampleImage.getWidth() / (DefaultTextureSize.width / width);
        double tileHeight = exampleImage.getHeight() / (DefaultTextureSize.height / height);

        int tileSize = getTileSize(dungeon);

        for (int tileY = 0; tileY < dungeon.getLayout()[0].length; tileY++) {
            for (int squareY = 0; squareY < dungeon.getTileSize(); squareY++) {
                for (int tileX = 0; tileX < dungeon.getLayout().length; tileX++) {
                    for (int squareX = 0; squareX < dungeon.getTileSize(); squareX++) {
                        if (dungeon.getTile(tileX, tileY) != null) {
                            String imagePath = getPathToImage(dungeon.getTile(tileX, tileY).getLayout()[squareX][squareY].getTerrain(), tileSize);
                            if (imagePath != null) {
                                ImageView terrain = new ImageView(new Image(ModelProperties.FILE_KEY + imagePath));
                                double terrainXPosition = (tileX * tileWidth) + (squareX * (tileWidth / tileSize));
                                double terrainYPosition = (tileY * tileHeight) + (squareY * ( tileHeight / tileSize));

                                terrain.setFitWidth(terrain.getImage().getWidth() / (DefaultTextureSize.width / width));
                                terrain.setFitHeight(terrain.getImage().getHeight() / (DefaultTextureSize.height / height));

                                terrain.setTranslateX(terrainXPosition);
                                terrain.setTranslateY(terrainYPosition);

                                dungeonLayout.getChildren().add(terrain);
                            }
                        }
                    }
                }
            }
        }
        return dungeonLayout;
    }


    /**
     * Returns the location of ForestTiles as default.
     */
    private static String getPathToImage(Landscape landscape) {
        switch (landscape){
            case DESERT:
                return ImagePaths.PATH_TO_DESERT_TILES;
            case SPACE:
                return ImagePaths.PATH_TO_SPACE_TILES;
            default:
                return ImagePaths.PATH_TO_FOREST_TILES;
        }
    }


    private static String getPathToImage (Terrain terrain, int tileSize) {
        switch (terrain){
            case BOULDER:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_BOULDER;
            case BEDROCK:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_BEDROCK;
            case BUSH:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_BUSH;
            case START_POINT:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_START_POINT;
            case TREE:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_TREE;
            case COMET:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_COMET;
            case WHITE_HOLE:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_WHITE_HOLE;
            case CACTUS:
                return ImagePaths.PATH_TO_TERRAINS + "/" + tileSize + ImagePaths.PATH_TO_TERRAIN_CACTUR;
            default:
                return null;
        }
    }


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


    /**
     * Prints every visible tile with all terrains and mobs.
     *
     * @param dungeon: The dungeon that should be printed.
     * @param characters: Every mob in the dungeon.
     * @param visibleTiles: Determines which tile is visible.
     */
    public static void printDungeon (Dungeon dungeon, Character[][] characters, boolean[][] visibleTiles) {
        int tileSize = getTileSize(dungeon);

        for (int mapY = 0; mapY < dungeon.getLayout()[0].length; mapY++){
            for (int tileY = 0; tileY < tileSize; tileY++) {
                for (int mapX = 0; mapX < dungeon.getLayout().length; mapX++) {
                    for (int tileX = 0; tileX < tileSize; tileX++) {
                        if (visibleTiles[mapX][mapY]){
                            if (characters[(mapX * tileSize) + tileX][(mapY * tileSize) + tileY] == null) {
                                printLetterOfTerrain(dungeon.getLayout()[mapX][mapY].getLayout()[tileX][tileY].getTerrain());
                            } else {
                                printLetterOfCharacter(characters[(mapX * tileSize) + tileX][(mapY * tileSize) + tileY]);
                            }
                        } else {
                            printOneEmptyLine(tileSize);
                        }
                    }
                }
                System.out.println();
            }
        }
    }


    /**
     * Prints the first two letters of every character in the given array.
     */
    public static void printCharacterLayout(Character[][] mobLayout) {
        for (int y = 0; y < mobLayout[0].length; y++) {
            for (int x = 0; x < mobLayout.length; x++) {
                printLetterOfCharacter(mobLayout[x][y]);
            }
            System.out.println();
        }
    }


    /**
     * Prints the whole dungeon with every terrain and character.
     */
    public static void printDungeon (Dungeon dungeon, Character[][] mobLayout) {
        int tileSize = getTileSize(dungeon);

        for (int y = 0; y < dungeon.getLayout()[0].length; y++) {
            for (int tileYIndex = 0; tileYIndex < tileSize; tileYIndex++) {
                for (int x = 0; x < dungeon.getLayout().length; x++) {
                    if (dungeon.getLayout()[x][y] != null) {
                        for (int tileX = 0; tileX < tileSize; tileX++) {
                            if (mobLayout[(x * tileSize) + tileX][(y* tileSize) + tileYIndex] != null) {
                                printLetterOfCharacter(mobLayout[(x * tileSize) + tileX][(y* tileSize) + tileYIndex]);
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


    /**
     * Prints every terrain in the dungeon.
     */
    public static void printDungeon (Dungeon dungeon) {
        int tileSize = getTileSize(dungeon);
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



    private static void printLetterOfCharacter (Character character) {
        if (character == null) {
            System.out.print("   ");
        } else {
            System.out.print(String.valueOf(character.getName().charAt(0)).toUpperCase() + String.valueOf(character.getName().charAt(1)).toUpperCase() + " ");
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

    private static int getTileSize(Dungeon dungeon) {
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
