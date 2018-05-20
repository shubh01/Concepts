package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private final BlockingQueue<String> blockingQueue;
	
	public Producer(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
			while(true) {
				blockingQueue.offer("Hi this the message");
			}
	}
	
}
