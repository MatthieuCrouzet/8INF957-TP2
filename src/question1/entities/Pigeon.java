package question1.entities;

import question1.ui.UserInterface;
import question1.utils.Position;

public class Pigeon extends Entity {
	
    private World world;
    private boolean fleeing;
    private Position fleeingPos;
    
    public Pigeon(Position position, World world) {
        super(position);
        this.world = world;
        this.setFleeing(false);
        chooseFleeingPosition();
    	//System.out.println("New pigeon : Pigeon" + identifier);
    }    

    public void run() {
    	while(true){
    		if(!isFleeing()){
    			chooseFleeingPosition();
	        	Food nearestFood = lookForFood();
	        	if(nearestFood != null){
	        		moveToFood(nearestFood);
	        		if (position.distanceTo(nearestFood.getPosition()) == 0) { 
	                    eat(nearestFood);
	                }
	        	} else {
	        		sleep();
	        	}        	
        	} else {
        		flee(fleeingPos);
        	}
	        try {	        	
	            Thread.sleep(50);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    	}
    }

    private void chooseFleeingPosition() {
        int x = (int) (Math.random() * (UserInterface.size));
        int y = (int) (Math.random() * (UserInterface.size));
        this.fleeingPos = new Position(x,y);
	}

	private void eat(Food f){
    	if(!f.lock.isLocked()){
    		f.lock.lock();
	    	if(f.isEatable()){
	    		System.out.println("Pigeon" + identifier + " eats Food" + f.identifier);
	    		f.setEatable(false);
	    		f.killShape();
	    		world.removeFood(f);
	    	}
	    	f.lock.unlock();
    	} else {
	    	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	eat(f);
    	}
    }
    
    private void moveToFood(Food f) {
    	//System.out.println("Pigeon" + identifier + " moves to Food" + f.identifier);
        position.moveTo(f.getPosition());
        shape.move(position);
    }

    private Food lookForFood() {
    	//System.out.println("Pigeon" + identifier + " looks for food");
        return this.world.nearestFood(this);
    }

    private void sleep(){
    	//System.out.println("Pigeon" + identifier + " sleeps during 2 seconds");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public void flee(Position p) {
    	//System.out.println("Pigeon" + identifier + " flees");
        position.moveTo(p);
        shape.move(position);
    }

	public boolean isFleeing() {
		return fleeing;
	}

	public void setFleeing(boolean fleeing) {
		this.fleeing = fleeing;
	}
}
