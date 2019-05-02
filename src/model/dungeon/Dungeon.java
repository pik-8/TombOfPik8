package model.dungeon;

import model.characters.Character;

import java.util.Objects;

/**
 * A Dungeon contains the layout of itself and the objective, that has to be
 * fulfilled to leaf the dungeon.
 *
 * @author Hagen
 */
public class Dungeon {

	private Tile[][] layout;
	private int tileSize;
	private Objective objective;

	protected Dungeon(Tile[][] layout, Objective objective) throws NullPointerException {
		this(layout);
		this.objective = objective;

	}

	public Dungeon(Tile[][] layout) {
        this.layout = layout;
        for(Tile[] tArr : layout)
        	for(Tile tile : tArr) 
        		if(tile != null)
        			this.tileSize = tile.getSize();
        	
    }

	public Tile[][] getLayout() {
		return layout;
	}

	public Objective getObjective() {
		return objective;
	}

	public Tile getTile(Position pos) {
		if (pos.getxTile() >= 0 && pos.getyTile() >= 0 && pos.getxTile() < this.layout.length
				&& pos.getyTile() < this.layout[0].length)
			return this.getLayout()[pos.getxTile()][pos.getyTile()];
		return null;
	}

	public Tile getTile(int x, int y) {
		Position pos = new Position(0, 0, x, y);
		return getTile(pos);
	}

	public Square getSquare(Position pos) {
		if (pos.getxSquare() >= 0 && pos.getySquare() >= 0 && pos.getxSquare() < this.tileSize
				&& pos.getySquare() < this.tileSize)
			return this.getLayout()[pos.getxTile()][pos.getyTile()].getLayout()[pos.getxSquare()][pos.getySquare()];
		return null;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}
}
