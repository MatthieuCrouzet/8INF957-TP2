package question1.utils;
import java.awt.*;

public class Position {
    protected int x;
    protected int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Point point) {
        this(point.x, point.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int distanceTo(Position c) {
        int distance = 0;

        distance += Math.abs(c.getX() - this.getX());
        distance += Math.abs(c.getY() - this.getY());

        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Position) {
            Position c = (Position) o;
            return this.x == c.getX() && this.y == c.getY();
        }
        return false;
    }

    public void moveTo(Position position) {
        if (Math.abs(this.x - position.getX()) > Math.abs(this.y - position.getY())) {
        	if(this.x > position.getX()){
        		setX(x-1);
        	} else {
        		setX(x+1);
        	}
        } else {
        	if(this.y > position.getY()){
        		setY(y-1);
        	} else {
        		setY(y+1);
        	}
        }
    }
}