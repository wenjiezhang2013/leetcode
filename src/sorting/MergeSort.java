package sorting;

public class MergeSort {
	public static int[] doMergeSort(int[] array) {

		if (array.length == 1 || array.length == 0 || array == null)
			return array;
		int middle = array.length / 2;

		int[] left = new int[middle];
		
		for (int i = 0; i < middle; i++) {
			left[i] = array[i];
		}
		

		int[] right = new int[array.length - middle];
		for (int i = middle; i < array.length; i++) {
			right[i - middle] = array[i];
		}
		

		if (left.length > 1) {
			left = doMergeSort(left);
		}

		if (right.length > 1) {
			right = doMergeSort(right);
		}

		int[] result = merge(left, right);

		return result;

	}

	private static int[] merge(int[] left, int[] right) {

		int[] result = new int[left.length + right.length];

		int leftIndex = 0;
		int rightIndex = 0;

		while ((leftIndex + rightIndex) < result.length) {
			if (leftIndex < left.length && rightIndex < right.length) {
				if (left[leftIndex] < right[rightIndex]) {
					result[leftIndex + rightIndex] = left[leftIndex];
					leftIndex++;
				} else {
					result[leftIndex + rightIndex] = right[rightIndex];
					rightIndex++;
				}
			}
			else if(leftIndex < left.length) {
				result[leftIndex + rightIndex] = left[leftIndex];
				leftIndex ++;
			}
			else if(rightIndex < right.length) {
				result[leftIndex + rightIndex] = right[rightIndex];
				rightIndex ++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42, 42, -2 };
		int[] arr2 = doMergeSort(arr1);
		for (int i : arr2) {
			System.out.print(String.format("%d ", i));
		}
	}

}
