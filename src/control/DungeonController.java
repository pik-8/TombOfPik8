package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.characters.Hero;
import model.dungeon.Dungeon;
import model.dungeon.DungeonException;
import model.dungeon.Position;
import model.dungeon.Terrain;
import model.dungeon.Tile;

public class DungeonController {

	private Dungeon dungeon;
	private HashMap<Hero, Position> heroes;
	private HashMap<Character, Position> mobs;
	
	public DungeonController(Hero[] heroes, Dungeon dungeon) {
		this.dungeon = dungeon;
		this.heroes = new HashMap<Hero, Position>();
		this.mobs = new HashMap<Character, Position>();
		spawnHeroes(heroes);
		trackMobs();
	}
	
	private void trackMobs() {
		//TODO
	}
	
	private void spawnHeroes(Hero[] heroes) {
		try {
			Position startPosition = findStartingTerrain();
			Tile spawnTile = dungeon.getLayout()[startPosition.getxTile()][startPosition.getyTile()];
			this.heroes.put(heroes[0], startPosition);
			for(int i = 1; i < heroes.length; i++) {
				heroIteration:
				for(int y = -1; y <= 1; y++) {
					for(int x = -1; x <= 1; x++) {
						if(spawnTile.getLayout()[startPosition.getXPosition() + x][startPosition.getYPosition() + y].getTerrain().isValidSpawnTerrain()) {
							Position pos = new Position(startPosition.getXPosition() + x, 
									startPosition.getYPosition() + y, 
									startPosition.getxTile(), 
									startPosition.getyTile());
							if(isFree(pos)) {

								this.heroes.put(heroes[i], pos);
								System.out.println("tileX:"+pos.getxTile() + "\ntileY:"+ pos.getyTile() + "\nx:" + pos.getXPosition()+"\ny:"+ pos.getYPosition() + "\nHero: " + heroes[i].getName());
								break heroIteration;
							}
						}
					}
				}
			}
			
		} catch (DungeonException e) {
			
		}
	}
	
	private Position findFirstFreeSquare() {
		for(int yT = 0; yT < dungeon.getLayout()[0].length; yT++) {
			for(int xT = 0; xT < dungeon.getLayout().length; xT++) {
				Tile tile = dungeon.getLayout()[xT][yT];
				for(int yS = 0; yS < tile.getLayout()[0].length; yS++) {
					for(int xS = 0; xS < tile.getLayout().length; xS++) {
						Position pos = new Position(xS, yS, xT, yT);
						if(isFree(pos))
							return pos;
					}
				}
			}
		}
		return null;
	}
	
	private boolean isFree(Position pos) {
		for(Map.Entry<Hero, Position> set : this.heroes.entrySet()) {
			if(set.getValue().equals(pos))
				return false;
		}
		for(Map.Entry<Character, Position> set : this.mobs.entrySet()) {
			if(set.getValue().equals(pos))
				return false;
		}
		return true;
	}
	
	private Position findStartingTerrain() throws DungeonException {
		if(dungeon != null) {
			for(int tileX = 0; tileX < dungeon.getLayout().length; tileX++) {
				for(int tileY = 0; tileY < dungeon.getLayout()[0].length; tileY++) {
					Tile tile = dungeon.getLayout()[tileX][tileY];
					if(tile != null) {
						for(int squareX = 0; squareX < tile.getSize(); squareX++) {
							for(int squareY = 0; squareY < tile.getSize(); squareY++) {
								if(tile.getLayout()[squareX][squareY].getTerrain() == Terrain.START_POINT)
									return new Position(squareX, squareY, tileX, tileY);
							}
						}						
					}
				}
			}
			throw new DungeonException("Dungeon has no starting point");
		}
		else
			throw new NullPointerException("Dungeon is null");
	}
}
