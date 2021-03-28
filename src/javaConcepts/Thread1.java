package javaConcepts;

public class Thread1 implements Runnable{

	public static Integer count;
	public static Integer totalCount;
	public static volatile boolean flag;
	
	public Thread1(Integer count, Integer totalCount,Boolean flag) {
		Thread1.count = count;
		Thread1.totalCount = totalCount;
		Thread1.flag=flag;
	}

	@Override
	public void run() {
		try {
			while(true)
			{
//				System.out.println("In thread 1 run calling synchronized flag value"+DeadLock.flag);
//				if(!DeadLock.flag) 
				{
					synchronized (DeadLock.TOTAL_COUNT) 
					{
						synchronized (DeadLock.COUNT) 
						{
							DeadLock.TOTAL_COUNT+=DeadLock.COUNT;				
						}
					}
					System.out.println("In thread 1 run "+DeadLock.TOTAL_COUNT);
					DeadLock.flag=true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
