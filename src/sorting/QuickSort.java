package sorting;

import java.util.Arrays;
import java.util.stream.Stream;

//Complexity O(logn) same as merge sort
public class QuickSort {


	public static void main(String[] args) {
		Integer[] a=new Integer[] {1,2,3,4,5};
		quickSort(a, 0, a.length-1);
		
		Stream<Integer> stream=Arrays.stream(a);
		stream.forEach((x) -> System.out.println(x));
		
	}

	 private static void quickSort(Integer[] a,Integer l,Integer r) {
		if(l<r) {
			Integer q=partition(a, l, r);
			quickSort(a, l, q-1);
			quickSort(a, q+1, r);
		}
	}
	
	
	private static Integer partition(Integer[] a, Integer l,Integer r) {
		Integer pivot=a[r];
		Integer i=l-1;
		for(Integer j=l;j<r;j++) {
			if(a[j]<=pivot) {
				i++;
				Integer temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		Integer temp=a[i+1];
		a[i+1]=pivot;
		a[r]=temp;
		return i+1;
	}
	
}
