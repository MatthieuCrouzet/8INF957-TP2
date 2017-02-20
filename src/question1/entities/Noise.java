package question1.entities;

public class Noise extends Thread {
	
	private int timeBetweenCheck = 50;
	private int timeBeforeNextNoise;
	private World world;

	public Noise(World world){
		this.world = world;
		this.timeBeforeNextNoise = randomTime();
	}
	
	public void run(){		
		while(true){
			timeBeforeNextNoise -= timeBetweenCheck;
			if(timeBeforeNextNoise < 0){
				makeNoise();
			} 
			try {
				Thread.sleep(timeBetweenCheck);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void makeNoise(){
		System.out.println("SOME NOISE !!!");
		for(Pigeon p : world.getPigeonList()){
			p.setFleeing(true);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(Pigeon p : world.getPigeonList()){
			p.setFleeing(false);
		}
		timeBeforeNextNoise = randomTime();
	}
	
	public int getTimeBeforeNextNoise() {
		return timeBeforeNextNoise;
	}

	public void setTimeBeforeNextNoise(int timeBeforeNextNoise) {
		this.timeBeforeNextNoise = timeBeforeNextNoise;
	}

	private int randomTime(){
		int maxTime = 30;
		return randomTime(maxTime);
	}
	
	private int randomTime(int maxTime){
		return (int) (Math.random()*1000*maxTime);
	}
	
}
