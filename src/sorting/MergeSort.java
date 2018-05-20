package sorting;

public class MergeSort {

	public static void main(String[] args) {

		int[] a = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		mergeSort(a, 0, a.length - 1);
		for (int d : a)
			System.out.println(d);

	}

	public static void mergeSort(int[] a, Integer p, Integer r) {
		if (p < r) {
			Integer q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	/* Heart of also */
	public static void merge(int[] a, int p, int q, int r) {
		Integer n1 = q - p + 1;
		Integer n2 = r - q;
		int[] l = new int[n1 + 1];
		int[] ri = new int[n2 + 1];

		for (int i = 0; i < n1; i++)
			l[i] = a[p + i];

		for (int j = 0; j < n2; j++)
			ri[j] = a[q + j + 1];
		l[n1] = Integer.MAX_VALUE;
		ri[n2] = Integer.MAX_VALUE;
		Integer j = 0, i = 0, k = p;
		while (k <= r) {
			if (l[i] < ri[j]) {
				a[k] = l[i];
				i++;
			} else {
				a[k] = ri[j];
				j++;
			}
			k = k + 1;
		}
	}

}
