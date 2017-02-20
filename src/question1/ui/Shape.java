package question1.ui;

import java.awt.*;

import question1.utils.Position;


public abstract class Shape {

    private Point position;
    private Rectangle drawing;
    private Color color;
    private boolean isDrawable;

    public Shape(Point position, Rectangle d, Color c) {
        super();
        this.setPosition(position);
        this.drawing = d;
        this.color = c;
        this.isDrawable = true;
    }

    public void move(Point newPosition) {
        setPosition(newPosition);
        drawing.setLocation(newPosition.x, newPosition.y);
    }
    
    public void move(Position newPosition) {
        position.x = newPosition.getX();
        position.y = newPosition.getY();
        drawing.setLocation(position.x, position.y);
    }

    public Rectangle getDrawing() {
        return this.drawing;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void deadShape() {
        this.isDrawable = false;
    }

    public boolean isDrawable() {
        return this.isDrawable;
    }

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}