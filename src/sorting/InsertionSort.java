package sorting;

import java.util.Arrays;
import java.util.stream.Stream;

//Worst case time complexity is O(n^2)
public class InsertionSort {

	public static void main(String[] args) {
		Integer[] data=new Integer[] {1,4,3,2,6,9,8,7,11,44,31};
		insertionSort(data, 0, data.length);
		printArray(data);
	}
	
	public static void insertionSort(Integer[] data,Integer p,Integer l) {
		for(int j=1;j<data.length;j++) {
			Integer key=data[j];
			int i=j-1;
			while(i>=0 && data[i]>=key) {
				data[i+1]=data[i];
				i--;
			}
			data[i+1]=key;
		}
	}
	
	private static void printArray(Integer[] data) {
		Stream<Integer> stream=Arrays.stream(data);
		stream.forEach((x) -> System.out.println(x));
	}
	
}
