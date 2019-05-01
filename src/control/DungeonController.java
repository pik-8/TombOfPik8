package control;

import java.util.HashMap;

import model.characters.Hero;
import model.dungeon.Dungeon;
import model.dungeon.InvalidDungeonException;
import model.dungeon.Position;
import model.dungeon.Terrain;
import model.dungeon.Tile;

public class DungeonController {

	private Dungeon dungeon;
	private HashMap<Hero, Position> heroes;
	private Character[] mobs;
	
	public DungeonController(Hero[] heroes, Dungeon dungeon) {
		this.dungeon = dungeon;
		spawnHeroes(heroes);
	}
	
	private void spawnHeroes(Hero[] heroes) {
		try {
			Position startPosition = findStartingTerrain();
			this.heroes.put(heroes[0], startPosition);
			for(int i = 1; i < heroes.length; i++) {
				
			}
			
		} catch (InvalidDungeonException e) {
			
		}
	}
	
	private Position findStartingTerrain() throws InvalidDungeonException {
		if(dungeon != null) {
			for(Tile[] tileY : dungeon.getlayout()) {
				for(Tile tile : tileY) {
					for(int squareY = 0; squareY < tile.getSize(); squareY++) {
						for(int squareX = 0; squareX < tile.getSize(); squareX++) {
							if(tile.getlayout()[squareX][squareY].getTerrain() == Terrain.START_POINT)
								return new Position(squareX, squareY);
							else
								throw new InvalidDungeonException("Dungeon has no starting point");
						}
					}
				}
			}
		}
		else
			throw new NullPointerException("Dungeon is null");
		return null;
	}
}
