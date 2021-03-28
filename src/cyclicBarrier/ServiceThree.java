package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ServiceThree implements Runnable{

	private final CyclicBarrier barrier;
	private final Integer delay;

	public ServiceThree(CyclicBarrier barrier, Integer delay) {
		this.barrier = barrier;
		this.delay = delay;
	}
	
	public void run() {
		System.out.println("Going to start service 3");
		try {
			Thread.sleep(delay);
			System.out.println("Service 3 is getting up waiting for others");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}
