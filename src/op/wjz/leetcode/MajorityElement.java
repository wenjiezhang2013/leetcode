package op.wjz.leetcode;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/majority-element/
 * 
 * @author wenjiezhang
 *
 */
public class MajorityElement
{

	public int majorityElement(int[] num)
	{
		
		Arrays.sort(num);
		
		return num[Math.round(num.length/2)];
	}
}
