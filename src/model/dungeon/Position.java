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

    /**
     * Sets the x and y position to 0.
     */
    public Position () {
        this.x = 0;
        this.y = 0;
    }

    public boolean equals(Position pos) {
    	return pos.x == x &&
    			pos.y == y &&
    			pos.xTile == xTile &&
    			pos.yTile == yTile;
    }
    
    public int getXPosition() {
        return x;
    }

    public void setXPosition(int x) {
        this.x = x;
    }

    public int getYPosition() {
        return y;
    }

    public void setYPosition(int y) {
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
}
