package question1.ui;

import javax.swing.*;

import question1.entities.World;

import java.awt.*;
import java.util.*;

public class Panel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4934470466951970522L;
	
	private ArrayList<Shape> shapes;
    private World world;

    public Panel(UserInterface ui, World w) {
        super();
        this.shapes = new ArrayList<>();
        this.world = w;
        this.setSize(ui.getWidth(), ui.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        ArrayList<Shape> deadShapes = new ArrayList<>();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (Shape s : this.shapes) {
            if (s.isDrawable()) {
                g.setColor(s.getColor());
                Rectangle drawing = s.getDrawing();
                g.fillRect(drawing.x, drawing.y, drawing.width, drawing.height);
            } else {
                deadShapes.add(s);
            }
        }
        for (Shape s : deadShapes) {
            this.shapes.remove(s);
        }
    }
    
    public void addShape(Shape e) {
        shapes.add(e);
    }

    public void removeShape(Shape s) {
        shapes.remove(s);
    }

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

   
}