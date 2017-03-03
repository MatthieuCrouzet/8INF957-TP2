package question1.ui;


import javax.swing.*;

import question1.entities.Food;
import question1.entities.Pigeon;
import question1.entities.World;
import question1.utils.Position;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserInterface extends JFrame implements MouseListener, Runnable{

	public static int size = 400;
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2589162299251869835L;
	
	private Panel panel;

    public UserInterface() {
        super();
        setSize(new Dimension(size, size));
        addMouseListener(this);
    }

    public void init(World w) {
        this.setTitle("8INF956 - TP2 - Question 1");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new Panel(this, w);
        this.setContentPane(this.panel);
    }

    public void run() {
        this.panel.repaint();
    }

    public void reDraw() {
        this.panel.repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Point mousePosition = this.getMousePosition();
        switch(e.getButton()){
	        case MouseEvent.BUTTON1 :
	        	Food f = new Food(new Position(mousePosition));
	        	Thread tf = new Thread(f);
	            panel.getWorld().addFood(f);
	            FoodShape foodShape = new FoodShape(new Point(f.getPosition().getX(), f.getPosition().getY()));
	            f.setShape(foodShape);
	            panel.addShape(foodShape);
	        	tf.start();
	            break;
	        case MouseEvent.BUTTON3 : 
	        	Pigeon p = new Pigeon(new Position(mousePosition), panel.getWorld());
	        	Thread tp = new Thread(p);
	            panel.getWorld().addPigeon(p);
	            PigeonShape pigeonShape = new PigeonShape(new Point(p.getPosition().getX(), p.getPosition().getY()));
	            p.setShape(pigeonShape);
	            panel.addShape(pigeonShape);
	        	tp.start();
	            break;
        }
        

        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}