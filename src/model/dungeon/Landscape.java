package model.dungeon;


/**
 * An Enum that contains every possible Landscape.
 * The landscape determines what kind of terrains may be placed onto a square.
 *
 * @author Hagen
 */
public enum  Landscape {

    FOREST(new Terrain[]{Terrain.TREE, Terrain.BOULDER, Terrain.BUSH},new Terrain[]{Terrain.BEDROCK}),
    DESERT(new Terrain[]{Terrain.BOULDER},new Terrain[]{Terrain.BEDROCK}),
    SPACE(new Terrain[]{Terrain.COMET},new Terrain[]{Terrain.WHITE_HOLE}),
    ;


    private final Terrain[] possibleTerrains;
    private final Terrain[] borders;

    Landscape(Terrain[] possibleTerrains, Terrain[] borders) {
        this.possibleTerrains = possibleTerrains;
        this.borders = borders;
    }


    public Terrain[] getPossibleTerrains() {
        return possibleTerrains;
    }

    public Terrain[] getBorders() {
        return borders;
    }
}
