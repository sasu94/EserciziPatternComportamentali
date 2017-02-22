package provaStrategy;

public class MergeSort implements Strategy {

	@Override
	public void sort(Comparable[] a) {

		mergeSort(a, 0, a.length - 1);
	}

	private static void mergeSort(Comparable[] a, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, left, center);
			mergeSort(a, center + 1, right);
			merge(a, left, center + 1, right);
		}
	}

	private static void merge(Comparable[] a, int left, int right, int rightEnd) {
		Comparable[] tmp = new Comparable[a.length];
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd)
			if (a[left].compareTo(a[right]) <= 0)
				tmp[k++] = a[left++];
			else
				tmp[k++] = a[right++];

		while (left <= leftEnd) // Copy rest of first half
			tmp[k++] = a[left++];

		while (right <= rightEnd) // Copy rest of right half
			tmp[k++] = a[right++];

		// Copy tmp back
		for (int i = 0; i < num; i++, rightEnd--)
			a[rightEnd] = tmp[rightEnd];
	}
}
