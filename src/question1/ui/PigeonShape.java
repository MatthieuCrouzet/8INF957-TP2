package question1.ui;

import java.awt.*;

public class PigeonShape extends Shape {

    public PigeonShape(Point position) {
        super(position, new Rectangle(position.x, position.y, 10,10), Color.BLACK);
    }

}