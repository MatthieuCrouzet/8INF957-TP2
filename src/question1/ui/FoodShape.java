package question1.ui;

import java.awt.*;

public class FoodShape extends Shape {

    public FoodShape(Point position) {
        super(position, new Rectangle(position.x, position.y, 5, 5), Color.GREEN);
    }

}