package op.wjz.leetcode;

import java.util.Hashtable;

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
		Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
		int[] result = new int[2];
	 
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index+1 ;
				result[1] = i+1;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
	 
		return result;
	}
	
	public static void main(String[] args) {
		int[] values = {-3,4,3,90};
		int target = 0;
		int[] result = twoSum(values, target);
		System.err.println(result);
	}

}
