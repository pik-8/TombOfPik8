package model.other;

public class Position {

    private int x;
    private int y;

    public Position(int xPosition, int yPosition) {
        this.x = xPosition;
        this.y = yPosition;
    }

    /**
     * Sets the x and y position to 0.
     */
    public Position () {
        this.x = 0;
        this.y = 0;
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
}
