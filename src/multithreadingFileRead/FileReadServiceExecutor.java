package multithreadingFileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileReadServiceExecutor implements Runnable{

	private File path;
	private BlockingQueue<String> blockingQueue;
	private CountDownLatch countDownLatch;
	
	public FileReadServiceExecutor() {
		// TODO Auto-generated constructor stub
	}
	
	public FileReadServiceExecutor(File path, BlockingQueue<String> blockingQueue, CountDownLatch countDownLatch) {
		this.path = path;
		this.blockingQueue = blockingQueue;
		this.countDownLatch = countDownLatch;
	}

	public void process(String folderpath) throws Exception{
		File[] fileList=new File(folderpath).listFiles();		
		ExecutorService executorService=Executors.newFixedThreadPool(fileList.length);
		CountDownLatch countDownLatch=new CountDownLatch(fileList.length);
		BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(100000);
		for(File file:fileList) {
				new Thread(new FileReadServiceExecutor(file,blockingQueue,countDownLatch)).start();
				executorService.submit(new DataOperationService(blockingQueue, countDownLatch));
		}
	}
	
	public void run() {
		try {
			BufferedReader bufferedReader=new BufferedReader(new FileReader(this.path));
			String data="";
			while((data=bufferedReader.readLine())!=null) {
				this.blockingQueue.offer(data);
			}
			countDownLatch.countDown();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
