package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class ServiceOne implements Runnable{

	private final CountDownLatch countDownLatch;
	private final Integer delay;
	
	public ServiceOne(CountDownLatch countDownLatch, Integer delay) {
		this.countDownLatch = countDownLatch;
		this.delay = delay;
	}

	public void run() {
		System.out.println("Going to start service 1");
		try {
			Thread.sleep(delay);
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
