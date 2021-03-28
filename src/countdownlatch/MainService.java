package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MainService {
	
	private final static CountDownLatch countDownLatch=new CountDownLatch(2);

	public static void main(String[] args) throws Exception{
		System.out.println("Getting all service up");
		Thread t1=new Thread(new ServiceOne(countDownLatch, 1000));
		Thread t2=new Thread(new ServicceTwo(countDownLatch, 2000));
		t1.start();
		t2.start();
		countDownLatch.await();
		System.out.println("All services are up now");
	}
	
}
