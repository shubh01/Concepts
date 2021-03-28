package javaConcepts;

public class DeadLock {
	public static  Integer COUNT=10;
	public static Integer TOTAL_COUNT=100;
	
	public volatile static Boolean flag=new Boolean(false); 
	
	public static void main(String[] args) throws Exception{
		DeadLock d=new DeadLock();
		Thread1 thread1=new Thread1(COUNT,TOTAL_COUNT,flag);
		Thread2 thread2=new Thread2(COUNT,TOTAL_COUNT,flag);
		Thread t1=new Thread(thread1);
		Thread t2=new Thread(thread2);
		t1.start();
		t2.start();
	}
}
