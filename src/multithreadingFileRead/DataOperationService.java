package multithreadingFileRead;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class DataOperationService implements Runnable{

	private final BlockingQueue<String> blockingQueue;
	private final CountDownLatch countDownLatch;

	public DataOperationService(BlockingQueue<String> blockingQueue, CountDownLatch countDownLatch) {
		this.blockingQueue = blockingQueue;
		this.countDownLatch = countDownLatch;
	}
	
	public void run() {
		while(countDownLatch.getCount()>0 || !blockingQueue.isEmpty()) {
			String data=blockingQueue.poll();
			System.out.println(data);
		}
	}

}
