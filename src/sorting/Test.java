package sorting;

public class Test {

	public static void main(String[] args) {
		Integer[] a=new Integer[] {1,2,3,4,5};
		
		Integer[] b=new Integer[5];
		
		for(int i=0;i<a.length;i++)
			b[i]=a[i];
		
		for(int i=0;i<a.length;i++)
			a[i]=10;
		
		
		for(int i:a)
			System.out.println(i);
		
		System.out.println("b value");
		
		for(int i:b)
			System.out.println(i);
		
	}
	
}
