package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/reverse-integer/
 * @author wenjiezhang
 *
 */
public class ReverseInteger
{
	public int reverseInteger(int value)
	{
		boolean negative = false;
		
		if(value == 0)
			return 0;
		else if(value < 0)
		{
			negative = true;
			value *= -1;
		}
		
		String valueString = Integer.toString(value);
		
		char[] s = valueString.toCharArray();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = s.length - 1; i>=0; i--)
        {
	        stringBuilder.append(s[i]);
        }
		int result = 0;
		try
        {
			result = Integer.parseInt(stringBuilder.toString());
        } catch (Exception e)
        {
        	return 0;
        }
		
		
		return  result * ( negative ? -1 :1);
	}
}
