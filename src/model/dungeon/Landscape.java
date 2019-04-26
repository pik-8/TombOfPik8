package model.dungeon;


/**
 * An Enum that contains every possible Landscape.
 * The landscape determines whar kind of terrains may be placed onto a square.
 *
 * @author Hagen
 */
public enum  Landscape {

    FOREST(new Terrain[]{Terrain.NONE, Terrain.TREE},new Terrain[]{Terrain.BEDROCK});


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
