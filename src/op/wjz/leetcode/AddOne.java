package op.wjz.leetcode;

import java.util.Arrays;


/**
 * https://oj.leetcode.com/problems/plus-one/
 * 
 * @author wenjiezhang
 *
 */

public class AddOne
{
	public int[] plusOne(int[] digits) {
		if(digits == null)
            return digits;
        else if(digits.length == 0)
        {
        	int[] result = {1};
        	return result;
        }
        int lastNumber = digits[digits.length - 1];
        
        lastNumber ++;
        
        if(lastNumber <= 9)
        {
        	digits[digits.length - 1] = lastNumber;
        	return digits;
        }
        else
        {
			int[] subDigits = Arrays.copyOf(digits, digits.length - 1);
			subDigits = plusOne(subDigits);
			return Arrays.copyOf(subDigits, subDigits.length + 1);
		}
        
    }
	
	public static void main(String[] args)
    {
	    AddOne n = new AddOne();
	    
	    int[] array = {1, 9};
	    
	    System.out.println(Arrays.toString(n.plusOne(array)));
    }

}
