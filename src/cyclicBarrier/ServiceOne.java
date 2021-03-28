package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ServiceOne implements Runnable {

	private final CyclicBarrier barrier;
	private final Integer delay;
	
	public ServiceOne(CyclicBarrier barrier, Integer delay) {
		this.barrier = barrier;
		this.delay = delay;
	}
	
	public void run() {
		System.out.println("Going to start service 1");
		try {
			Thread.sleep(delay);
			System.out.println("Service 1 is getting up waiting for others");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}	
	
}
