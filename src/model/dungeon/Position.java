package model.dungeon;


/**
 * To navigate inside a dungeon.
 * Saves the location of a tile and a square inside this tile.
 *
 * @author Hagen
 */
public class Position {

    private int x;
    private int y;
    private int xTile;
    private int yTile;

    public Position(int xSquare, int ySquare) {
        this.x = xSquare;
        this.y = ySquare;
        this.xTile = 0;
        this.yTile = 0;
    }
    
    public Position(int xSquare, int ySquare, int xTile, int yTile) {
    	this.x = xSquare;
        this.y = ySquare;
        this.xTile = xTile;
        this.yTile = yTile;
    }
    
    public Position(Position position) {
    	this.x = position.getxSquare();
    	this.y = position.getySquare();
    	this.xTile = position.getxTile();
    	this.yTile = position.getyTile();
    }

    /**
     * Sets the x and y positions to 0.
     */
    public Position () {
    	this.x = 0;
    	this.y = 0;
        this.xTile = 0;
        this.yTile = 0;
    }


    public boolean equals(Position position) {
    	return position.x == x &&
                position.y == y &&
                position.xTile == xTile &&
                position.yTile == yTile;
    }
    
    public int getxSquare() {
        return x;
    }

    public void setxSquare(int x) {
        this.x = x;
    }

    public int getySquare() {
        return y;
    }

    public void setySquare(int y) {
        this.y = y;
    }

	public int getxTile() {
		return xTile;
	}

	public void setxTile(int xTile) {
		this.xTile = xTile;
	}

	public int getyTile() {
		return yTile;
	}

	public void setyTile(int yTile) {
		this.yTile = yTile;
	}
	
	public void changeBy(Position vector) {
		this.x += vector.getxSquare();
		this.y += vector.getySquare();
		this.xTile += vector.getxTile();
		this.yTile += vector.getyTile();
	}
	
	public String toString() {
		return "xTile: " + xTile +
				"\nyTile: " + yTile +
				"\nxSquare: " + x +
				"\nySquare: " + y;
	}
}
