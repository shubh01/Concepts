package javaConcepts;

public class Thread2 implements Runnable{

	public static Integer count;
	public static Integer totalCount;
	private static volatile Boolean flag;
	
	public Thread2(Integer count, Integer totalCount,Boolean flag) {
		Thread2.count = count;
		Thread2.totalCount = totalCount;
		Thread2.flag=flag;
	}

	@Override
	public void run() {
		try
		{
			while(true) 
			{
//				System.out.println("In thread 2 run calling synchronized "+DeadLock.flag);
//				if(DeadLock.flag)
				{
					synchronized (DeadLock.COUNT)
					{
						Thread.sleep(2000);
						synchronized (DeadLock.TOTAL_COUNT) 
						{
							DeadLock.TOTAL_COUNT+=DeadLock.COUNT;				
						}
					}
					System.out.println("In thread 2 run "+DeadLock.TOTAL_COUNT);
					DeadLock.flag=false;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
