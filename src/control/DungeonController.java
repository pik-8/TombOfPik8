package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.characters.Hero;
import model.characters.HeroClass;
import model.dungeon.Dungeon;
import model.dungeon.DungeonException;
import model.dungeon.Position;
import model.dungeon.Terrain;
import model.dungeon.Tile;
import view.DungeonPrinter;

public class DungeonController {

	private enum Border{
		NORTH(0,-1),
		NORTHEAST(1,-1),
		EAST(1,0),
		SOUTHEAST(1,1),
		SOUTH(0,1),
		SOUTHWEST(-1,1),
		WEST(-1,0),
		NORTHWEST(-1,-1),
		NONE(0,0);
		
		int xDelta;
		int yDelta;
		
		Border(int xD, int yD){
			xDelta = xD; 
			yDelta = yD;
		}
	}
	
	private Dungeon dungeon;
	private HashMap<Hero, Position> heroes;
	private HashMap<model.characters.Character, Position> mobs;
	private boolean[][] visibleTiles;
	
	private void init(Dungeon dungeon) {
		this.dungeon = dungeon;
		this.heroes = new HashMap<Hero, Position>();
		this.mobs = new HashMap<model.characters.Character, Position>();
		this.visibleTiles = new boolean[dungeon.getLayout().length][dungeon.getLayout()[0].length];
	}
	
	public DungeonController(Hero[] heroes, Dungeon dungeon, model.characters.Character[][] mobs) {
		init(dungeon);
		
		spawnHeroes(heroes);
		spawnMobs(mobs);
		updateVisibleTiles();
		printVisibleTiles();
	}
	
	public void printVisibleTiles() {
		DungeonPrinter.printDungeon(dungeon, generateCharacterLayout(), visibleTiles);
	}
	
	private void spawnMobs(model.characters.Character[][] mobs) {
		int tileX = 0;
		int tileY = 0;
		int squareX = 0;
		int squareY = 0;
		
		for(int x = 0; x < mobs.length; x++) {
			for(int y = 0; y < mobs[0].length; y++) {
				if(mobs[x][y] != null) {
					
				}
			}
		}
	}
	
	public void updateVisibleTiles() {
		for(Tile[] tArr : dungeon.getLayout()) {
			for(Tile tile : tArr) {
				if(tile != null && containsHeroes(tile)) {
					setVisible(tile);
					for(Hero h : containedHeroes(tile)) {
						Border border = heroAtBorder(tile, h);
						System.out.println(border);
						setVisible(dungeon.getTile(new Position(0,0, getTilePos(tile).getxSquare() + border.xDelta, getTilePos(tile).getySquare())));
						setVisible(dungeon.getTile(new Position(0,0, getTilePos(tile).getxSquare(), getTilePos(tile).getySquare() + border.yDelta)));
					}
				}
			}
		}
	}
	
	private Border heroAtBorder(Tile tile, Hero h) {
		for(int yT = 0; yT < tile.getLayout()[0].length; yT++) {
			for(int xT = 0; xT < tile.getLayout().length; xT++) {
				Position pos = new Position(getTilePos(tile));
				pos.setxSquare(xT);
				pos.setySquare(yT);
				if(getHero(pos) == h) {
					if(yT == 0) {
						if(xT == 0)
							return Border.NORTHWEST;
						else if(xT == dungeon.getTileSize() - 1)
							return Border.NORTHEAST;
						else
							return Border.NORTH;
					}
					else if(yT == dungeon.getTileSize() - 1) {
						if(xT == 0)
							return Border.SOUTHWEST;
						else if(xT == dungeon.getTileSize() - 1)
							return Border.SOUTHEAST;
						else
							return Border.SOUTH;
					}
					else
						if(xT == 0)
							return Border.WEST;
						else if(xT == dungeon.getTileSize() - 1)
							return Border.EAST;
						else
							return Border.NONE;
				}
			}
		}
		return Border.NONE;
	}
	
	private void setVisible(Tile tile) {
		if(tile != null) {
			Position pos = getTilePos(tile);
			visibleTiles[pos.getxTile()][pos.getyTile()] = true;			
		}
	}
	
	private boolean containsHeroes(Tile tile) {
		Position pos = getTilePos(tile);
		for(int xS = 0; xS < tile.getSize(); xS++) {
			for(int yS = 0; yS < tile.getSize(); yS++) {
				pos.setxSquare(xS);
				pos.setySquare(yS);
				if(getHero(pos) != null)
					return true;
			}
		}
		return false;
	}
	
	private ArrayList<Hero> containedHeroes(Tile tile) {
		ArrayList<Hero> hL = new ArrayList<Hero>();
		Position pos = getTilePos(tile);
		for(int xS = 0; xS < tile.getSize(); xS++) {
			for(int yS = 0; yS < tile.getSize(); yS++) {
				pos.setxSquare(xS);
				pos.setySquare(yS);
				if(getHero(pos) != null)
					hL.add(getHero(pos));
			}
		}
		return hL;
	}
	
	private Position getTilePos(Tile tile) {
		for(int yT = 0; yT < dungeon.getLayout()[0].length; yT++)
			for(int xT = 0; xT < dungeon.getLayout().length; xT++) 
				if(dungeon.getTile(xT, yT) != null && dungeon.getTile(xT,yT).equals(tile))
					return new Position(0, 0, xT, yT);
		
		return new Position();
	}
	
	public model.characters.Character[][] generateCharacterLayout(){
		model.characters.Character[][] layout = new model.characters.Character[dungeon.getLayout().length*dungeon.getTileSize()][dungeon.getLayout()[0].length*dungeon.getTileSize()];
		for(Map.Entry<Hero, Position> set : this.heroes.entrySet()) {
			Position pos = set.getValue();
			layout[pos.getxTile()*dungeon.getTileSize() + pos.getxSquare()][pos.getyTile()*dungeon.getTileSize() + pos.getySquare()] = set.getKey();
		}
		for(Map.Entry<model.characters.Character, Position> set : this.mobs.entrySet()) {
			Position pos = set.getValue();
			layout[pos.getxTile()*dungeon.getTileSize() + pos.getxSquare()][pos.getyTile()*dungeon.getTileSize() + pos.getySquare()] = set.getKey();
		}
		return layout;
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
						if(spawnTile.getLayout()[startPosition.getxSquare() + x][startPosition.getySquare() + y].getTerrain().isValidSpawnTerrain()) {
							Position pos = new Position(startPosition.getxSquare() + x, 
									startPosition.getySquare() + y, 
									startPosition.getxTile(), 
									startPosition.getyTile());
							if(isFree(pos)) {
								this.heroes.put(heroes[i], pos);
								break heroIteration;
							}
						}
					}
				}
			}
			
		} catch (DungeonException e) {
			for(Hero h : heroes) {
				try {
					this.heroes.put(h, findFirstFreeSquare());
				} catch(DungeonException de) {
					de.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
	}
	
	private Position findFirstFreeSquare() throws DungeonException {
		for(int yT = 0; yT < dungeon.getLayout()[0].length; yT++) {
			for(int xT = 0; xT < dungeon.getLayout().length; xT++) {
				Tile tile = dungeon.getLayout()[xT][yT];
				for(int yS = 0; yS < tile.getLayout()[0].length; yS++) {
					for(int xS = 0; xS < tile.getLayout().length; xS++) {
						Position pos = new Position(xS, yS, xT, yT);
						if(isFree(pos) && tile.get(pos).getTerrain().isValidSpawnTerrain())
							return pos;
					}
				}
			}
		}
		throw new DungeonException("No free square found in dungeon.");
	}
	
	private boolean isFree(Position pos) {
		for(Map.Entry<Hero, Position> set : this.heroes.entrySet()) {
			if(set.getValue().equals(pos))
				return false;
		}
		for(Map.Entry<model.characters.Character, Position> set : this.mobs.entrySet()) {
			if(set.getValue().equals(pos))
				return false;
		}
		return true;
	}
	
	private Hero getHero(Position pos) {
		for(Map.Entry<Hero, Position> set : this.heroes.entrySet()) {
			if(set.getValue().equals(pos))
				return set.getKey();
		}
		return null;
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
