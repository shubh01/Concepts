package cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class MainService {

	final static CyclicBarrier barrier=new CyclicBarrier(4);

	public static void main(String[] args) throws Exception{
			System.out.println("Going to start service");
			Thread t1=new Thread(new ServiceOne(barrier, 1000));
			Thread t2=new Thread(new ServiceTwo(barrier, 2000));
			Thread t3=new Thread(new ServiceThree(barrier, 3000));
			t1.start();
			t2.start();
			t3.start();
			barrier.await();
			System.out.println("All services are up");
	}
	
}
