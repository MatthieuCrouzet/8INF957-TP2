package question1.entities;

import question1.ui.Shape;
import question1.utils.Position;

public abstract class Entity implements Runnable{
	
    protected static long id = 0;
    protected long identifier;
    protected Position position;
    protected Shape shape;

    public Entity(Position position) {
        this.position = position;
        this.identifier = id;
        this.shape = null;
        id += 1;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public long getIdentifier() {
        return this.identifier;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

	@Override
	public abstract void run();
		
}
