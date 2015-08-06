package sorting;

public class BubbleSort{
	public static int time = 0;

	public static int[] doBubbleSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		return array;

	}

	public static void main(String[] args) {
		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42, 42};
		int[] arr2 = doBubbleSort(arr1);
		for (int i : arr2) {
			System.out.print(String.format("%d ", i));
		}
	}

}
