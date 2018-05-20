package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private final BlockingQueue<String> blockingQueue;
	
	public Consumer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		while(true) {
			System.out.println("Polling msg:: "+blockingQueue.poll());
		}
	}
	
}
