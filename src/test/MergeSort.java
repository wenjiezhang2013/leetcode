package test;

import java.util.ArrayList;
import java.util.List;


public class MergeSort {

	private int[] array;
	private int[] tempMergArr;
	private int length;

	public static void main(String a[]) {

		int[] inputArr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		MergeSort mms = new MergeSort();
		mms.sort(inputArr);
		for (int i : inputArr) {
//			System.out.print(i);

			System.out.print(i/2);
			System.out.print(" ");
		}
	}

	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
	
	
	private List<Integer> sort2(List<Integer> array){
		
		List<Integer> result = null;
		if(array == null)
			return result;
		int length = array.size();
		List<Integer> left = array.subList(0, length/2);
		List<Integer> right = array.subList(length/2, length);
		
		sort2(left);
		sort2(right);
		result = doMerge(left, right);
		return result;
		
	}
	
	private List<Integer> doMerge(List<Integer> left, List<Integer> right) {

		List<Integer> result = new ArrayList<Integer>();
		
		if(left == null || left.size() == 0)
			return right;
		else if (right == null || right.size() == 0) {
			return left;
		}
		
		
		
		
		return result;
	}
	
	
}