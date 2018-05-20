package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueImpl {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(10);
		Producer producer=new Producer(blockingQueue);
		Consumer consumer=new Consumer(blockingQueue);
		
		Thread t1=new Thread(producer);
		Thread t2=new Thread(consumer);
		t1.start();
		t2.start();
		
	}
	
}
