package question1.entities;

import java.awt.Color;
import java.util.concurrent.locks.ReentrantLock;

import question1.utils.Position;

public class Food extends Entity {
	public ReentrantLock lock;
	private int timeBetweenCheck = 50;
    private boolean eatable;
    private long createdAt;
    private int rottenDuration = 10000;

    public Food(Position position) {
        super(position);
        this.eatable = true;
        this.lock = new ReentrantLock();
        this.setCreatedAt(System.currentTimeMillis());
    	//System.out.println("New food : Food" + identifier);
    }

    public boolean isEatable() {
        return this.eatable;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }
    
    public void rot() {
    	System.out.println("Food" + identifier + " is rotten ! ");
        this.shape.setColor(Color.RED);
        this.eatable = false;
    }

    public void killShape() {
        this.shape.deadShape();
    }

    public int getRottenDuration() {
        return rottenDuration;
    }

    public void setRottenDuration(int rottenDuration) {
        this.rottenDuration = rottenDuration;
    }
    
    public void run(){
    	while(true){
    		if(isEatable()){
	           setRottenDuration(this.rottenDuration - timeBetweenCheck);
	           if(this.rottenDuration < 0){
	        	   rot();
	           }
    		}
	    	try {
	           Thread.sleep(timeBetweenCheck);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    	}
    }

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
    
}