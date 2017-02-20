package question1.entities;

import java.util.*;

import question1.ui.UserInterface;
import question1.utils.Position;

public class World {

    private List<Pigeon> PigeonList;
    private List<Food> foodList;
    private UserInterface ui;

    public World(UserInterface ui) {
        this.PigeonList = new ArrayList<>();
        this.foodList = new ArrayList<>();
        this.ui = ui;
        ui.init(this);
        ui.run();
        Noise noise = new Noise(this);
        noise.start();
        run();
    }


    public void run() {
    	while(true){
            ui.reDraw();
	        try {              
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    	}
    }

    public Food nearestFood(Pigeon p) {
        Food nearest = null;
        int minDist = Integer.MAX_VALUE;
        Position pos = p.getPosition();
        for (Food f : foodList) {
            if (f.isEatable()) {
                int distance = pos.distanceTo(f.getPosition());
                if (distance < minDist) {
                    nearest = f;
                    minDist = distance;
                }
            }
        }
        return nearest;
    }
    
    public Food freshestFood() {
        Food freshest = null;
        long max = Long.MIN_VALUE;
        for (Food f : foodList) {
            if (f.isEatable()) {
                long time = f.getCreatedAt();
                if (time > max) {
                    freshest = f;
                    max = time;
                }
            }
        }
        return freshest;
    }


    public void addPigeon(Pigeon p) {
        this.PigeonList.add(p);
    }

    public void removePigeon(Pigeon p) {
        this.PigeonList.remove(p);
    }

    public void addFood(Food f) {
        this.foodList.add(f);
    }
    
    public void removeFood(Food f) {
        foodList.remove(f);
    }

    public List<Pigeon> getPigeonList() {
        return PigeonList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}