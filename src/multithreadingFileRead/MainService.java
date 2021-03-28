package multithreadingFileRead;

public class MainService {

	public static void main(String[] args)  throws Exception{
		new FileReadServiceExecutor().process("C:\\Users\\Shubhashish Tiwari\\Desktop\\test");
	}
	
}
