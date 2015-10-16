//package sorting;
//
//import java.io.BufferedReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class QuickSort {
//
//	private static void doQuickSort(int[] array, int start, int end) {
//
//		if (array == null || array.length <= 1)
//			return;
//		if (start < end) {
//			int index = partition(array, start, end);
//			if () {
//				doQuickSort(array, result[0], result[1]);
//			}
//		}
//		List<Integer> list = new ArrayList<Integer>();
//		return array;
//
//		
//	}
//
//	private static int partition(int[] array, int start, int end) {
//		int index = (int) (start + (start - end) * Math.random());
//		if(index == end || index == start)
//			return index;
//		else{
//			int pivot = array[index];
//			for (int i = start; i < end; i++) {
//				if(array[i] > pivot) {
//					
//				}
//				else if(array[i] < pivot)
//			}
//		}
//		
//		return index;
//
//	}
//
//	private static void swap(int[] array, int i, int j) {
//		int temp = array[i];
//		array[i] = array[j];
//		array[j] = temp;
//	}
//
//	public static void main(String[] args) {
//		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42, 42, -2 };
//		doQuickSort(arr1, 0, arr1.length - 1);
//		for (int i : arr1) {
//			System.out.print(String.format("%d ", i));
//		}
//	}
//
//}
