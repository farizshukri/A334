import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    private int x, y, xDirection, yDirection;
    private final int diameter = 15;

    public Ball(int x, int y, int xDirection, int yDirection) {
        this.x = x;
        this.y = y;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public void move() {
        x += xDirection;
        y += yDirection;

        if (x <= 0 || x >= 800 - diameter) {
            xDirection = -xDirection;
        }

        if (y <= 0) {
            yDirection = -yDirection;
        }
    }

    public void reverseYDirection() {
        yDirection = -yDirection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    
}
