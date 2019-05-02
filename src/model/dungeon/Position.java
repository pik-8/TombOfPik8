package model.dungeon;

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
    
    public Position(Position pos) {
    	this.x = pos.getxSquare();
    	this.y = pos.getySquare();
    	this.xTile = pos.getxTile();
    	this.yTile = pos.getyTile();
    }

    /**
     * Sets the x and y position to 0.
     */
    public Position () {
    	this.x = 0;
    	this.y = 0;
        this.xTile = 0;
        this.yTile = 0;
    }

    public boolean equals(Position pos) {
    	return pos.x == x &&
    			pos.y == y &&
    			pos.xTile == xTile &&
    			pos.yTile == yTile;
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
