package dishWashS;
import java.util.concurrent.Semaphore;

public class WetDishRack {
	int rackSize;
	int in = 0;
	int out = 0;
	Semaphore mutex;
	Semaphore full;
	Semaphore empty;
	int rack[];

	WetDishRack(int rackSize) {
	    this.rackSize = rackSize;
	    mutex = new Semaphore(1);
	    full = new Semaphore(0);
	    empty = new Semaphore(rackSize);
	    rack = new int[rackSize];
	}
	
	public void addDish(int dish_id)  throws InterruptedException { //producer
		empty.acquire();
		mutex.acquire();

		rack[in] = dish_id;
		in = (in+1)%rackSize;

		mutex.release();
		full.release();
	}
	
	public int removeDish() throws InterruptedException { //consumer
		full.acquire();
		mutex.acquire();

		int dishId = rack[out];
		out = (out+1)%rackSize;

		mutex.release();
		empty.release();

		return dishId; 
	}
	
}



